package MainWork;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ClientInfoStatus;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

import facebook.*;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 * Classe do ficheiro XML onde se acede ao ficheiro, se faz a leitura deste e se guarda o que se pretende nele também.
 * @author Brogueira
 *
 */
public class XmlProject {


	public XmlProject() {
		try {	
			File inputFile = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();  

			//Leitura
			Leitura l = new Leitura(doc);

			String mail = "mai";
			
		//Remove XML
		//Remove r = new Remove(doc, "mail");
			
			//Edit XML
			//Edit edit = new Edit(doc, mail, client);
			
			
			// Save XML document
			Save s = new Save(doc);

		} catch (Exception e) { e.printStackTrace(); }
	}
}