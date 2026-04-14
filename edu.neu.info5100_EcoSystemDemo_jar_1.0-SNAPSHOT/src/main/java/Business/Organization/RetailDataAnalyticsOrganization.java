/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.RetailBusinessAnalystRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class RetailDataAnalyticsOrganization extends Organization{


    public RetailDataAnalyticsOrganization() {
        super(Organization.Type.RetailDataAnalytics.getValue());
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

    @Override
    public Type getType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
 