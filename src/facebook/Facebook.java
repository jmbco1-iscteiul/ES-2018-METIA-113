package facebook;

import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;
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
		search("a todos");
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
	
	public void search(String palavra) {
		Connection<Post> result = fbClient.fetchConnection("me/feed",Post.class);
		System.out.println("\nPosts:");
		int counter5 = 0;
		int counterTotal = 0;

		for (List<Post> page : result) {
			for (Post aPost : page) {
				if (aPost.getMessage() != null && aPost.getMessage().contains(palavra)) {
					System.out.println("---- Post "+ counter5 + " ----");
					System.out.println("Id: "+"fb.com/"+aPost.getId());
					System.out.println("Message: "+aPost.getMessage());
					System.out.println("Created: "+aPost.getCreatedTime());
					counter5++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nNo of Results: " + counter5+"/"+counterTotal);
	}
	
	public SignIN getClientFacebook() {
		return clientFacebook;
	}
	
}
