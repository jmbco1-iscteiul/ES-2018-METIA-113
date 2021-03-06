package MainWork;

import java.awt.Frame;
import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Classe que tem como função remover dados do ficheiro XML
 * @author Brogueira
 */

public class Remove implements Serializable{

	private boolean t;
	private boolean b;
	private static final long serialVersionUID = 1L;


	public Remove (Document doc, String apagar,Frame frame,String password,SignIN in)  throws Exception {
		t=false;
		b=false;
		doc.getDocumentElement();
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile("/XML/Service/@*");

		NodeList nodes = doc.getDocumentElement().getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {

			if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				NamedNodeMap atr = nodes.item(i).getAttributes();
				Node nodeatr = nodes.item(i);
				Element ei= (Element) nodeatr;
				System.out.println(ei.getAttribute("User"));

				if(apagar.equals(ei.getAttribute("User"))) {
					t=true;
				}
				if(password.equals(ei.getAttribute("Password"))) {
					b=true;	
				}
				if(b && t) {
					doc.getDocumentElement().removeChild(nodes.item(i));
					in.setTokenface(ei.getAttribute("TokenFacebook"));
					in.setTokentwitter1(ei.getAttribute("TokenTwitter1"));
					in.setTokentwitter2(ei.getAttribute("TokenTwitter2"));
					in.setTokentwitter3(ei.getAttribute("TokenTwitter3"));
					in.setTokentwitter4(ei.getAttribute("TokenTwitter4"));
					in.setEmail(ei.getAttribute("ContadeEmail"));
					in.setPass(ei.getAttribute("PassdeEmail"));
				}
			}
		}
		if(!t) {
			JOptionPane.showMessageDialog(frame, "AVISO: Este UserName não existe!");
		}
		if(!b) {
			JOptionPane.showMessageDialog(frame, "AVISO: Palavra-Passe mal introduzida!");
		}
	}

	public boolean isB() {
		return b;
	}

	public boolean isT() {
		return t;
	}
}
