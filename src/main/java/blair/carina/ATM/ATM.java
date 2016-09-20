package blair.carina.ATM;

import java.util.ArrayList;

/**
 * Created by carinablair on 9/16/16.
 */
public class ATM {
    private Account account;
    private Customer customer;
    private Display display;
    private UserInputHandler userInputHandler;
    private int currentCustomerID;
    private boolean running;
    private TransactionManager transactionManager;
    private CustomerManager customerManager;
    private AccountManager accountManager;
    private ArrayList<Account> customerAccounts;

    public ATM(){
        this.running = true;
        this.display = new Display();
        this.userInputHandler = new UserInputHandler();
        this.transactionManager = new TransactionManager();
        this.customerManager = new CustomerManager();
        this.accountManager = new AccountManager();

    }

    public void startATM(){
        display.printWelcomeScreen();
        while(running){
            int option = userInputHandler.getUserInt();
            switch(option){
                case 1:
                    display.printLogin();
                    int loginCustomerID = userInputHandler.getUserInt();
                    int loginPin = userInputHandler.getUserInt();
                    if(verifyLoginInfo(loginCustomerID, loginPin)) {
                        currentCustomerID = loginCustomerID;
                        this.accessCustomerAccount();
                    }
                    else{
                        display.errorMessage();
                        this.startATM();
                    }
                    break;
                case 2:
                    display.printNewCustomerMenu();
                    String newName = userInputHandler.getUserString();
                    int newPIN = userInputHandler.getUserInt();
                    this.customer = new Customer(newName,newPIN);
                    this.customerManager.addCustomer(this.customer);
                    System.out.printf("Your customer ID is %d. You will need this every time you visit the ATM.%n", this.customer.getCustomerID());
                    this.currentCustomerID = customer.getCustomerID();
                    display.printAccountTypes();
                    this.accountTypeOptions();
                    break;
                case 3:
                    this.exitProgram();
                    break;
                default:
                    display.errorMessage();
                    break;
            }

        }
    }

    public void accountTypeOptions(){
        String option = userInputHandler.getUserString();
        Account.AccountType type = Account.AccountType.valueOf(option.toUpperCase());
        double newAccountBalance = userInputHandler.getUserDouble();
        switch (type) {
            case CHECKING:
                account = new Account(type, newAccountBalance, currentCustomerID);
                accountManager.addAccount(account);
                display.printConfirmAccountCreation();
                System.out.printf("Checking Account%nBalance: %.2f%n",newAccountBalance);
                this.startATM();
                break;
            case SAVINGS:
                account = new Account(type, newAccountBalance, currentCustomerID);
                accountManager.addAccount(account);
                display.printConfirmAccountCreation();
                System.out.printf("Savings Account%nBalance: %.2f%nInterest Rate: %.2f%n",newAccountBalance, account.getInterestRate());
                this.startATM();
                break;
            case INVESTMENT:
                account = new Account(type, newAccountBalance, currentCustomerID);
                accountManager.addAccount(account);
                display.printConfirmAccountCreation();
                System.out.printf("Investment Account%nBalance: %.2f%nInterest Rate: %.2f%n",newAccountBalance,account.getInterestRate());
                this.startATM();
                break;
            default:
                display.errorMessage();
                this.accountTypeOptions();
        }



    }

