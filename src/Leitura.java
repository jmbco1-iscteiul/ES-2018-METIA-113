

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Leitura {
	
	public Leitura (Document doc) throws Exception {
		
        System.out.println("\n----- Search the XML document with xpath queries -----");  
        
        // Query 1 
        System.out.println("Query 1: ");
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        XPathExpression expr = xpath.compile("/XML/Service/@*");
        NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        
        for (int i = 0; i < nl.getLength(); i++) {
            System.out.print(nl.item(i).getNodeName()  + ": ");
            System.out.println(nl.item(i).getFirstChild().getNodeValue());
        }
        
        // Query 2
        
        System.out.println("\nQuery 2: ");         
        expr = xpath.compile("/XML/Paths/docPath");
        String str = (String) expr.evaluate(doc, XPathConstants.STRING);
        System.out.println("docPath: " + str);
		
	}
	
}
