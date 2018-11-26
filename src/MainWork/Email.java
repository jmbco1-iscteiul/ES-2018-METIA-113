package MainWork;

import java.util.Date;
import java.util.Hashtable;
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

/**
 * Classe que representa a funcionalidade Email, onde se acede fazendo a autenticação, onde se pode consultar e enviar emails
 * e ainda onde podemos fazer a pesquisa de um email através de uma palavra pretendida.
 * 
 * @author Brogueira
 *
 */

public class Email {

	private static final int dayInMilis = 86400000;
	private final String host ="smtp-mail.outlook.com" ;

	private Properties propsReader;
	private Properties propsSender;
	private Store store;

	private String mail="es.pos.amigos@hotmail.com";
	private String pass="afogaoganso69";


	public Email() {

		iniSessaoReader(mail, pass);
		iniSessaoSender();
	}
	/**
	 * Função que faz a autenticação do utilizador e que permite receber assim receber emails
	 * 
	 * @param mail- email do utilizador
	 * @param pass- password do utilizador
	 * 
	 * @author Brogueira
	 */

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

	/**
	 * Função que cria as condições para depois se enviar emails
	 * 
	 * @author Brogueira
	 */
	public void iniSessaoSender() {

		propsSender = System.getProperties();
		propsSender.put("mail.smtp.starttls.enable", "true");
		propsSender.put("mail.smtp.host", host);
		propsSender.put("mail.smtp.port", "587");
		propsSender.put("mail.smtp.auth", "true");
		propsSender.put("mail.smtp.starttls.required", "true");
	}
	

//	public void caixaTemp(int dias) {
//		try {
//			Folder inbox = store.getFolder("Inbox");
//			inbox.open(Folder.READ_ONLY);
//			Message messages[] = inbox.getMessages();
//			System.out.println(messages.length);
//			for(Message message : messages) { 
//				if(message.getReceivedDate().getTime() > System.currentTimeMillis()-(dias*dayInMilis)) {
//					System.out.println(message.getSubject());
//					System.out.println(message.getReceivedDate());
//				}
//			}	
//
//		} catch (Exception e) {
//			System.out.println("Erro");
//		}
//	}

	/**
	 * Função que que representa a Timeline do email
	 * 
	 * @param t - Lista que representa a interface gráfica onde vão aparecer os emails
	 */

	public void caixaChegada(DefaultListModel<Mensagem> t) {
		try {
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_ONLY);
			Message messages[] = inbox.getMessages();
			System.out.println("o tamanho é: " + messages.length);
			for(Message message : messages) { 
				Mensagem m = new Mensagem("M", message.getSubject(), message.getReceivedDate());
				t.addElement(m);
				//				long date = message.getReceivedDate().getTime();
				//				java.util.Date dateTime=new java.util.Date((long)date*1000);
				//				String datum = String.valueOf(dateTime);
				//				t.addElement(datum);
				//				t.addElement("-------------------------------------");
			}
			System.out.println(messages.length);
		} catch (Exception e) {
			System.out.println("Erro 2");
		}
	}

	/**
	 * Função que permite fazer a pesquisa de um email através de uma palavra, onde são apresentados todos os emails que 
	 * contenham essa palavra
	 * 
	 * @param t - lista de emails onde se procura a procura
	 * @param p - palavra a pesquisar
	 * 
	 * @author Brogueira
	 */

	public void procurarpalavra(DefaultListModel<Mensagem> t,String p) {
		try {
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_ONLY);
			Message messages[] = inbox.getMessages();
			System.out.println("o tamanho é: " + messages.length);
			for(Message message : messages) { 
				System.out.println(message.getSubject());
				if (message.getSubject().contains(p)) {
					t.addElement(new Mensagem("M", message.getSubject(), message.getReceivedDate()));
//					long date = message.getReceivedDate().getTime();
//					java.util.Date dateTime=new java.util.Date((long)date*1000);
//					String datum = String.valueOf(dateTime);
					//				t.addElement(datum);
					//				t.addElement("-------------------------------------");
				}
			}
			System.out.println(messages.length);
		} catch (Exception e) {
			System.out.println("Erro 2");
		}
	}


	/**
	 * Função que permita enviar um email.
	 * 
	 * @param to - onde se indica quem é o destinatário do email
	 * @param messageText - onde se introduz o conteúdo do email 
	 * @param subject - onde se indica o assunto do email
	 * 
	 * @author Brogueira
	 */

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

