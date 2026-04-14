/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

//import Business.Role.LabAssistantRole;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Role.Role;
import Business.Role.ManufacturingPricingAnalystRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ManufacturingPricingOrganization extends Organization {

    public ManufacturingPricingOrganization() {
        super(Organization.Type.ManufacturingPricing.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ManufacturingPricingAnalystRole());
        return roles;
    }
    
    public Organization.Type getType() {
    return Organization.Type.ManufacturingPricing;
}
}
