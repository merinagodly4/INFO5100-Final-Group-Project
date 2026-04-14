/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author merinanngodly
 */
public class ShippingEnterprise extends Enterprise {
    
    public ShippingEnterprise(String name){
        super(name,Enterprise.EnterpriseType.SHIPPING);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    public Organization.Type getType() {
    return null; // EcoSystem is not a typed organization
}
    
}
