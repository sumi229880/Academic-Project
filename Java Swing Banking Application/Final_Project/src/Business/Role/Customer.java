/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.BankManagerOrganization;
import Business.Organization.BankEmployeeOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.SignUp.SignUp;

/**
 *
 * @author Sumeet
 */
public class Customer extends Role {

    
    public Customer() {
        super(RoleType.Customer);
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new SignUp(userProcessContainer, enterprise, (BankEmployeeOrganization) organization);
    }
    
}
