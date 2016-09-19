package blair.carina.ATM;

import java.util.ArrayList;

/**
 * Created by carinablair on 9/16/16.
 */
public class AccountManager {
    private ArrayList<Account> accounts = new ArrayList();

    public void addAccount(Account account){
        accounts.add(account);

    }
    public void addAccount(Account.AccountType accountType, double amount, int customerID){

    }

    /*public void deleteAccount(Account account){

    }*/

    public void deleteAccount(int accountNum, int customerID){

    }

    public void printAccounts(){
        System.out.println(accounts);
    }

    public Account getAccount(int customerID){
        for(Account a: accounts)
        if(a.getCustomerID() == customerID) {
            return a;
        }
        return null;
    }

}
