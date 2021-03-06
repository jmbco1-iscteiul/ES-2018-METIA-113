package facebook;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JTextArea;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.GraphResponse;
import com.restfb.types.Post;
import com.restfb.types.User;

import MainWork.Interfacegrafica;
import MainWork.Mensagem;
import MainWork.SignIN;

/**
 * Classe que represa a funcionalidade Facebook, onde se acede ao facebook através da autenticção e onde se pode 
 * consultar posts e fazer pesquisas destes mesmos através de uma String pretendida.
 *  
 * @author Brogueira
 *
 */

public class Facebook {

	public SignIN clientFacebook;
	public FacebookClient fbClient;
	private final String groupID = "2168682303197759";
	private String token;

	private Connection<Post> result;
	private DefaultListModel<Mensagem> modelFace;

	/**
	 * Função para autenticação no facebook, com o token respetivo.
	 * @author Brogueira
	 */
	public void autenticacao() {
		fbClient = new DefaultFacebookClient(token);
		User me = fbClient.fetchObject("me", User.class);

		System.out.println("Facebook:");
		System.out.println("Id: " + me.getId());
		System.out.println("Name: " + me.getName());
		System.out.println(me.getName());

		modelFace = new DefaultListModel<Mensagem>();
		result = fbClient.fetchConnection("me/feed",Post.class);
		modelFace();
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Função que tem como objetivo pesquisar todos os posts com uma String pretentida.
	 * @param p - String a pesquisar
	 * @param t - lista de resultados
	 * @author Brogueira
	 */
	
	public void search(String p, DefaultListModel<Mensagem> t) {

		for(int i = 0; i<modelFace.size();i++) {
			if(modelFace.get(i).toString().contains(p)) {
				t.addElement(modelFace.get(i));
			}
		}
	}

	/**
	 * Função que permite obter a timeline do Facebook do utilizador
	 * @param t- Lista da interface gráfica onde aperecem todos os posts~
	 * @author Brogueira
	 */

	public void timeline(DefaultListModel<Mensagem> t) {
		t = this.modelFace;
	}

	/**
	 * Função que carrega os posts do facebook na lista de posts em formato Mensagem
	 * @author Brogueira
	 */

	public void modelFace() {
		modelFace.clear();
		for (List<Post> page : result) {
			for (Post aPost : page) {
				Mensagem m = new Mensagem("F", aPost.getMessage(), aPost.getCreatedTime());
				modelFace.addElement(m);
			}
		}
	}

	public DefaultListModel<Mensagem> getModelFace() {
		return modelFace;
	}

	public void setModelFace(DefaultListModel<Mensagem> modelFace) {
		this.modelFace = modelFace;
	}

	public SignIN getClientFacebook() {
		return clientFacebook;
	}

	/**
	 * Função que permite fazer posts no facebook
	 * @param post- conteúdo do post
	 * @author Brogueira
	 */

	public void makePost(String post) {
		fbClient.publish(groupID + "/feed", GraphResponse.class, Parameter.with("message", post));
		System.out.println(post);
	}

}
