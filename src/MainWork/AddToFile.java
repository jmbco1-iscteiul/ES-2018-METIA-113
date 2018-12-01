package MainWork;


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
	
	public AddToFile(Document doc, SignIN client) {
		this.doc=doc;
		this.client=client;
		// Adding new element Service with attributes to the XML document (root node)
		System.out.println("\n----- Adding new element <Service> with attributes to the XML document -----");
		
		newElement1 = doc.createElement("Service");
		newElement1.setAttribute("UserName", client.getUsername());
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
		
		for (int i = 0; i < nodes.getLength(); i++) {
			if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				NamedNodeMap atr = nodes.item(i).getAttributes();
				Node nodeatr = atr.getNamedItem("UserName");

					n.appendChild(newElement1);
				
			}
		}	
	}
	
	
	
	public Element getNewElement() {
		return newElement1;
	}

}
