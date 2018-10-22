package facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;

public class Facebook {

	private final static String accessToken="";//preencher pelo utilizador
	private final static String ID="";
	private final static String pass="";
	
	private FacebookClient fbClient;
	
	public Facebook() {
		
		autenticacao();
	}

	public void autenticacao() {
		fbClient = new DefaultFacebookClient(accessToken);
		User me = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me.getId());
		System.out.println("Name: " + me.getName());
		System.out.println(me.getName());
		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken(ID,pass);
		System.out.println("Expires: " + extendedAccessToken.getExpires());
	}
	
	
	
	
	public static void main(String[] args) {
		new Facebook();
	}
}

