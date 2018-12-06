package MainWork;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;

/**
 * Classe que representa a funcionalidade Email, onde se acede fazendo a autenticação, onde se pode consultar e enviar emails
 * e ainda onde podemos fazer a pesquisa de um email através de uma palavra pretendida.
 * 
 * @author Brogueira
 *
 */

public class Email implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String host ="smtp-mail.outlook.com" ;

	private Properties propsReader;
	private Properties propsSender;
	private Store store;
	private String mail;
	private String pass;

	private DefaultListModel<Mensagem> modelEmail;
	private Message messages[];

	/**
	 * Função que faz a autenticação do utilizador e que permite receber assim receber emails
	 * 
	 * @param mail- email do utilizador
	 * @param pass- password do utilizador
	 * 
	 * @author Brogueira
	 */

	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMail() {
		return mail;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPass() {
		return pass;
	}
	public void autenticacao(){
		iniSessaoReader(mail, this.pass);
		iniSessaoSender();
	}

	public void iniSessaoReader(String mail, String pass) {
		propsReader = System.getProperties();
		propsReader.setProperty("mail.store.protocol", "imaps");

		try {
			Session session = Session.getDefaultInstance(propsReader, null);
			store = session.getStore("imaps");
			store.connect(host, mail, pass);

			modelEmail = new DefaultListModel<Mensagem>();
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_ONLY);
			messages = inbox.getMessages();
			modelEmail();
		} catch (Exception e) {
			System.out.println("Erro no Inicio de sessão do EMail");
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


	/**
	 * Função que que representa a Timeline do email
	 * 
	 * @param t - Lista que representa a interface gráfica onde vão aparecer os emails
	 */

	public void caixaChegada(DefaultListModel<Mensagem> t) {
		for(int i = 0; i<modelEmail.size();i++) {
			t.addElement(modelEmail.getElementAt(i));
		}
	}

	public void modelEmail() {
		modelEmail.clear();
		try {
			for(Message message : messages) { 

				String conteudo = "";

				if(message.getContent() instanceof String) {
					conteudo = (String) message.getContent();
				}else {
					Multipart multipart = (Multipart) message.getContent();

					for (int x = 0; x < multipart.getCount(); x++) {
						BodyPart bodyPart = multipart.getBodyPart(x);

						String disposition = bodyPart.getDisposition();

						if (disposition != null && (disposition.equals(BodyPart.ATTACHMENT))) {
							System.out.println("Email tem anexos : ");

							DataHandler handler = bodyPart.getDataHandler();
							System.out.println("Nome do ficheiro : " + handler.getName());
						} else {
							conteudo = bodyPart.getContent().toString();
						}
					}
				}

				Mensagem m = new Mensagem("M", message.getSubject(), conteudo, message.getReceivedDate());
				modelEmail.addElement(m);

			}
		} catch (Exception e) {
			System.out.println("Erro Email");
		}
	}

	public DefaultListModel<Mensagem> getModelEmail() {
		return modelEmail;
	}

	public void setModelEmail(DefaultListModel<Mensagem> modelEmail) {
		this.modelEmail = modelEmail;
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
		for(int i = 0; i<modelEmail.size();i++) {
			if(modelEmail.get(i).toString().contains(p)) {
				t.addElement(modelEmail.get(i));
			}
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
		}catch (Exception e) {
			System.out.println("Erro no envio de email");
		}
	}

}

