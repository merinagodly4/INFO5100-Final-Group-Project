/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import static Business.Organization.Organization.Type.ManufacturingOperations;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<Organization>();
        
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;

        switch (type) {
            case SupplierPricing:
                organization = new SupplierPricingOrganization();
                break;
                
            case SupplierMarketing:
                organization = new SupplierMarketingOrganization();
                break;

            case RetailStore:
                organization = new RetailStoreOrganization();
                break;
                
            case RetailDataAnalytics:
                organization = new RetailDataAnalyticsOrganization();
                break;

            case ManufacturingPricing:
                organization = new ManufacturingPricingOrganization();
                break;
            case RetailAnalytics:
                organization = new RetailAnalyticsOrganization();
                break;

            case ManufacturingOperations:
                organization = new ManufacturingOperationsOrganization();
                break;

            case ShippingFacility:
                organization = new ShippingFacilityOrganization();
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
 