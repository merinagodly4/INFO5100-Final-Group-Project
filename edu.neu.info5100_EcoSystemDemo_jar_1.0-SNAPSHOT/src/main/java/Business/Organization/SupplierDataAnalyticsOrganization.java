/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;

import Business.Role.SupplierDataAnalystRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class SupplierDataAnalyticsOrganization extends Organization{


    public SupplierDataAnalyticsOrganization() {
        super(Organization.Type.SupplierDataAnalytics.getValue());
    }


    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SupplierDataAnalystRole());
        return roles;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    
}
 