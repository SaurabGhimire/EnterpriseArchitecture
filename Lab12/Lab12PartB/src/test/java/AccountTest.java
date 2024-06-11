import bank.domain.Account;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


public class AccountTest {
    @Test
    public void testDeposit() {
        Account account = new Account(1L);
        account.deposit(100.0);
        MatcherAssert.assertThat(account.getBalance(), Matchers.closeTo(100.0, 0.01));
    }

    @Test
    public void testWithdraw() {
        Account account = new Account(1L);
        account.withdraw(10.0);
        MatcherAssert.assertThat(account.getBalance(), Matchers.closeTo(-10.0, 0.01));
    }

    @Test
    public void testDepositEuros() {
        Account account = new Account(1L);
        double euroAmount = 100.0;
        double dollarAmount = euroAmount * 1.07;
        account.deposit(dollarAmount);
        MatcherAssert.assertThat(account.getBalance(), Matchers.closeTo(dollarAmount, 0.01));
    }

    @Test
    public void testWithdrawEuros() {
        Account account = new Account(1L);
        double euroAmount = 100.0;
        double dollarAmount = euroAmount * 1.07;
        account.withdraw(dollarAmount);
        MatcherAssert.assertThat(account.getBalance(), Matchers.closeTo(-dollarAmount, 0.01));
    }
}
