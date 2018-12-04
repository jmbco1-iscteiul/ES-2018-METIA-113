package MainWork;

import facebook.Facebook;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.w3c.dom.Document;
/**
 * Motor principal da aplicação onde se encontram todos os métodos principais.
 * 
 * @author Brogueira
 *
 */
public class BomDiaAcademia {
	private Facebook facebook;
	private InterfaceInicio i;
	private XmlProject xml;
	private TwitterAccess twitter;
	private Email mail;
	private Guarda guarda;
	
	private String userName;

	private boolean internetConnection;

	public BomDiaAcademia() {
		internetConnection = netIsAvailable();

		if(internetConnection) {
			facebook = new Facebook();
			twitter = new TwitterAccess ();
			mail = new Email();
			guarda = new Guarda(this);
			i = new InterfaceInicio(this);
			i.open();
			xml = new XmlProject();
		}
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
		System.out.println("-------------------USER NAME: " + userName);
	}
	
	public String getUserName() {
		return userName;
	}

	public XmlProject getXml() {
		return xml;
	}

	public Facebook getFacebook() {
		return facebook;
	}

	public TwitterAccess getTwitter() {
		return twitter;
	}

	public Email getMail() {
		return mail;
	}


	public InterfaceInicio getI() {
		return i;
	}

	public Guarda getGuarda() {
		return guarda;
	}	
	private static boolean netIsAvailable() {
		try {
			final URL url = new URL("http://www.google.com");
			final URLConnection conn = url.openConnection();
			conn.connect();
			conn.getInputStream().close();
			System.out.println("Ligado à Internet");
			return true;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			System.out.println("Sem Ligação");
			return false;
		}
	}


	public static void main(String[] args) {
		new BomDiaAcademia();
	}

}
