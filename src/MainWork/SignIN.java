package MainWork;

public class SignIN {
	private String mail;
	private String pass;
	private String token;
	
	public SignIN (String token, String mail, String pass) {
		this.token = token;
		this.mail = mail;
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}
	
	public String getPass() {
		return pass;
	}

	public String getToken() {
		return token;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
