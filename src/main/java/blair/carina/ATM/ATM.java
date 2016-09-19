package blair.carina.ATM;

/**
 * Created by carinablair on 9/16/16.
 */
public class ATM {
    private Transactions transactions;
    private Account account;
    private Customer customer;
    private Display display;
    private UserInputHandler userInputHandler;
    private int currentCustomerID;
    private boolean running;
    private TransactionManager transactionManager;
    private CustomerManager customerManager;
    private AccountManager accountManager;

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
                        display.printTransactionMenu();

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
                    customer = new Customer(newName,newPIN);
                    customerManager.addCustomer(newName,newPIN);
                    System.out.printf("Your customer ID is %d. You will need this every time you visit the ATM.%n", customer.getCustomerID());
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
                account = new Account(type, newAccountBalance, customer.getCustomerID());
                accountManager.addAccount(account);
                display.printConfirmAccountCreation();
                System.out.printf("Checking Account%nBalance: %.2f%n",newAccountBalance);
                this.startATM();
                break;
            case SAVINGS:
                account = new Account(type, newAccountBalance, customer.getCustomerID());
                accountManager.addAccount(account);
                display.printConfirmAccountCreation();
                System.out.printf("Savings Account%nBalance: %d%nInterest Rate: %.2f%n",newAccountBalance, account.getInterestRate());
                this.startATM();
                break;
            case INVESTMENT:
                account = new Account(type, newAccountBalance, customer.getCustomerID());
                accountManager.addAccount(account);
                display.printConfirmAccountCreation();
                System.out.printf("Investment Account%nBalance: %d%nInterest Rate: %.2f%n",newAccountBalance,account.getInterestRate());
                this.startATM();
                break;
            default:
                display.errorMessage();
                this.accountTypeOptions();
        }



    }

    public void accessServices(){

        int option = userInputHandler.getUserInt();
        double amount;
        switch(option){
            case 1:
                System.out.println("Enter Amount: ");
                amount = userInputHandler.getUserInt();
                account = accountManager.getAccount(currentCustomerID);
                this.withdrawal(amount, currentCustomerID, account.getAccountNumber());
                transactionManager.addTransaction(Transactions.TranType.WITHDRAWAL,currentCustomerID,account.getAccountNumber(),amount);
                break;
            case 2:
                System.out.println("Enter Amount: ");
                amount = userInputHandler.getUserInt();
                account = accountManager.getAccount(currentCustomerID);
                this.deposit(amount, currentCustomerID, account.getAccountNumber());
                transactionManager.addTransaction(Transactions.TranType.DEPOSIT,currentCustomerID,account.getAccountNumber(),amount);
                break;
            case 3:
                System.out.println("Enter Amount: ");
                amount = userInputHandler.getUserInt();
                System.out.println("Enter ");
                account = accountManager.getAccount(currentCustomerID);
                this.withdrawal(amount, currentCustomerID, account.getAccountNumber());
                break;

        }

    }

    public void withdrawal(double amount, int customerID, int accountNumber){

    }

    public void deposit(double amount, int customerID, int accountNumber){

    }

    public void transfer(double amount, int customerID, int toAccountNumber, int fromAccountNumber){

    }

    public void accessCustomerAccount(){





    }

    public void logout(){
        display.printWelcomeScreen();
    }

    public boolean verifyLoginInfo(int customerID, int PIN){
        int checkCustomerID = customerManager.getCustomer(customerID).getCustomerID();
        int checkPIN = customerManager.getCustomer(customerID).getPIN();

        if(customerID==checkCustomerID){
            if(PIN==checkPIN){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public void createAccount(int customerID, int accountNum){

    }

    public boolean isAccountBalanceZero(int customerID, int accountNum){
        boolean response = false;
        return response;

    }

    public void closeAccount(){

    }

    public void exitProgram(){
        running = false;
        System.exit(0);

    }

}
