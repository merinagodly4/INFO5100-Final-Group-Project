/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author hannahchiou
 */
public class ManufacturingEnterpriseAdminRole extends AdminRole {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            EcoSystem business) {
        // TODO: return new ui.EnterpriseAdminRole.ManufacturerEnterpriseAdminJPanel(
        //           userProcessContainer, enterprise, business);
        return new JPanel();
    }
 
    @Override
    public String toString() {
        return Role.RoleType.ManufacturerEnterpriseAdmin.getValue();
    }
}
