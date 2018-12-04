package MainWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;

public class Guarda {

	private BomDiaAcademia bda;

	private DefaultListModel<Mensagem> twitter;
	private DefaultListModel<Mensagem> face;
	private DefaultListModel<Mensagem> email;

	public Guarda(BomDiaAcademia bda){
		this.bda = bda;
	}

	public void guardar() {
		try {
			File f = new File("./Historico/" + bda.getUserName());
			f.mkdirs();

			FileOutputStream saveTwitter = new FileOutputStream("./Historico/" + bda.getUserName() + "/Twitter.txt");
			ObjectOutputStream out1 = new ObjectOutputStream(saveTwitter);
			out1.writeObject(bda.getTwitter().getModelTwitter());
			out1.close();
			System.out.println("Twitter Guardado");

			FileOutputStream saveFace = new FileOutputStream("./Historico/" + bda.getUserName() + "/Face.txt");
			ObjectOutputStream out2 = new ObjectOutputStream(saveFace);
			out2.writeObject(bda.getFacebook().getModelFace());
			out2.close();
			System.out.println("Face Guardado");

			FileOutputStream saveEmail = new FileOutputStream("./Historico/" + bda.getUserName() + "/Email.txt");
			ObjectOutputStream out3 = new ObjectOutputStream(saveEmail);
			out3.writeObject(bda.getMail().getModelEmail());
			out3.close();
			System.out.println("Email Guardado");



			carregar();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void carregar(){
		try {
			FileInputStream readfile1 = new FileInputStream("./Historico/" + bda.getUserName() + "/Twitter.txt");
			ObjectInputStream in1 = new ObjectInputStream(readfile1);
			twitter = (DefaultListModel<Mensagem>) in1.readObject();
			in1.close();
			System.out.println("Twitter Carregado");

			FileInputStream readfile2 = new FileInputStream("./Historico/" + bda.getUserName() + "/Face.txt");
			ObjectInputStream in2 = new ObjectInputStream(readfile2);
			face = (DefaultListModel<Mensagem>) in2.readObject();
			in2.close();
			System.out.println("Face Carregado");


			FileInputStream readfile3 = new FileInputStream("./Historico/" + bda.getUserName() + "/Email.txt");
			ObjectInputStream in3 = new ObjectInputStream(readfile3);
			email = (DefaultListModel<Mensagem>) in3.readObject();
			in3.close();
			System.out.println("Email Carregado");

			System.out.println("-------Twitter-----");

			for(int i = 0; i<twitter.size(); i++) {
				System.out.println(twitter.getElementAt(i));
			}
			System.out.println("-------Face-----");

			for(int i = 0; i<face.size(); i++) {
				System.out.println(face.getElementAt(i));
			}
			System.out.println("-------Email-----");

			for(int i = 0; i<email.size(); i++) {
				System.out.println(email.getElementAt(i));
			}

		} catch (Exception e){
			e.printStackTrace();

		}
	}

}
