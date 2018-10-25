package MainWork;

import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Main {
public static void main(String[] args) {
	
	 SwingUtilities.invokeLater(new Runnable () { 
         public void run() {
   
		Interfacegrafica i = new Interfacegrafica();
		i.open();
         
         }
         });
	
//		new XmlProject();

	}
}
