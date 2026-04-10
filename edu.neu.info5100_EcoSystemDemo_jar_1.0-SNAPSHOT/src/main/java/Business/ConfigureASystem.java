package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Business.Enterprise.*;
import Business.Network.*;
import Business.EcoSystem;
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
        //have some employees 
        //create user account
        
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        UserAccount sm = system.getUserAccountDirectory().createUserAccount("storemanager", "storemanager", employee, new StoreManagerRole());
        UserAccount sa = system.getUserAccountDirectory().createUserAccount("storeassociate", "storeassociate", employee, new StoreAssociateRole());
        UserAccount rba = system.getUserAccountDirectory().createUserAccount("retailba", "retailba", employee, new RetailBusinessAnalystRole());
        
        return system;
    }
    
}
