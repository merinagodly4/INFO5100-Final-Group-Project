/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author hannahchiou
 */
public class SupplierMarketingOrganization extends Organization {

    public SupplierMarketingOrganization() {
        super(Organization.Type.SupplierMarketing.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return new ArrayList<Role>(); 
    }
    
    public Organization.Type getType() {
    return Organization.Type.SupplierMarketing;
}
}
 