package blair.carina.ATM;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by carinablair on 9/16/16.
 */
public class AccountManagerTest {
    AccountManager accountManager;

    @Before
    public void initialize(){accountManager = new AccountManager();}
    Account account = new Account(Account.AccountType.CHECKING, 100.00, 123);
    Account account2 = new Account(Account.AccountType.SAVINGS, 100.00, 123);
    Account account3 = new Account(Account.AccountType.SAVINGS,100.00,246);

    @Test
    public void getAccount(){
        accountManager.addAccount(account);
        accountManager.addAccount(account2);
        accountManager.addAccount(account3);
        Assert.assertThat(accountManager.getAccount(123),contains(account,account2));
    }
    @Test
    public void deleteAccount(){
        accountManager.addAccount(account);
        accountManager.addAccount(account2);
        accountManager.deleteAccount(account2);
        Assert.assertThat(accountManager.getAccount(123),contains(account));
    }
}
