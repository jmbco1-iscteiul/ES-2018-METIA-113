package MainWork;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class EmailReader {

private static final int dayInMilis = 86400000;
	
	private Properties props;
	private Store store;

	private String mail;
	private String pass;


	public EmailReader() {
		mail = JOptionPane.showInputDialog("mail");
		pass = JOptionPane.showInputDialog("pass");
		props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		iniSessao(mail, pass);
	}

	public void iniSessao(String mail, String pass) {
		try {
			Session session = Session.getDefaultInstance(props, null);
			store = session.getStore("imaps");
			store.connect("smtp-mail.outlook.com", mail, pass);
		} catch (Exception e) {
			System.out.println("Erro 1");
		}
	}

	public void caixaTemp(int dias) {
		try {
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_ONLY);
			Message messages[] = inbox.getMessages();
			System.out.println(messages.length);
			for(Message message : messages) { 
				if(message.getReceivedDate().getTime() > System.currentTimeMillis()-(dias*dayInMilis)) {
					System.out.println(message.getSubject());
					System.out.println(message.getReceivedDate());
				}
			}	
			
		} catch (Exception e) {
			System.out.println("Erro");
		}
	}
	
	public void caixaChegada(DefaultListModel<String> t) {
		try {
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_ONLY);
			Message messages[] = inbox.getMessages();
			System.out.println("o tamanho Ã©: " + messages.length);
			for(Message message : messages) { 
					t.addElement(message.getSubject());
						long date = message.getReceivedDate().getTime();
							java.util.Date dateTime=new java.util.Date((long)date*1000);
								String datum = String.valueOf(dateTime);
									t.addElement(datum);
									t.addElement("-------------------------------------");
			}
			System.out.println(messages.length);
		} catch (Exception e) {
			System.out.println("Erro 2");
		}
	}

}

