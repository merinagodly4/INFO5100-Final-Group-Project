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
public class RetailStoreOrganization extends Organization{

    private int storeID;
    private static int storeCounter = 0;

    public RetailStoreOrganization() {
        super(Organization.Type.RetailStore.getValue());
        this.storeID = ++storeCounter;
    }

    public int getStoreID() {
        return storeID;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new StoreManagerRole());
        roles.add(new StoreAssociateRole());
        roles.add(new RetailBusinessAnalystRole());
        return roles;
    }

    @Override
    public String toString() {
        return "[Store #" + storeID + "] " + getName();
    }
    
    
}
 