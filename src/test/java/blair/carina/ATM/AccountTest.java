package blair.carina.ATM;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by carinablair on 9/16/16.
 */
public class AccountTest {
    Account account;

    @Before
    public void initialize(){account = new Account(Account.AccountType.SAVINGS,100.00,123);}

    @Test
    public void getType(){
        Assert.assertEquals("This should return Checking", Account.AccountType.SAVINGS,account.getType());
    }
    @Test
    public void getAccountNumber(){
        Assert.assertEquals("This should return 1",1,account.getAccountNumber());
    }
    @Test
    public void getInterestRate(){
        Assert.assertEquals(0.01,account.getInterestRate(),0);
    }
    @Test
    public void getBalance(){
        Assert.assertEquals(100.0,account.getBalance(),0);
    }
    @Test
    public void getCustomerID(){
        Assert.assertEquals(123,account.getCustomerID(),0);
    }
}
