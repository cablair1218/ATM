package blair.carina.ATM;

/**
 * Created by carinablair on 9/16/16.
 */
public class Transactions {

    private TranType transactionType;
    private double amount;
    private int customerID;
    private int fromAccountNumber;
    private int toAccountNumber;


    public enum TranType{
        WITHDRAWAL, DEPOSIT, TRANSFER
    }

    public Transactions(TranType tranType, int customerID, int accountNum, double amount){

    }

    public Transactions(TranType tranType, int customerID, int fromAccountNumber, int toAccountNumber, double amount){

    }



}
