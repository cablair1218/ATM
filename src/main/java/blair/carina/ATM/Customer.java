package blair.carina.ATM;

/**
 * Created by carinablair on 9/16/16.
 */
public class Customer {
    private int customerID;
    private int customerIDCounter = 1;
    private String name;
    private int PIN;

    public Customer(String name, int PIN){
        this.name = name;
        this.PIN = PIN;
        this.customerID = customerIDCounter;
        customerIDCounter++;

    }

    public void setName(String name){
        this.name = name;

    }

    public String getName(){
        return name;
    }

    public void setPIN(int PIN){
        this.PIN = PIN;
    }

    public int getPIN(){
        return PIN;
    }

    public int getCustomerID(){
        return customerID;
    }


}
