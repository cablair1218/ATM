package blair.carina.ATM;

import java.util.ArrayList;

/**
 * Created by carinablair on 9/16/16.
 */
public class CustomerManager {
    private ArrayList<Customer> customers = new ArrayList();

    public void addCustomer(Customer customer){

        customers.add(customer);
    }

    public void printCustomers(){
        System.out.println(customers);
    }

    public Customer getCustomer(int customerID){
        for(Customer c: customers){
            if(c.getCustomerID() == customerID){
                return c;
            }
        }
        return null;
    }
}
