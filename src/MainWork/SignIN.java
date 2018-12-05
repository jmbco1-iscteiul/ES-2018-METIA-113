package MainWork;

/**
 * 
 * Classe que caracteriza os métodos de autenticação, o e-mail, uma password e o token respetivo de cada utilizador.
 * 
 * @author Brogueira
 *
 */
public class SignIN {
	private String username;
	private String Password;
	private String tokenface;
	private String tokentwitter1;
	private String tokentwitter2;
	private String tokentwitter3;
	private String tokentwitter4;
	private String Email;
	private String pass;
	
	public SignIN(String username, String password, String tokenface, String tokentwitter1, String tokentwitter2,
			String tokentwitter3, String tokentwitter4, String email, String pass) {
		this.username = username;
		Password = password;
		this.tokenface = tokenface;
		this.tokentwitter1 = tokentwitter1;
		this.tokentwitter2 = tokentwitter2;
		this.tokentwitter3 = tokentwitter3;
		this.tokentwitter4 = tokentwitter4;
		Email = email;
		this.pass = pass;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	public String getTokenface() {
		return tokenface;
	}
	
	public void setTokenface(String tokenface) {
		this.tokenface = tokenface;
	}
	
	public String getTokentwitter1() {
		return tokentwitter1;
	}
	
	public void setTokentwitter1(String tokentwitter1) {
		this.tokentwitter1 = tokentwitter1;
	}
	
	public String getTokentwitter2() {
		return tokentwitter2;
	}
	
	public void setTokentwitter2(String tokentwitter2) {
		this.tokentwitter2 = tokentwitter2;
	}
	
	public String getTokentwitter3() {
		return tokentwitter3;
	}
	
	public void setTokentwitter3(String tokentwitter3) {
		this.tokentwitter3 = tokentwitter3;
	}
	
	public String getTokentwitter4() {
		return tokentwitter4;
	}
	
	public void setTokentwitter4(String tokentwitter4) {
		this.tokentwitter4 = tokentwitter4;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}