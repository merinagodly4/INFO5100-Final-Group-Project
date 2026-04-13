/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import ui.ManufacturingPricingAnalystWorkArea.ManufacturingPricingAnalystMenuJPanel;


/**
 *
 * @author merinanngodly
 */
public class ManufacturingPricingAnalystRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ManufacturingPricingAnalystMenuJPanel(userProcessContainer, account, organization, business, enterprise);
    }
    
}
