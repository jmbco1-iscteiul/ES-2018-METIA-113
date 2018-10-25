package facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;

public class Facebook {

	private final static String accessToken="EAAD45TT4030BAAqmRlmlZBIE6yrm09US3SWzyysV3ESTZAAvBRFPfZCB4Yrwy49x3Jy0dLsy1KDgd2ZB9ZBRLiDfZCvSk4pqPbZBYLKZCZB4ZB2K7MIzRDqf8a1aK4q6ZB89ZCYFLmjaAUNnUHHaWrivATReq3NfodNgGpqZBvCyJe5JMIAZDZD";//preencher pelo utilizador
	private final static String ID="273663319921533";
	private final static String pass="dcc1e2de5a8a44804e89913f31dcd496";
	
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