    public void accessTransactions(){
        int option = userInputHandler.getUserInt();
        double amount;
        switch(option){
            case 1:
                System.out.println("Enter Amount: ");
                amount = userInputHandler.getUserDouble();
                this.withdrawal(amount);
                System.out.println("Your new balance: " + account.getBalance());
                this.accessTransactions();
                break;
            case 2:
                System.out.println("Enter Amount: ");
                amount = userInputHandler.getUserDouble();
                this.deposit(amount);
                System.out.println("Your new balance: " + account.getBalance());
                this.accessTransactions();
                break;
            case 3:
                if(customerAccounts.size() == 1){
                    display.errorMessage();
                    System.out.println("You only have one account. Would you like to open a new account?");
                    String choice = userInputHandler.getUserString();
                    if(choice == "yes"){
                        display.printAccountTypes();
                        this.accountTypeOptions();
                    }
                    else{
                        this.accessTransactions();
                    }
                }
                else {
                    int toAccountNum=0;
                    System.out.println("Enter Amount: ");
                    amount = userInputHandler.getUserDouble();
                    System.out.println("Enter Destination Account: ");
                    String type = userInputHandler.getUserString();
                    Account.AccountType accountType = Account.AccountType.valueOf(type.toUpperCase());
                    Account destAccount = account;
                    for(Account a: customerAccounts){
                        if(a.getType() == accountType){
                            toAccountNum = a.getAccountNumber();
                            destAccount=a;
                            break;
                        }
                        else{
                            display.errorMessage();
                            this.accessTransactions();
                        }
                    }
                    this.transfer(amount,destAccount,toAccountNum);
                    this.accessTransactions();
                }
                break;
            case 4:
                double balance = account.getBalance();
                System.out.printf("You're Balance is: %.2f",balance);
                this.accessTransactions();
                break;
            case 5:
                display.printAccountTypes();
                customer = customerManager.getCustomer(currentCustomerID);
                this.accountTypeOptions();
                break;
            case 6:
                boolean checkBalance = this.isAccountBalanceZero(account.getAccountNumber());
                if(checkBalance){
                    this.closeAccount();
                }
                else{
                    System.out.println("You're account must have $0.00 balance.");

                }
                this.startATM();
                break;
            case 7:
                this.startATM();
                break;
            default:
                display.errorMessage();
                this.accessTransactions();

        }

    }

    public void accessCustomerAccount(){
        customerAccounts = accountManager.getAccount(currentCustomerID);
        switch(customerAccounts.size()){
            case 1:
                display.printTransactionMenu();
                this.accessTransactions();
                break;
            case 2:
                String accountType1 = (customerAccounts.get(0).getType()).toString();
                String accountType2 = (customerAccounts.get(1).getType()).toString();
                display.printAccountMenu();
                System.out.printf("Choose Account: %n%s%n%s%n",accountType1,accountType2);
                String option = userInputHandler.getUserString();
                if(option == accountType1){
                    account = customerAccounts.get(0);
                }
                else{
                    account =customerAccounts.get(1);
                }
                display.printTransactionMenu();
                this.accessTransactions();
                break;
            case 3:
                String accountTypeFirst = (customerAccounts.get(0).getType()).toString();
                String accountTypeSecond = (customerAccounts.get(1).getType()).toString();
                String accountTypeThird = (customerAccounts.get(2).getType()).toString();
                display.printAccountMenu();
                System.out.printf("Choose Account: %n%s%n%s%n",accountTypeFirst,accountTypeSecond,accountTypeThird);
                String choice = userInputHandler.getUserString();
                if(choice == accountTypeFirst){
                    account = customerAccounts.get(0);
                }
                else if(choice == accountTypeSecond){
                    account =customerAccounts.get(1);
                }
                else{
                    account =customerAccounts.get(2);
                }
                display.printTransactionMenu();
                this.accessTransactions();
                break;
        }


    }

    public void withdrawal(double amount){
        account.decreaseBalance(amount);
        transactionManager.addTransaction(Transactions.TranType.WITHDRAWAL,currentCustomerID,account.getAccountNumber(),amount);
    }

    public void deposit(double amount){
        account.increaseBalance(amount);
        transactionManager.addTransaction(Transactions.TranType.DEPOSIT,currentCustomerID,account.getAccountNumber(),amount);
    }

    public void transfer(double amount,Account destAccount, int toAccountNum){
        account.decreaseBalance(amount);
        destAccount.increaseBalance(amount);
        transactionManager.addTransaction(Transactions.TranType.TRANSFER,currentCustomerID,toAccountNum,account.getAccountNumber(),amount);
    }

    public boolean verifyLoginInfo(int customerID, int PIN){
        if(customerManager.getCustomer(customerID) != null) {
            if (customerManager.getCustomer(customerID).getCustomerID() == customerID && customerManager.getCustomer(customerID).getPIN() == PIN) {
                return true;
            }
        }
        return false;
    }

    public boolean isAccountBalanceZero(int accountNum){
        for(Account a: customerAccounts){
            if(a.getAccountNumber()==accountNum){
                if(a.getBalance() == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;

    }

    public void closeAccount(){


    }

    public void exitProgram(){
        running = false;
        System.exit(0);

    }

}
