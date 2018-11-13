package MainWork;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterAccess  {

	Twitter twitter = TwitterFactory.getSingleton();
	List<Status> timelineStatuses = new ArrayList<Status>();

	public static void main(String[] args) {
		TwitterAccess t = new TwitterAccess();
		t.autenticacao();
		t.getTimeline();
	}


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


	public void getTimeline(){

		try{
			System.out.println("|||||||||||||||||||||||| VER TIMELINE ||||||||||||||||||||||||");
			int counter=0;
			int counterTotal = 0;
			for (Status status : timelineStatuses) {
				// Filters only tweets from user "catarina"
				if (status.getUser().getName() != null) {
					System.out.println(status.getId() + "    " + status.getCreatedAt() + " - " + "@" + status.getUser().getName() + ":" + status.getText());
					System.out.println("____________________________________________________________");
					counter++;
				}
				counterTotal++;
			}


			System.out.println("-------------\nNº of Results: " + counter+"/"+counterTotal);
		} catch (Exception e) { 
			System.out.println(e.getMessage() + " - deu erro"); }
	}

}
