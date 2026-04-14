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
public class SupplierPricingOrganization extends Organization {

    public SupplierPricingOrganization() {
        super(Organization.Type.SupplierPricing.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SupplierPricingAnalyst());
        return roles;
    }

    public Organization.Type getType() {
        return Organization.Type.SupplierPricing;
    }

}
