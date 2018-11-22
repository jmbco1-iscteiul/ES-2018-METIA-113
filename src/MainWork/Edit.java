package MainWork;

import org.w3c.dom.Document;

public class Edit {

	public Edit(Document doc, String mail, SignIN client) throws Exception {
		Remove r = new Remove (doc, mail);
		AddToFile add = new AddToFile(doc, client);
	}

	
}
