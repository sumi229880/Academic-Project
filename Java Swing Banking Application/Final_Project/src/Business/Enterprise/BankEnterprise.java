/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sumeet
 */
public class BankEnterprise extends Enterprise{

    public BankEnterprise(String name) {
        super(name, EnterpriseType.Bank);
    }

    @Override
    public Role getSupportedRole() {
        return null;
    }
    
    
    
}
