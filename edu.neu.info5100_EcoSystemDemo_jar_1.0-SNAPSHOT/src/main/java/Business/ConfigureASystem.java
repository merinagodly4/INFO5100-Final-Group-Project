package Business;

import Business.Employee.Employee;
import Business.Enterprise.*;
import Business.Network.Network;
import Business.OrderModel.Product;

import Business.OrderModel.WholesaleOrder;
import Business.OrderModel.RetailOrder;
import Business.OrderModel.RetailerProductCatalog;
import Business.OrderModel.Shipment;
import Business.OrderModel.ShipmentDirectory;
import Business.OrderModel.SupplierProductCatalog;
import Business.Organization.Organization;
import Business.Organization.ManufacturingOperationsOrganization;
import Business.Organization.ManufacturingPricingOrganization;
import Business.Organization.RetailStoreOrganization;
import Business.Organization.ShippingFacilityOrganization;
import Business.Organization.SupplierPricingOrganization;
import Business.Organization.SupplierMarketingOrganization;
import Business.Role.*;
import Business.UserAccount.UserAccount;
import com.github.javafaker.Faker;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ConfigureASystem {

    static Faker faker = new Faker(new Random(12345L));

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();
        configureUsers(system);
        // -- Network ----------------------------------------------------------
        Network network = system.createAndAddNetwork();
        network.setName("Boston Network");
        configureUsers(system);
        // -- Enterprises ------------------------------------------------------
        Enterprise supplierEnterprise = network.getEnterpriseDirectory()
                .createAndAddEnterprise("Nike", Enterprise.EnterpriseType.SUPPLIER);

        Enterprise manufacturerEnterprise = network.getEnterpriseDirectory()
                .createAndAddEnterprise("Sports Manufacturing Co.", Enterprise.EnterpriseType.MANUFACTURER);

        Enterprise shippingEnterprise = network.getEnterpriseDirectory()
                .createAndAddEnterprise("USPS", Enterprise.EnterpriseType.SHIPPING);

        Enterprise retailEnterprise = network.getEnterpriseDirectory()
                .createAndAddEnterprise("Dick's Sporting Goods", Enterprise.EnterpriseType.RETAIL);

        // -- Organizations ----------------------------------------------------
        configureOrganizations(supplierEnterprise, manufacturerEnterprise,
                shippingEnterprise, retailEnterprise);

        // -- Product Catalog (owned by supplier) ------------------------------
        configureRetailCatalog(system.getRetailerProductCatalog());
        configureSupplierCatalog(system.getSupplierProductCatalog());

        // -- Shipments (shipment -> supplier) --------------
        SupplierProductCatalog supplierCatalog = system.getSupplierProductCatalog();
        ShipmentDirectory shipmentDirectory = configureShipments(supplierCatalog);

        // -- Wholesale orders (supplier -> retailer)
        configureWholesaleOrders(supplierCatalog);

        return system;
    }

    private static void configureOrganizations(Enterprise supplier,
            Enterprise manufacturer, Enterprise shipping, Enterprise retail) {

        // -----------------------------------------------------------------------
        // SUPPLIER / RETAIL BRAND (Nike)
        // -----------------------------------------------------------------------
        // 1. Supplier Pricing Organization
        //    -> Brand/Supplier Pricing Analyst
        //    -> Retail Data Analyst
        Organization supplierPricingOrg = supplier.getOrganizationDirectory()
                .createOrganization(Organization.Type.SupplierPricing);
        supplierPricingOrg.setName("Supplier Pricing Organization");

        Employee supplierPricingEmp = supplierPricingOrg.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        supplierPricingOrg.getUserAccountDirectory().createUserAccount(
                "supplierpa", "supplierpa", supplierPricingEmp, new SupplierPricingAnalyst());

        Employee supplierDataAnalystEmp = supplierPricingOrg.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        supplierPricingOrg.getUserAccountDirectory().createUserAccount(
                "supplierda", "supplierda", supplierDataAnalystEmp, new SupplierDataAnalystRole());

        // 2. Supplier Marketing Organization
        //    -> Retail Marketing Specialist
        Organization supplierMarketingOrg = supplier.getOrganizationDirectory()
                .createOrganization(Organization.Type.SupplierMarketing);
        supplierMarketingOrg.setName("Supplier Marketing Organization");

        Employee marketingSpecialistEmp = supplierMarketingOrg.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        supplierMarketingOrg.getUserAccountDirectory().createUserAccount(
                "marketingspecialist", "marketingspecialist", marketingSpecialistEmp, new RetailMarketingSpecialistRole());

        // -----------------------------------------------------------------------
        // RETAILER (Dick's Sporting Goods)
        // -----------------------------------------------------------------------
        // 3. Retail Analytics Organization
        //    -> Retail Business Analyst
        Organization retailAnalyticsOrg = retail.getOrganizationDirectory()
                .createOrganization(Organization.Type.RetailStore); // swap type when RetailAnalytics type is added
        retailAnalyticsOrg.setName("Retail Analytics Organization");

        Employee retailBAEmp = retailAnalyticsOrg.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        retailAnalyticsOrg.getUserAccountDirectory().createUserAccount(
                "retailba", "retailba", retailBAEmp, new RetailBusinessAnalystRole());

        // 4. Retail Store Organization - Boston
        //    -> Store Manager + Store Associate
        Organization store1 = retail.getOrganizationDirectory()
                .createOrganization(Organization.Type.RetailStore);
        store1.setName("Dick's - Boston");

        Employee storeManager1Emp = store1.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        store1.getUserAccountDirectory().createUserAccount(
                "storemanager", "storemanager", storeManager1Emp, new StoreManagerRole());

        Employee storeAssociate1Emp = store1.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        store1.getUserAccountDirectory().createUserAccount(
                "storeassociate", "storeassociate", storeAssociate1Emp, new StoreAssociateRole());

        // 5. Retail Store Organization - Providence
        Organization store2 = retail.getOrganizationDirectory()
                .createOrganization(Organization.Type.RetailStore);
        store2.setName("Dick's - Providence");

        Employee storeManager2Emp = store2.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        store2.getUserAccountDirectory().createUserAccount(
                "storemanager2", "storemanager2", storeManager2Emp, new StoreManagerRole());

        Employee storeAssociate2Emp = store2.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        store2.getUserAccountDirectory().createUserAccount(
                "storeassociate2", "storeassociate2", storeAssociate2Emp, new StoreAssociateRole());

        // 6. Retail Store Organization - Worcester
        Organization store3 = retail.getOrganizationDirectory()
                .createOrganization(Organization.Type.RetailStore);
        store3.setName("Dick's - Worcester");

        Employee storeManager3Emp = store3.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        store3.getUserAccountDirectory().createUserAccount(
                "storemanager3", "storemanager3", storeManager3Emp, new StoreManagerRole());

        Employee storeAssociate3Emp = store3.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        store3.getUserAccountDirectory().createUserAccount(
                "storeassociate3", "storeassociate3", storeAssociate3Emp, new StoreAssociateRole());

        // -----------------------------------------------------------------------
        // SHIPPING COMPANY (USPS)
        // -----------------------------------------------------------------------
        // 7. East Shipping Facility
        //    -> Shipping Pricing Analyst + Shipping Coordinator
        Organization eastFacility = shipping.getOrganizationDirectory()
                .createOrganization(Organization.Type.ShippingFacility);
        eastFacility.setName("East Shipping Facility");

        Employee shippingPricingEmp = eastFacility.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        eastFacility.getUserAccountDirectory().createUserAccount(
                "shippingpa", "shippingpa", shippingPricingEmp, new ShippingPricingAnalystRole());

        Employee shippingCoordinatorEmp = eastFacility.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        eastFacility.getUserAccountDirectory().createUserAccount(
                "shippingcoordinator", "shippingcoordinator", shippingCoordinatorEmp, new ShippingCoordinatorRole());

        // 8. West Shipping Facility
        Organization westFacility = shipping.getOrganizationDirectory()
                .createOrganization(Organization.Type.ShippingFacility);
        westFacility.setName("West Shipping Facility");

        Employee shippingPricingEmp2 = westFacility.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        westFacility.getUserAccountDirectory().createUserAccount(
                "shippingpa2", "shippingpa2", shippingPricingEmp2, new ShippingPricingAnalystRole());

        Employee shippingCoordinatorEmp2 = westFacility.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        westFacility.getUserAccountDirectory().createUserAccount(
                "shippingcoordinator2", "shippingcoordinator2", shippingCoordinatorEmp2, new ShippingCoordinatorRole());

        // -----------------------------------------------------------------------
        // MANUFACTURER (Sports Manufacturing Co.)
        // -----------------------------------------------------------------------
        // 9. Manufacturing Pricing Organization (Analytics)
        //    -> Manufacturing Pricing Analyst
        Organization mfgPricingOrg = manufacturer.getOrganizationDirectory()
                .createOrganization(Organization.Type.ManufacturingPricing);
        mfgPricingOrg.setName("Manufacturing Pricing Organization");

        Employee mfgPricingEmp = mfgPricingOrg.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        mfgPricingOrg.getUserAccountDirectory().createUserAccount(
                "manufacturingpa", "manufacturingpa", mfgPricingEmp, new ManufacturingPricingAnalystRole());

        // 10. Manufacturing Operations Organization
        //     -> Production Planner
        Organization mfgOperationsOrg = manufacturer.getOrganizationDirectory()
                .createOrganization(Organization.Type.ManufacturingOperations);
        mfgOperationsOrg.setName("Manufacturing Operations Organization");

        Employee productionPlannerEmp = mfgOperationsOrg.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        mfgOperationsOrg.getUserAccountDirectory().createUserAccount(
                "productionplanner", "productionplanner", productionPlannerEmp, new ProductionPlannerRole());
        
    }

    // System admin only — lives at EcoSystem level
    private static void configureUsers(EcoSystem system) {
       Employee sysAdminEmp = system.getEmployeeDirectory().createEmployee("sysadmin");
        system.getUserAccountDirectory().createUserAccount(
                "sysadmin", "sysadmin", sysAdminEmp, new SystemAdminRole()); 
    }

    // Shared item data: name, price, supplier qty, retail qty
    private static final String[][] PRODUCT_DATA = {
        {"Running Shoes", "129.99", "200", "80"},
        {"Compression Shorts", "34.99", "350", "120"},
        {"Athletic Tank Top", "24.99", "500", "150"},
        {"Yoga Mat", "49.99", "150", "60"},
        {"Sports Bra", "39.99", "300", "100"},
        {"Basketball Jersey", "59.99", "180", "70"},
        {"Cycling Helmet", "89.99", "75", "30"},
        {"Weightlifting Gloves", "19.99", "220", "90"},};

    // Supplier catalog — higher quantities (warehouse stock)
    private static void configureSupplierCatalog(SupplierProductCatalog catalog) {
        
        for (String[] item : PRODUCT_DATA) {
            Product p = catalog.addProduct();
            p.setProdName(item[0]);
            p.setPrice(Double.parseDouble(item[1]));
            p.setAvail(Integer.parseInt(item[2])); // supplier qty (column 2)
        }
    }

    // Retail catalog — lower quantities (store shelf stock)
    private static void configureRetailCatalog(RetailerProductCatalog catalog) {
       
        for (String[] item : PRODUCT_DATA) {
            Product p = catalog.addProduct();
            p.setProdName(item[0]);
            p.setPrice(Double.parseDouble(item[1]));
            p.setAvail(Integer.parseInt(item[3])); // retail qty (column 3)
        }

        // Console verification
        System.out.println("=== Retail Catalog (Dick's - Shelf Stock) ===");
        System.out.printf("%-5s %-25s %-12s %s%n", "ID", "Item", "Price", "Qty");
        System.out.println("-".repeat(50));
        for (Product p : catalog.getProductcatalog()) {
            System.out.printf("%-5d %-25s $%-11.2f %d%n",
                    p.getModelNumber(),
                    p.getProdName(),
                    p.getPrice(),
                    p.getAvail());
        }
    }

    // Create shipments class (CHANGE TO configureShipments)
    private static ShipmentDirectory configureShipments(SupplierProductCatalog catalog) {

        ShipmentDirectory shipmentDirectory = new ShipmentDirectory();

        for (int i = 0; i < 3; i++) {

            Shipment shipment = shipmentDirectory.createShipment();

            shipment.setOrigin(faker.address().city() + ", " + faker.address().stateAbbr());
            shipment.setDestination(faker.address().city() + ", " + faker.address().stateAbbr());
            shipment.setDepartureDate(faker.date().past(7, TimeUnit.DAYS));
            shipment.setEstimatedArrival(faker.date().future(14, 3, TimeUnit.DAYS));

            int itemCount = faker.number().numberBetween(2, 4);
            for (int j = 0; j < itemCount; j++) {
                int randomIndex = faker.number()
                        .numberBetween(0, catalog.getProductcatalog().size());
                Product p = catalog.getProductcatalog().get(randomIndex);
                int qty = faker.number().numberBetween(10, 100);
                shipment.getOrder().addNewOrderItem(p, p.getPrice(), qty);
            }
        }

        return shipmentDirectory;
    }

    // Documents sales from supplier (Nike) to retailer (Dick's)
    private static void configureWholesaleOrders(SupplierProductCatalog supplierCatalog) {

        String[][] stores = {
            {"1", "Dick's - Boston"},
            {"2", "Dick's - Providence"},
            {"3", "Dick's - Worcester"}
        };

        for (String[] store : stores) {
            String storeID = store[0];
            String storeName = store[1];

            WholesaleOrder order = new WholesaleOrder();

            int itemCount = faker.number().numberBetween(3, 6);
            for (int j = 0; j < itemCount; j++) {
                int randomIndex = faker.number()
                        .numberBetween(0, supplierCatalog.getProductcatalog().size());
                Product p = supplierCatalog.getProductcatalog().get(randomIndex);
                int qty = faker.number().numberBetween(5, 50);
                order.addNewOrderItem(p, p.getPrice(), qty);
            }


        }
    }
} 