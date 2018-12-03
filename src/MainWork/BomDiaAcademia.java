package MainWork;

import facebook.Facebook;
import org.w3c.dom.Document;
/**
 * Motor principal da aplicação onde se encontram todos os métodos principais.
 * 
 * @author Brogueira
 *
 */
public class BomDiaAcademia {
//	private static String token = "EAAD45TT4030BAMppoeRyc1RtdOfUzobKEP18LZCzAmZB9vzxZA3WafngiZBvZCE00TJm6cFyUwEKcOx4hdKJYuJQkDX5DPk5kdjo8321wWGRl6ZCYmkiXVMdAmxkuW205CGKpBDB4Ek9w71RJiXGtIX29iYPVZCQ8MZD";//preencher pelo utilizador
	private Facebook facebook;
	private InterfaceInicio i;
	private XmlProject xml;
	private TwitterAccess twitter;
	private Email mail;
	
	public BomDiaAcademia() {
		facebook = new Facebook();
		twitter = new TwitterAccess ();
		mail = new Email();
		i = new InterfaceInicio(this);
		i.open();
		xml = new XmlProject();
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



	public static void main(String[] args) {
		new BomDiaAcademia();
	}

}
