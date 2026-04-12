/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.StoreManagerRole;
import Business.Role.StoreAssociateRole;
import Business.Role.RetailBusinessAnalystRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class RetailAnalyticsOrganization extends Organization{


    public RetailAnalyticsOrganization() {
        super(Organization.Type.RetailAnalytics.getValue());
    }


    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RetailBusinessAnalystRole());
        return roles;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    
}
 