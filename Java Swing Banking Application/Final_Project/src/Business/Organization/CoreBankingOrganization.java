/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CoreBanking;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sumeet
 */
public class CoreBankingOrganization extends Organization{

    public CoreBankingOrganization() {
        super(Organization.Type.Security.getValue());
    }

    @Override
    public CoreBanking getSupportedRole() {
        return new CoreBanking();
    }
     
   
    
    
}
