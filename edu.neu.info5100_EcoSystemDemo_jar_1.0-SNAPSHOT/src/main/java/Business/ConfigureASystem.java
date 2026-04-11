package Business;

import Business.Employee.Employee;
import Business.Enterprise.*;
import Business.Network.Network;
import Business.OrderModel.Product;
import Business.OrderModel.ProductCatalog;
import Business.OrderModel.WholesaleOrder;
import Business.OrderModel.RetailOrder;
import Business.Organization.Organization;
import Business.Organization.ManufacturingOperationsOrganization;
import Business.Organization.ManufacturingPricingOrganization;
import Business.Organization.RetailStoreOrganization;
import Business.Organization.ShippingFacilityOrganization;
import Business.Organization.SupplierPricingOrganization;
import Business.Role.*;
import Business.UserAccount.UserAccount;
import com.github.javafaker.Faker;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ConfigureASystem {

    static Faker faker = new Faker(new Random(12345L));

    // set seed
    static String[] itemNames = {
        "Running Shoes", "Compression Shorts", "Athletic Tank Top",
        "Yoga Mat", "Sports Bra", "Basketball Jersey", "Swim Goggles",
        "Tennis Racket", "Cycling Helmet", "Weightlifting Gloves",
        "Track Pants", "Soccer Cleats", "Hiking Boots", "Swim Cap",
        "Resistance Bands"
    };

    static String[] categories = {
        "Footwear", "Apparel", "Equipment", "Accessories", "Outerwear"
    };

    static String[] regions = {
        "Northeast", "Southeast", "Midwest", "Southwest", "West Coast"
    };

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        // -- Network ----------------------------------------------------------
        Network network = system.createAndAddNetwork();
        network.setName("Boston Network");

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
        ProductCatalog catalog = configureProductCatalog();

        // -- Wholesale Orders / Shipments (supplier -> retailer) --------------
        configureWholesaleOrders(catalog);

        // -- Retail Orders (what's on shelves at Dick's) ----------------------
        configureRetailOrders(catalog);

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

        Employee retailDataAnalystEmp = supplierPricingOrg.getEmployeeDirectory()
                .createEmployee(faker.name().fullName());
        supplierPricingOrg.getUserAccountDirectory().createUserAccount(
                "retaildataanalyst", "retaildataanalyst", retailDataAnalystEmp, new RetailDataAnalystRole());

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

    private static ProductCatalog configureProductCatalog() {

        ProductCatalog catalog = new ProductCatalog();

        String[][] items = {
            {"Running Shoes", "Footwear", "129.99", "200"},
            {"Compression Shorts", "Apparel", "34.99", "350"},
            {"Athletic Tank Top", "Apparel", "24.99", "500"},
            {"Yoga Mat", "Equipment", "49.99", "150"},
            {"Sports Bra", "Apparel", "39.99", "300"},
            {"Basketball Jersey", "Apparel", "59.99", "180"},
            {"Cycling Helmet", "Accessories", "89.99", "75"},
            {"Weightlifting Gloves", "Accessories", "19.99", "220"},};

        for (String[] item : items) {
            Product p = catalog.addProduct();
            p.setProdName(item[0]);
            p.setPrice(Double.parseDouble(item[2]));
            p.setAvail(Integer.parseInt(item[3]));
        }

        return catalog;
    }

    // Create a supplier catalog and retailer catalog (documents their current inventory) 
    // (products same; quantity different) 
    // Create shipments class (CHANGE TO configureShipments)
    private static void configureWholesaleOrders(ProductCatalog catalog) {

        for (int i = 0; i < 3; i++) {
            WholesaleOrder order = new WholesaleOrder();

            // Pick 2-3 random products per shipment
            int itemCount = faker.number().numberBetween(2, 4);
            for (int j = 0; j < itemCount; j++) {
                int randomIndex = faker.number()
                        .numberBetween(0, catalog.getProductcatalog().size());
                Product p = catalog.getProductcatalog().get(randomIndex);
                int qty = faker.number().numberBetween(10, 100);
                order.addNewOrderItem(p, p.getPrice(), qty);
            }

            String origin = faker.address().city() + ", "
                    + faker.address().stateAbbr();
            String destination = faker.address().city() + ", "
                    + faker.address().stateAbbr();

            System.out.println("=== Wholesale Shipment #" + (i + 1) + " ===");
            System.out.println("From:      " + origin);
            System.out.println("To:        " + destination);
            System.out.println("Departed:  "
                    + faker.date().past(7, TimeUnit.DAYS));
            System.out.println("Est. Arr.: "
                    + faker.date().future(14, 3, TimeUnit.DAYS));
            System.out.println("Items:");
            for (var oi : order.getOrderItemList()) {
                System.out.printf("  - %-25s qty: %d  @ $%.2f%n",
                        oi.getProduct().getProdName(),
                        oi.getQuantity(),
                        oi.getSalesPrice());
            }
            System.out.println();
        }
    }

    // Retail orders for each retail store
    // Store IDs
    // Change to configureWholesaleOrders (supplier data analyst)
    // On supplier side: documents sales from supplier to retailer
    // Get product IDs
    private static void configureRetailOrders(ProductCatalog catalog) {

        String[] storeNames = {
            "Dick's - Boston", "Dick's - Providence", "Dick's - Worcester"
        };

        for (String store : storeNames) {
            RetailOrder order = new RetailOrder();

            int itemCount = faker.number().numberBetween(3, 6);
            for (int j = 0; j < itemCount; j++) {
                int randomIndex = faker.number()
                        .numberBetween(0, catalog.getProductcatalog().size());
                Product p = catalog.getProductcatalog().get(randomIndex);
                int qty = faker.number().numberBetween(5, 50);
                order.addNewOrderItem(p, p.getPrice(), qty);
            }

            System.out.println("=== Retail Inventory: " + store + " ===");
            System.out.printf("%-25s %-12s %s%n", "Item", "Price", "Qty");
            System.out.println("-".repeat(45));
            for (var oi : order.getOrderItemList()) {
                System.out.printf("%-25s $%-11.2f %d%n",
                        oi.getProduct().getProdName(),
                        oi.getSalesPrice(),
                        oi.getQuantity());
            }
            System.out.println();
        }
    }
}
