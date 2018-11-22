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

	public AddToFile(Document doc, SignIN client) {

		// Adding new element Service with attributes to the XML document (root node)
		System.out.println("\n----- Adding new element <Service> with attributes to the XML document -----");

		Element newElement1 = doc.createElement("Service");
		newElement1.setAttribute("Token", client.getToken());
		newElement1.setAttribute("Account", client.getMail());
		newElement1.setAttribute("Password", client.getPass());
		

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName()); 
		
		NodeList nodes = doc.getDocumentElement().getChildNodes();
		Node n = doc.getDocumentElement();
		
		for (int i = 0; i < nodes.getLength(); i++) {
			if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				NamedNodeMap atr = nodes.item(i).getAttributes();
				Node nodeatr = atr.getNamedItem("Account");
				if(!client.getMail().equals(nodeatr.getTextContent())) {
					n.appendChild(newElement1);
				}
			}
		}		
	}

}
