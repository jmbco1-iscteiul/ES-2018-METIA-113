package MainWork;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class Remove {
	
	public Remove (Document doc, String apagar) throws Exception{
		
		System.out.println("############## Remover docs do XML  ################");
		
		doc.getDocumentElement();
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile("/XML/Service/@*");

		Node node = doc.getDocumentElement().getFirstChild(); 

		while (node != null) {
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				NamedNodeMap atr = node.getAttributes();
				Node nodeatr = atr.getNamedItem("Account");
				if (apagar.equals(nodeatr.getTextContent())) {
					System.out.println("Apaguei");
					doc.getDocumentElement().removeChild(node);
				}
			}
			node = node.getNextSibling();
		} 
	}
}
