package _SuiteJUnit;

import _ExceptionsPackage.AuthenticationException;

//https://github.com/mono0926/Python-3-Object-Oriented-Programming/blob/master/1261_04_Code/auth.py

public class Authenticator {
	private String Username = "";
	private String Password = "";
	private Boolean LoggedIn = false;
	
	public Authenticator (String username, String password) {
		this.Username = username;
		this.Password = password;
		this.LoggedIn = false;
	}
	
	public void LogIn(String username, String password) throws AuthenticationException {
		if(username != this.Username) throw new AuthenticationException("Invalid username");
		else if(password != this.Password) throw new AuthenticationException("Invalid password");
		else this.LoggedIn = true;
	}
	
	public void LogOut() throws AuthenticationException {
		if(this.LoggedIn != true) throw new AuthenticationException("Error in log status");
		else this.LoggedIn = false;
	}
}