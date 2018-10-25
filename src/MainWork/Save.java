package MainWork;

import java.io.FileOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * 
 * Classe que trata de guardar todos os atributos no ficheiro XML
 * 
 * @author Brogueira
 *
 */

public class Save {
	public Save(Document doc) throws Exception {
		System.out.println("\nSave XML document.");
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);

	}
}
