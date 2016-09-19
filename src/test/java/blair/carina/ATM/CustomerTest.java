package blair.carina.ATM;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by carinablair on 9/16/16.
 */
public class CustomerTest {
    Customer customer;

    @Before
    public void initialize(){customer = new Customer("Carina Blair", 1234);}

    @Test
    public void getName(){
        customer.setName("Carina A. Blair");
        Assert.assertEquals("This should return Carina A. Blair", "Carina A. Blair", customer.getName());
    }
    @Test
    public void getPIN(){
        customer.setPIN(1235);
        Assert.assertEquals("This should return 1235", 1235, customer.getPIN());
    }
    @Test
    public void getCustomerID(){
        Assert.assertEquals("This should return 1",1,customer.getCustomerID());
    }
}
