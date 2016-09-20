package blair.carina.ATM;

/**
 * Created by carinablair on 9/16/16.
 */
public class Account {

    private AccountType type;
    private double balance;
    private int accountNum;
    private double interestRate;
    private static int accountNumCounter = 1;
    private int customerID;

    public enum AccountType{
        CHECKING, SAVINGS, INVESTMENT
    }

    public Account(AccountType type, double balance, int customerID){
        this.customerID = customerID;
        this.type = type;
        this.balance = balance;
        this.setInterestRate();
        this.accountNum = accountNumCounter;
        accountNumCounter++;


    }

    public AccountType getType(){return this.type;}

    public int getAccountNumber(){
        return this.accountNum;
    }

    public void setInterestRate(){
        switch(type){
            case CHECKING:
                this.interestRate = 0;
                break;
            case SAVINGS:
                this.interestRate = .01;
                break;
            case INVESTMENT:
                this.interestRate = .05;
        }
    }

    public double decreaseBalance(double amount){
        this.balance -= amount;
        return balance;
    }
    public double increaseBalance(double amount){
        this.balance += amount;
        return balance;
    }



    public double getCustomerID(){
        return customerID;
    }

    public double getBalance(){
        return balance;
    }


    public double getInterestRate(){
        return this.interestRate;
    }


}
