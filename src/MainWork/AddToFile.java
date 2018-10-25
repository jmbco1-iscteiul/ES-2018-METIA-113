package MainWork;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AddToFile {

	public AddToFile(Document doc, SignIN client) {

		// Adding new element Service with attributes to the XML document (root node)
		System.out.println("\n----- Adding new element <Service> with attributes to the XML document -----");

		Element newElement1 = doc.createElement("Service");
		newElement1.setAttribute("Token", client.getToken());
		newElement1.setAttribute("Account", client.getMail());
		newElement1.setAttribute("Password", client.getPass());

		// Adding new element OtherNewTag to the XML document (root node)
		System.out.println("----- Adding new element <OtherNewTag> to the XML document -----");

		Element newElement2 = doc.createElement("OtherNewTag");
		newElement2.setTextContent("More new data"); 

		// Add new nodes to XML document (root element)
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());         
		Node n = doc.getDocumentElement();
		n.appendChild(newElement1);
		n.appendChild(newElement2);         
		
		
	}

}
