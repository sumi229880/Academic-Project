/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.BankEmployeeOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.BankEmployeeRole.BankEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sumeet
 */
public class BankEmployee extends Role {

    public BankEmployee() {
        super(Role.RoleType.BankPerson);
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new BankEmployeeWorkAreaJPanel(userProcessContainer, account, (BankEmployeeOrganization) organization, enterprise);
    }

    
}
