package MainWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.mail.Message;
import javax.swing.DefaultListModel;

/**
 * Classe que guarda e carrega os emails
 * @author Brogueira
 *
 */
public class Guarda {

	private BomDiaAcademia bda;

	private DefaultListModel<Mensagem> twitter;
	private DefaultListModel<Mensagem> face;
	private DefaultListModel<Mensagem> email;

	public Guarda(BomDiaAcademia bda){
		this.bda = bda;
	}
/**
 * Função que guarda os conteúdos no ficheiro de texto
 * @author Brogueira
 */
	public void guardar() {
		try {
			File f = new File("./Historico/" + bda.getUserName());
			f.mkdirs();

			FileOutputStream saveTwitter = new FileOutputStream("./Historico/" + bda.getUserName() + "/Twitter.txt");
			ObjectOutputStream out1 = new ObjectOutputStream(saveTwitter);
			out1.writeObject(bda.getTwitter().getModelTwitter());
			out1.close();

			FileOutputStream saveFace = new FileOutputStream("./Historico/" + bda.getUserName() + "/Face.txt");
			ObjectOutputStream out2 = new ObjectOutputStream(saveFace);
			out2.writeObject(bda.getFacebook().getModelFace());
			out2.close();

			FileOutputStream saveEmail = new FileOutputStream("./Historico/" + bda.getUserName() + "/Email.txt");
			ObjectOutputStream out3 = new ObjectOutputStream(saveEmail);
			out3.writeObject(bda.getMail().getModelEmail());
			out3.close();


		} catch (IOException e){
			System.out.println("Erro ao guardar");
		}
	}

	/**
	 * Função que lê o que está guardado nos ficheiros de texto
	 * @param user- utilizador
	 * @return arraylist com as listas carregadas(email, twitter e facebook)
	 * @author Brogueira
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<DefaultListModel<Mensagem>> carregar(String user){
		ArrayList<DefaultListModel<Mensagem>> l = new ArrayList<>();


		try {
			FileInputStream readfile1 = new FileInputStream("./Historico/" + user + "/Twitter.txt");
			ObjectInputStream in1 = new ObjectInputStream(readfile1);
			twitter = (DefaultListModel<Mensagem>) in1.readObject();
			in1.close();
			l.add(twitter);

			FileInputStream readfile2 = new FileInputStream("./Historico/" + user + "/Face.txt");
			ObjectInputStream in2 = new ObjectInputStream(readfile2);
			face = (DefaultListModel<Mensagem>) in2.readObject();
			in2.close();
			l.add(face);


			FileInputStream readfile3 = new FileInputStream("./Historico/" + user + "/Email.txt");
			ObjectInputStream in3 = new ObjectInputStream(readfile3);
			email = (DefaultListModel<Mensagem>) in3.readObject();
			in3.close();
			l.add(email);

		} catch (Exception e){
			System.out.println("Erro ao carregar Emails");
		}
		return l;
	}

}
