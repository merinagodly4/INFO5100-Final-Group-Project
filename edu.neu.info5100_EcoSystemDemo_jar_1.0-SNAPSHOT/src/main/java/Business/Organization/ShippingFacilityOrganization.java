/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

//import Business.Role.LabAssistantRole;
import Business.Role.Role;
import Business.Role.SupplierPricingAnalyst;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ShippingFacilityOrganization extends Organization{

    public ShippingFacilityOrganization() {
        super(Organization.Type.ShippingFacility.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SupplierPricingAnalyst());
        return roles;
    }
    
    public Organization.Type getType() {
    return Organization.Type.ShippingFacility;
}
     
   
    
    
}
