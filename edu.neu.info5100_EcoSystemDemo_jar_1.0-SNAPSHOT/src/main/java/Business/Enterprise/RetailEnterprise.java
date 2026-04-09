/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author merinanngodly
 */
public class RetailEnterprise extends Enterprise {
    
    public RetailEnterprise(String name){
        super(name,Enterprise.EnterpriseType.RETAIL);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
