package blair.carina.ATM;

import java.util.ArrayList;

/**
 * Created by carinablair on 9/16/16.
 */
public class AccountManager {
    private ArrayList<Account> accounts = new ArrayList();
    private ArrayList <Account> customerAccounts = new ArrayList();

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void deleteAccount(Account account){
        accounts.remove(account);
    }

    public void printAccounts(){
        System.out.println(accounts);
    }

    public ArrayList<Account> getAccount(int customerID){
        for(Account a: accounts) {
            if (a.getCustomerID() == customerID) {
                customerAccounts.add(a);
            }
        }
        return customerAccounts;
    }

}
