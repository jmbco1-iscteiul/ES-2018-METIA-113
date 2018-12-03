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
 * 
 * @author Brogueira
 *
 */
public class Remove implements Serializable{
	
	/**
	 * 
	 */
	private boolean t;
	private boolean b;
	private static final long serialVersionUID = 1L;

	public Remove (Document doc, String apagar,Frame frame,String password)  throws Exception {
		System.out.println("############## Remover docs do XML  ################");
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
				System.out.println(nodes.item(i).getTextContent()+"OI");
				if(apagar.equals(ei.getAttribute("User"))) {
					t=true;
				}
					if(password.equals(ei.getAttribute("Password"))) {
					b=true;
					doc.getDocumentElement().removeChild(nodes.item(i));
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
