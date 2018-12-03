package MainWork;


import java.awt.Frame;

import javax.swing.JOptionPane;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * Classe que tem como objetivo adicionar todos os atributos pretendidos(Token, Account e Password) ao ficheiro XML 
 * tendo em atenção que o mesmo utilizador não se regista duas vezes
 * 
 * @author Brogueira
 *
 */
public class AddToFile {
	
	private Element newElement1;
	private Document doc;
	private SignIN client;

	private boolean t=false;
	private boolean b=false;
	
	
	public AddToFile(Document doc, SignIN client) {
		this.doc=doc;
		this.client=client;
		// Adding new element Service with attributes to the XML document (root node)
		System.out.println("\n----- Adding new element <Service> with attributes to the XML document -----");
		
		newElement1 = doc.createElement("Service");
		newElement1.setAttribute("User", client.getUsername());
		newElement1.setAttribute("Password", client.getPassword());
		newElement1.setAttribute("TokenFacebook", client.getTokenface());
		newElement1.setAttribute("TokenTwitter1", client.getTokentwitter1());
		newElement1.setAttribute("TokenTwitter2", client.getTokentwitter2());
		newElement1.setAttribute("TokenTwitter3", client.getTokentwitter3());
		newElement1.setAttribute("TokenTwitter4", client.getTokentwitter4());
		newElement1.setAttribute("ContadeEmail", client.getEmail());
		newElement1.setAttribute("PassdeEmail", client.getPass());
		

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName()); 
			
		NodeList nodes = doc.getDocumentElement().getChildNodes();
		Node n = doc.getDocumentElement();
		
		System.out.println(nodes.getLength());
		for (int i = 0; i < nodes.getLength(); i++) {
			if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				NamedNodeMap atr = nodes.item(i).getAttributes();
				Node nodeatr = nodes.item(i);
				Element ei= (Element) nodeatr;
				System.out.println(ei.getAttribute("User"));
				System.out.println(nodes.item(i).getTextContent()+"OI");
					if(client.getUsername().equals(ei.getAttribute("User"))) {
					t=true;
					}
						if(client.getPassword().equals(ei.getAttribute("Password"))) {
						b=true;
					}
					if(client.getUsername().equals(ei.getAttribute("User")) && client.getPassword().equals(ei.getAttribute("Password"))) {
						t=true;
						b=true;
					}
			}
			}
		if(!b && !t) {
			
			n.appendChild(newElement1);
			}
		
	}	
		
	public boolean isT() {
		return t;
	}
	
	public boolean isB() {
		return b;
	}
	

	public Element getNewElement() {
		return newElement1;
	}

}
