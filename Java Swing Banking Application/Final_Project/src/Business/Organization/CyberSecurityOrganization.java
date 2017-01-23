/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BankEmployee;
import Business.Role.CyberSecurity;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sumeet
 */
public class CyberSecurityOrganization extends Organization {

    private List<BankEmployee> allBankPersons = new ArrayList<>();

    public CyberSecurityOrganization() {
        super(Organization.Type.CyberSecurity.getValue());
    }

    @Override
    public CyberSecurity getSupportedRole() {
        return new CyberSecurity();
    }

    public List<BankEmployee> getPersons() {
        return allBankPersons;
    }
}
