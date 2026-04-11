package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Business.Enterprise.*;
import Business.Network.*;
import Business.EcoSystem;
import Business.Organization.ManufacturingOperationsOrganization;
import Business.Organization.ManufacturingPricingOrganization;
import Business.Organization.RetailStoreOrganization;
import Business.Organization.ShippingFacilityOrganization;
import Business.Organization.SupplierPricingOrganization;
import Business.Role.ManufacturingPricingAnalystRole;
import Business.Role.ProductionPlannerRole;
import Business.Role.RetailBusinessAnalystRole;
import Business.Role.StoreAssociateRole;
import Business.Role.StoreManagerRole;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        
        Network network = system.createAndAddNetwork();
        network.setName("Boston Network");
        //create an enterprise
        Enterprise supplierEnterprise = network.getEnterpriseDirectory()
        .createAndAddEnterprise("Nike", Enterprise.EnterpriseType.SUPPLIER);
        
        Enterprise manufacturerEnterprise = network.getEnterpriseDirectory()
        .createAndAddEnterprise("Sports Manufacturing Co.", Enterprise.EnterpriseType.MANUFACTURER);
        
        Enterprise shippingEnterprise = network.getEnterpriseDirectory()
        .createAndAddEnterprise("USPS", Enterprise.EnterpriseType.SHIPPING);
        
        Enterprise retailEnterprise = network.getEnterpriseDirectory()
        .createAndAddEnterprise("Dick's Sporting Goods", Enterprise.EnterpriseType.RETAIL);
        
        //initialize some organizations
        SupplierPricingOrganization pricingOrg = new SupplierPricingOrganization();
        supplierEnterprise.getOrganizationDirectory().getOrganizationList().add(pricingOrg);
        
        //RetailMarketingOrganization supplierMarketingOrg = new RetailMarketingOrganization();
        //supplierEnterprise.getOrganizationDirectory().getOrganizationList().add(supplierMarketingOrg);
        
       // RetailDataAnalyticsOrganization retailDataAnalyticsOrg = new RetailDataAnalyticsOrganization();
       //retailEnterprise.getOrganizationDirectory().getOrganizationList().add(retailDataAnalyticsOrg);
       
      // RetailAnalyticsOrganization retailAnalyticsOrg = new RetailAnalyticsOrganization();
      //retailEnterprise.getOrganizationDirectory().getOrganizationList().add(retailAnalyticsOrg);
        
       RetailStoreOrganization retailStoreOrg = new RetailStoreOrganization();
       retailEnterprise.getOrganizationDirectory().getOrganizationList().add(retailStoreOrg);

      ShippingFacilityOrganization shippingFacilitiesOrg = new ShippingFacilityOrganization();
      shippingEnterprise.getOrganizationDirectory().getOrganizationList().add(shippingFacilitiesOrg);
      
      ManufacturingPricingOrganization manufacturingPricingOrg = new ManufacturingPricingOrganization();
      manufacturerEnterprise.getOrganizationDirectory().getOrganizationList().add(manufacturingPricingOrg);
      
      ManufacturingOperationsOrganization manufacturingOperationsOrg = new ManufacturingOperationsOrganization();
      manufacturerEnterprise.getOrganizationDirectory().getOrganizationList().add(manufacturingOperationsOrg);


       
        //have some employees 
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        Employee spaEmp = system.getEmployeeDirectory().createEmployee("Supplier Pricing Analyst");
        Employee rdaEmp = system.getEmployeeDirectory().createEmployee("Retail Data Analyst");
        Employee rmsEmp = system.getEmployeeDirectory().createEmployee("Retail Marketing Specialist");
        Employee rbaEmp = system.getEmployeeDirectory().createEmployee("Retail Business Analyst");
        Employee smEmp = system.getEmployeeDirectory().createEmployee("Store Manager");
        Employee sa1 = system.getEmployeeDirectory().createEmployee("StoreAssociate1");
        Employee sa2 = system.getEmployeeDirectory().createEmployee("StoreAssociate2");
        Employee shipPriceEmp = system.getEmployeeDirectory().createEmployee("Shipping Pricing Analyst");
        Employee shipCoordEmp = system.getEmployeeDirectory().createEmployee("Shipping Coordinator");
        Employee mpaEmp = system.getEmployeeDirectory().createEmployee("Manufacturing Pricing Analyst");
        Employee ppEmp = system.getEmployeeDirectory().createEmployee("Production Planner");

        
        
         //create user account
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        //UserAccount spa = system.getUserAccountDirectory().createUserAccount("supplierpa", "supplierpa", spaEmp, new SupplierPricingAnalystRole());
        // UserAccount rda = system.getUserAccountDirectory().createUserAccount("retaildata", "retaildata", rdaEmp, new RetailDataAnalystRole());
        //UserAccount rms = system.getUserAccountDirectory().createUserAccount("retailms", "retailms", rmsEmp, new RetailMarketingSpecialistRole());
        UserAccount rba = system.getUserAccountDirectory().createUserAccount("retailba", "retailba", rbaEmp, new RetailBusinessAnalystRole());
        UserAccount sm = system.getUserAccountDirectory().createUserAccount("storemanager", "storemanager", employee, new StoreManagerRole());
        UserAccount saUser1 = system.getUserAccountDirectory().createUserAccount("storeassociate1", "storeassociate1", sa1, new StoreAssociateRole());
        UserAccount saUser2 = system.getUserAccountDirectory().createUserAccount("storeassociate2", "storeassociate2", sa2, new StoreAssociateRole());
        //UserAccount shipPrice = system.getUserAccountDirectory().createUserAccount("shipprice", "shipprice", shipPriceEmp, new ShippingPricingAnalystRole());
        //UserAccount shipCoord = system.getUserAccountDirectory().createUserAccount("shipcoord", "shipcoord", shipCoordEmp, new ShippingCoordinatorRole());
        UserAccount mpa = system.getUserAccountDirectory().createUserAccount("manufacturingpa", "manufacturingpa", employee, new ManufacturingPricingAnalystRole());
        UserAccount pp = system.getUserAccountDirectory().createUserAccount("productionplanner", "productionplanner", employee, new ProductionPlannerRole());
        
        return system;
    }
    
}
