package facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

import MainWork.SignIN;

public class Facebook {

	private final static String accessToken="EAAD45TT4030BAMppoeRyc1RtdOfUzobKEP18LZCzAmZB9vzxZA3WafngiZBvZCE00TJm6cFyUwEKcOx4hdKJYuJQkDX5DPk5kdjo8321wWGRl6ZCYmkiXVMdAmxkuW205CGKpBDB4Ek9w71RJiXGtIX29iYPVZCQ8MZD";//preencher pelo utilizador
	private final static String ID="273663319921533";
	private final static String pass="dcc1e2de5a8a44804e89913f31dcd496";
	public SignIN clientFacebook;
	
	private FacebookClient fbClient;
	
	public Facebook(SignIN a) {
		this.clientFacebook = a;
		autenticacao();
	}

	
	public void autenticacao() {
		fbClient = new DefaultFacebookClient(clientFacebook.getToken());
		User me = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me.getId());
		System.out.println("Name: " + me.getName());
		System.out.println(me.getName());
		//AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken(clientFacebook.getMail(),clientFacebook.getPass());
		//System.out.println("Expires: " + extendedAccessToken.getExpires());
	}
	
	public SignIN getClientFacebook() {
		return clientFacebook;
	}
}

