package MainWork;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class InterfacePeriododaInformacao {
	private static final int dayInMilis = 86400000;

	private JFrame frame;
	private JButton executar= new JButton("Mostrar Timeline");
	private BomDiaAcademia bda;
	private JTextField t= new JTextField();
	private DefaultListModel<Mensagem> model;

	public InterfacePeriododaInformacao(BomDiaAcademia bda, DefaultListModel<Mensagem> model) {
		this.bda=bda;
		this.model = model;

		frame = new JFrame("INSERIR NÚMERO DE DIAS A VISUALIZAR ");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();

		MostrarTimeLine();
	}

	public void open() {

		frame.setSize(500, 100);
		frame.setVisible(true);

	}

	private void addFrameContent() {

		JPanel panel = new JPanel();
		Dimension d7= new Dimension(300,30);
		t.setPreferredSize(d7);

		panel.add(t,BorderLayout.CENTER);
		panel.add(executar,BorderLayout.EAST);
		frame.add(panel);

	}

	public void  MostrarTimeLine() {
		executar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				model.clear();
				DefaultListModel<Mensagem> temp = new DefaultListModel<Mensagem>();
				DefaultListModel<Mensagem> modelFace = bda.getFacebook().getModelFace();
				DefaultListModel<Mensagem> modelTwitter = bda.getTwitter().getModelTwitter();
				DefaultListModel<Mensagem> modelMail = bda.getMail().getModelEmail();

				int dias = Integer.parseInt(t.getText());

				for(int i = 0; i<modelFace.size();i++) {
					float diferenca = (System.currentTimeMillis() - modelFace.get(i).getData().getTime());
					System.out.println("Diferenca: " + diferenca);
					if(diferenca < dias*dayInMilis) {
						System.out.println("cona");
						temp.addElement(modelFace.get(i));
					}
				}
				
				for(int i = 0; i<modelTwitter.size();i++) {
					float diferenca = (System.currentTimeMillis() - modelTwitter.get(i).getData().getTime());
					System.out.println("Diferenca: " + diferenca);
					if(diferenca < dias*dayInMilis) {
						System.out.println("cona");
						temp.addElement(modelTwitter.get(i));
					}
				}
				
				for(int i = 0; i<modelMail.size();i++) {
					float diferenca = (System.currentTimeMillis() - modelMail.get(i).getData().getTime());
					System.out.println("Diferenca: " + diferenca);
					if(diferenca < dias*dayInMilis) {
						System.out.println("cona");
						temp.addElement(modelMail.get(i));
					}
				}
				model.clear();
				for(int j = 0; j<temp.size(); j++) {
					model.addElement(temp.get(j));

				}

			}
		});	

	}


}
