package blair.carina.ATM;

import java.util.ArrayList;

/**
 * Created by carinablair on 9/16/16.
 */
public class TransactionManager {
    private ArrayList<Transactions> transactions = new ArrayList();

    public void addTransaction(Transactions.TranType tranType, int customerID, int accountNum, double amount){
        Transactions transaction = new Transactions(tranType,customerID,accountNum,amount);
        transactions.add(transaction);
    }
      /*public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
     */

    public void addTransaction(Transactions.TranType tranType, int customerID, int toAccountNum, int fromAccountNum, double amount){
        Transactions transaction = new Transactions(tranType,customerID, fromAccountNum, toAccountNum, amount);
        transactions.add(transaction);
    }

    public void printTransactions(){
        System.out.println(transactions);
    }

    public String getTransactions(){
        return "";
    }
}
