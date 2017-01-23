/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Sumeet
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.BankPerson.getValue())){
            organization = new BankEmployeeOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Security.getValue())){
            organization = new CoreBankingOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.CyberSecurity.getValue())) {
            organization = new CyberSecurityOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}