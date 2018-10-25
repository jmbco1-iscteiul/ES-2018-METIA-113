package facebook;

import MainWork.*;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;

public class Facebook {

//	private final static String accessToken="";//preencher pelo utilizador
//	private final static String ID="";
//	private final static String pass="";
	public SignIN clientFacebook;
	
	private FacebookClient fbClient;
	
	public Facebook(SignIN a) {
		this.clientFacebook = a;
//		autenticacao();
	}

	public void autenticacao() {
		fbClient = new DefaultFacebookClient(clientFacebook.getToken());
		User me = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me.getId());
		System.out.println("Name: " + me.getName());
		System.out.println(me.getName());
		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken(clientFacebook.getMail(),clientFacebook.getPass());
		System.out.println("Expires: " + extendedAccessToken.getExpires());
	}
	
	public SignIN getClientFacebook() {
		return clientFacebook;
	}
}

