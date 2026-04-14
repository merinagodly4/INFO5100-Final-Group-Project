/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

//import Business.Role.LabAssistantRole;
import Business.Role.Role;
import Business.Role.ManufacturingPricingAnalystRole;
import Business.Role.ProductionPlannerRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ManufacturingOperationsOrganization extends Organization{

    public ManufacturingOperationsOrganization() {
        super(Organization.Type.ManufacturingOperations.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ProductionPlannerRole());
        return roles;
    }
     
   public Organization.Type getType() {
    return Organization.Type.ManufacturingOperations;
}
    
    
}
