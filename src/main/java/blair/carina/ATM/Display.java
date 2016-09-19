package blair.carina.ATM;

/**
 * Created by carinablair on 9/16/16.
 */
public class Display {

    public void printWelcomeScreen(){
        System.out.println("||||||||||||||||||||||||||||||");
        System.out.println("|||   Welcome to the ATM   |||");
        System.out.printf("|||      1. Login          |||%n|||      2. New Account    |||%n|||      3. Exit           |||%n");
        System.out.println("||||||||||||||||||||||||||||||");

    }

    public void printNewCustomerMenu(){
        System.out.println("////////////////////////////////////");
        System.out.println("///     New Customer Set-Up      ///");
        System.out.println("////////////////////////////////////\n");
        System.out.printf("Name: %nPIN: %n%n");



    }

    public void printLogin(){
        System.out.println("||||||||||||||||||||||||||||||");
        System.out.printf("|||      CustomerID:        |||%n|||           PIN:           |||%n");
        System.out.println("||||||||||||||||||||||||||||||");

    }

    public void printAccountTypes(){
        System.out.println("////////////////////////////////////");
        System.out.println("///      New Account Set-Up      ///");
        System.out.println("////////////////////////////////////\n");
        System.out.printf("1. Checking%n2. Savings%n3. Investment%n%n");
        System.out.printf("Account Type: %nBalance: %n");
    }

    public void printConfirmAccountCreation(){
        System.out.println("Congratulations! You have created a new account. Your account information is below");
    }

    public void errorMessage(){
        System.out.println("Invalid Input");
    }

    public void printReturningCustomerMenu(){

    }

    public void printTransactionMenu(){
        System.out.println("////////////////////////////////////");
        System.out.println("///         Transactions         ///");
        System.out.println("////////////////////////////////////\n");
        System.out.printf("1. Withdrawal%n2. Deposit%n3. Transfer%n4. New Account%n5. Close Account%n6. Logout%n%n");

    }
}
