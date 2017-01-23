/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BankManager;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sumeet
 */
public class BankManagerOrganization extends Organization {

    public BankManagerOrganization() {
        super(Type.BankManager.getValue());
    }

    @Override
    public BankManager getSupportedRole() {
        return new BankManager();
    }

}
