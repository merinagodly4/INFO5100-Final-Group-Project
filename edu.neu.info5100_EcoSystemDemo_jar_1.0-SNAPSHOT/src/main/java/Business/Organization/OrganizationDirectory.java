/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
    Organization organization = null;

    switch(type){
        case SupplierPricing:
            organization = new SupplierPricingOrganization();
            break;

        case RetailStore:
            organization = new RetailStoreOrganization();
            break;

        case ManufacturingPricing:
            organization = new ManufacturingPricingOrganization();
            break;

        case ManufacturingOperations:
            organization = new ManufacturingOperationsOrganization();
            break;

        default:
            break;
    }

    if (organization != null) {
        organizationList.add(organization);
    }

    return organization;
}
}