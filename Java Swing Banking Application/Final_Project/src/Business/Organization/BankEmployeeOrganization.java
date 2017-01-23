/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BankEmployee;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sumeet
 */
public class BankEmployeeOrganization extends Organization {

    private List<BankEmployee> allBankPersons = new ArrayList<>();

    public BankEmployeeOrganization() {
        super(Organization.Type.BankPerson.getValue());
    }

    @Override
    public Role getSupportedRole() {
        return new BankEmployee();
    }

    public List<BankEmployee> getBankPersons() {
        return allBankPersons;
    }
    
    
}
