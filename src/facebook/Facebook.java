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

/**
 * Classe que represa a funcionalidade Facebook, onde se acede ao facebook através da autenticação e onde se pode 
 * consultar posts e fazer pesquisas destes mesmos através de uma String pretendida.
 *  
 * @author Brogueira
 *
 */
public class Facebook {
	private String token;
	public SignIN clientFacebook;
	public FacebookClient fbClient;
	
	public Facebook(String token) {
		this.token=token;
		autenticacao();
	}

/**
 * Função para autenticação no facebook, com o token respetivo.
 * 
 * @author Brogueira
 */
	public void autenticacao() {
		fbClient = new DefaultFacebookClient(token);
		User me = fbClient.fetchObject("me", User.class);
		System.out.println("Facebook:");
		System.out.println("Id: " + me.getId());
		System.out.println("Name: " + me.getName());
		System.out.println(me.getName());
	}
	
	
	/**
	 * Função que tem como objetivo pesquisar todos os post com uma String pretentida.
	 *
	 * @param p - String a pesquisar
	 * @param t - lista de resultados
	 * 
	 * @author Brogueira
	 */
	public void search(String p, DefaultListModel<String> t) {
	
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
