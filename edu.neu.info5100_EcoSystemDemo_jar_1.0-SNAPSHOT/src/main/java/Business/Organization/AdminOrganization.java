/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.SupplierEnterpriseAdminRole;
import Business.Role.RetailerEnterpriseAdminRole;
import Business.Role.ShippingEnterpriseAdminRole;
import Business.Role.ManufacturingEnterpriseAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class AdminOrganization extends Organization {

    public AdminOrganization() {
        super(Organization.Type.Admin.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SupplierEnterpriseAdminRole());
        roles.add(new RetailerEnterpriseAdminRole());
        roles.add(new ShippingEnterpriseAdminRole());
        roles.add(new ManufacturingEnterpriseAdminRole());
        return roles;
    }

    public Organization.Type getType() {
        return Organization.Type.Admin;
    }

}
