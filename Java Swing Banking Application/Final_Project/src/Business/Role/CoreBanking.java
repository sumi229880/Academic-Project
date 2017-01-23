/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.CoreBankingTeamRole.CoreBankingTeamWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sumeet
 */
public class CoreBanking extends Role {

    public CoreBanking() {
        super(RoleType.Security);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CoreBankingTeamWorkAreaJPanel(userProcessContainer, account, organization, business, enterprise);
    }

}
