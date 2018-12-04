package MainWork;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

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
	private DefaultListModel<Mensagem> temp = new DefaultListModel<Mensagem>();
	private DefaultListModel<Mensagem> modelFace;
	private DefaultListModel<Mensagem> modelTwitter;
	private DefaultListModel<Mensagem> modelMail;
	

	public InterfacePeriododaInformacao(BomDiaAcademia bda, DefaultListModel<Mensagem> model) {
		
		this.bda=bda;
		this.model = model;
		temp = new DefaultListModel<Mensagem>();
		modelFace = bda.getFacebook().getModelFace();
		modelTwitter = bda.getTwitter().getModelTwitter();
		modelMail = bda.getMail().getModelEmail();
		
		frame = new JFrame("INSERIR NÚMERO DE DIAS A VISUALIZAR ");
		addFrameContent();
		frame.pack();

		MostrarTimeLineemDias();
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

	
	public void  MostrarTimeLineemDias() {
		executar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				model.clear();
				temp.clear();
				float dias = Integer.parseInt(t.getText());

				for(int i = 0; i<modelFace.size();i++) {
					float diferenca = (System.currentTimeMillis() - modelFace.get(i).getData().getTime());
					if(diferenca < dias*dayInMilis) {
						temp.addElement(modelFace.get(i));
					}
				}
				
				for(int i = 0; i<modelTwitter.size();i++) {
					float diferenca = (System.currentTimeMillis() - modelTwitter.get(i).getData().getTime());
					if(diferenca < dias*dayInMilis) {
						temp.addElement(modelTwitter.get(i));
					}
				}
				
				for(int i = 0; i<modelMail.size();i++) {
					float diferenca = (System.currentTimeMillis() - modelMail.get(i).getData().getTime());
					if(diferenca < dias*dayInMilis) {
						temp.addElement(modelMail.get(i));
					}
				}
				
				ArrayList<Mensagem> m = new ArrayList<>();
				for(int i = 0; i<temp.size(); i++) {
					m.add(temp.get(i));
				}

				Collections.sort(m, new Comparador());
				model.clear();

				for(int i = 0; i<m.size(); i++) {
					model.addElement((Mensagem) m.get(i));
				}
				
				
			}
		});	

	}


}
