package MainWork;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.swing.DefaultListModel;

import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Classe que impleta a funcionalidade Twitter onde se pode aceder a este através da autenticção,  
 * consultar tweets e fazer pesquisas destes mesmos através de uma String pretendida.
 * 
 * @author Brogueira
 *
 */

public final class TwitterAccess  {

	Twitter twitter = TwitterFactory.getSingleton();
	List<Status> timelineStatuses = new ArrayList<Status>();


/**
 * Função que faz a autenticação no Twitter com os tokens respetivos
 * 
 * @author Brogueira
 */
	public void autenticacao () {	
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey("omTUULTL1Pd2i4XfVORW2Smzf")
			.setOAuthConsumerSecret("RatuUpSGLl0LLoajnBw3IojT6fF9vDbC7yJ19FpCav89g65Acj")
			.setOAuthAccessToken("727114274489913345-4ax0nVCGOl5qUa2dL4StFQzyxUd06sE")
			.setOAuthAccessTokenSecret("BoRBgd7Pn9eaPDdfHx5AFBpbsY9Q8apNuLxtqXhwRYzzW");
			TwitterFactory tf = new TwitterFactory(cb.build());
			twitter = tf.getInstance();
			timelineStatuses = twitter.getHomeTimeline();
		}catch (Exception e) { 
			System.out.println(e.getMessage()); 
		}
	}
	
	/**
	 * Função que permite obter a timeline do Twitter do utilizador
	 * 
	 * @param t- Lista da interface gráfica onde aperecem todos os tweets
	 * 
	 * @author Brogueira
	 */

	public void getTimeline(DefaultListModel<Mensagem> t){
		autenticacao();
		try{
//			t.addElement("|||||||||||||||||||||||| VER TIMELINE ||||||||||||||||||||||||");
			int counter=0;
			int counterTotal = 0;
			for (Status status : timelineStatuses) {
				if (status.getUser().getName() != null) {
//					t.addElement(status.getId() + "    " + status.getCreatedAt() + " - " + "@" + status.getUser().getName() + ":" + status.getText());
					Mensagem m = new Mensagem("T", status.getText(), status.getUser().getName(), status.getCreatedAt());
					t.addElement(m);
//					t.addElement("____________________________________________________________");
					counter++;
				}
				counterTotal++;
			}


//			t.addElement("-------------\nNº of Results: " + counter+"/"+counterTotal);
		} catch (Exception e) { 
			System.out.println("erro");
		}
//			t.addElement(e.getMessage() + " - deu erro"); }
	}

	/**
	 * Função que permite que sejam publicados novos tweets
	 * 
	 * @param estado- Conteúdo do novo tweet
	 * 
	 * @author Brogueira
	 */
	
	public void updateStatus(String estado) {
		Status status = null;
		try {
			status = twitter.updateStatus(estado);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}

	/**
	 * Função que permite pesquisar tweets através de uma String específica
	 * 
	 * @param palavra- palavra a pesquisas tweets
	 * @param t- Lista da interface gráfica onde aperecem todos os tweets
	 *
	 *@author Brogueira
	 */
	
	public void searchTweet(String palavra,DefaultListModel<Mensagem> t) {
		int counter=0;
		int counterTotal=0;
		for(Status status : timelineStatuses) {
			if(status.getText().contains(palavra)) {
//				t.addElement("@" + status.getUser().getScreenName() + ":" + status.getText());
				Mensagem m = new Mensagem("T", status.getText(), status.getUser().getScreenName(), status.getCreatedAt());
				t.addElement(m);
				counter++;
			}
			counterTotal++;
		}
//		t.addElement("-------------\nNº of Results: " + counter+"/"+counterTotal);
	}
	
}
