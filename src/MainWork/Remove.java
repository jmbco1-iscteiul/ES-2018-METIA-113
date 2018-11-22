package MainWork;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Remove {
	
	public Remove (Document doc, String apagar) throws Exception{
		
		System.out.println("############## Remover docs do XML  ################");
		
		doc.getDocumentElement();
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile("/XML/Service/@*");

		NodeList nodes = doc.getDocumentElement().getChildNodes();
		
		for (int i = 0; i < nodes.getLength(); i++) {
			if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				NamedNodeMap atr = nodes.item(i).getAttributes();
				Node nodeatr = atr.getNamedItem("Account");
				if(apagar.equals(nodeatr.getTextContent())) {
					doc.getDocumentElement().removeChild(nodes.item(i));
				}
			}
		}
	}
}
