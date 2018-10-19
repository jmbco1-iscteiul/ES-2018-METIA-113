

public class SignIN {
	private String protocol;
	private String mail;
	private String pass;

	public SignIN (String protocol, String mail, String pass) {
		this.protocol = protocol;
		this.mail = mail;
		this.pass = pass;
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

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
