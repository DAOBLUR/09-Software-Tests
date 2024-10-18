package _TestPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import _ExceptionsPackage.AmountException;
import _SuiteJUnit.Account;

public class AccountTest {
	@Test
    public void TestGetBalance() {
		double balance = 125.5555;
		Account account = new Account(balance);
        assertEquals(balance, account.GetBalance());
    }
	
	@Test
    public void TestDeposite() {
		double balance = 125;
		double amount = -100;
		Account account = new Account(balance);
		assertThrows(AmountException.class, ()-> account.Deposite(amount));
    }
	
	@Test
    public void TestWithdraw() {
		double balance = 125.5555;
		double amount = 125.5556;
		Account account = new Account(balance);
		assertThrows(AmountException.class, ()-> account.Withdraw(amount));
    }
	
	@Test
    public void TestMessageWithdraw() {
		double balance = 125.5555;
		double amount = 125.5556;
		//double amount = -125.5556;
		Account account = new Account(balance);
		AmountException amountException = assertThrows(AmountException.class, ()-> account.Withdraw(amount));
		
		assertEquals("Amount less or equal to 0, cant be withdrawn", amountException.getMessage());
    }
}