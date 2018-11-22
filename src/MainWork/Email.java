package MainWork;

import java.util.Date;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class Email {

	private static final int dayInMilis = 86400000;
	private final String host ="smtp-mail.outlook.com" ;

	private Properties propsReader;
	private Properties propsSender;
	private Store store;

	private String mail;
	private String pass;


	public Email() {
		mail = JOptionPane.showInputDialog("mail");
		pass = JOptionPane.showInputDialog("pass");

		iniSessaoReader(mail, pass);
		iniSessaoSender();
	}

	public void iniSessaoReader(String mail, String pass) {
		propsReader = System.getProperties();
		propsReader.setProperty("mail.store.protocol", "imaps");

		try {
			Session session = Session.getDefaultInstance(propsReader, null);
			store = session.getStore("imaps");
			store.connect(host, mail, pass);
		} catch (Exception e) {
			System.out.println("Erro 1");
		}
	}
	
	public void iniSessaoSender() {

		propsSender = System.getProperties();
		propsSender.put("mail.smtp.starttls.enable", "true");
		propsSender.put("mail.smtp.host", host);
		propsSender.put("mail.smtp.port", "587");
		propsSender.put("mail.smtp.auth", "true");
		propsSender.put("mail.smtp.starttls.required", "true");
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
	
	public void sendMail(String to, String messageText, String subject) {
		try {
			Session mailSession = Session.getDefaultInstance(propsSender, null);
			mailSession.setDebug(false);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(mail));
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject); msg.setSentDate(new Date());
			msg.setText(messageText);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, mail, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message send successfully");
		}catch (Exception e) {
			System.out.println("Erro de envio");
		}
	}

}

