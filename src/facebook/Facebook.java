package facebook;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JTextArea;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;
import com.restfb.types.User;

import MainWork.Interfacegrafica;
import MainWork.SignIN;

public class Facebook {
	Interfacegrafica i;
	private final static String accessToken="EAAD45TT4030BAMppoeRyc1RtdOfUzobKEP18LZCzAmZB9vzxZA3WafngiZBvZCE00TJm6cFyUwEKcOx4hdKJYuJQkDX5DPk5kdjo8321wWGRl6ZCYmkiXVMdAmxkuW205CGKpBDB4Ek9w71RJiXGtIX29iYPVZCQ8MZD";//preencher pelo utilizador
	private final static String ID="273663319921533";
	private final static String pass="dcc1e2de5a8a44804e89913f31dcd496";
	public SignIN clientFacebook;
	public DefaultListModel<String> t;
	public FacebookClient fbClient;
	
	public Facebook( DefaultListModel<String> model) {
		this.t=model;
		autenticacao();
	}

	
	public void autenticacao() {
		fbClient = new DefaultFacebookClient(accessToken);
		User me = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me.getId());
		System.out.println("Name: " + me.getName());
		System.out.println(me.getName());
		//AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken(clientFacebook.getMail(),clientFacebook.getPass());
		//System.out.println("Expires: " + extendedAccessToken.getExpires());
	}
	
	public void search(String p) {
	
		Connection<Post> result = fbClient.fetchConnection("me/feed",Post.class);
		System.out.println("\nPosts:");
		int counter5 = 0;
		int counterTotal = 0;

		for (List<Post> page : result) {
			for (Post aPost : page) {
				if (aPost.getMessage() != null && aPost.getMessage().contains(p)) {
					t.addElement("---- Post "+ counter5 + " ----");
					t.addElement("Id: "+"fb.com/"+aPost.getId());
					t.addElement("Message: "+aPost.getMessage());
					t.addElement("---- Post "+ counter5 + " ----");
					t.addElement("Created: "+aPost.getCreatedTime());
					System.out.println("---- Post "+ counter5 + " ----");
					System.out.println("Id: "+"fb.com/"+aPost.getId());
					System.out.println("Message: "+aPost.getMessage());
					System.out.println("Created: "+aPost.getCreatedTime());
					counter5++;
				}
				counterTotal++;
			}
		}
		t.addElement("-------------\nNo of Results: " + counter5+"/"+counterTotal);
		System.out.println("-------------\nNo of Results: " + counter5+"/"+counterTotal);
		
	
	}
	
	public SignIN getClientFacebook() {
		return clientFacebook;
	}
	
	
	
	
}
