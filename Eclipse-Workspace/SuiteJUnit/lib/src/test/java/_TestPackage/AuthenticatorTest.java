package _TestPackage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import _ExceptionsPackage.AuthenticationException;
import _SuiteJUnit.Authenticator;

public class AuthenticatorTest {
	@Test
    public void TestLogIn() {
		String username = "Phill Foden";
		String password = "123asd";
		Authenticator authenticator = new Authenticator(username, password);
		assertThrows(AuthenticationException.class, ()-> authenticator.LogIn(username, "123456"));
    }
	
	@Test
    public void TestLogOut() {
		String username = "Phill Foden";
		String password = "123asd";
		Authenticator authenticator = new Authenticator(username, password);
		assertThrows(AuthenticationException.class, ()-> authenticator.LogIn(username, password));
		assertThrows(AuthenticationException.class, ()-> authenticator.LogOut());
    }
}