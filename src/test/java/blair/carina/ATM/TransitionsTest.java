package blair.carina.ATM;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by carinablair on 9/16/16.
 */
public class TransitionsTest {
    Transactions transactions;
    @Before
    public void initialize(){transactions = new Transactions(Transactions.TranType.DEPOSIT, 123,1, 10.0);}
//    @Test
//    public void

}
