
public class SignIN {
	private String protocol;
	private String mail;
	private String pass;
	private String token;

	
	public SignIN (String protocol, String mail, String pass) {
		this.protocol = protocol;
		this.mail = mail;
		this.pass = pass;
	}

	public SignIN(String token) {
		this.token = token;
	}

	public String getMail() {
		return mail;
	}
	
	public String getProtocol() {
		return protocol;
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

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
