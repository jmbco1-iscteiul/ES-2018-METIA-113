package MainWork;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class InterfaceSignIn {

	
	private JFrame frame;
	private JButton submeter= new JButton("SUBMETER");
	private JButton sair= new JButton("Sair sem Guardar");
	private JTextField escreve1 = new JTextField();
	private JPasswordField escreve2 = new JPasswordField();
	private JPasswordField escreve3 = new JPasswordField();
	private JTextField escreve4 = new JTextField();
	private JTextField escreve5 = new JTextField();
	private JTextField escreve6 = new JTextField();
	private JPasswordField escreve7 = new JPasswordField();
	private JPasswordField escreve8 = new JPasswordField();
	private JTextField escreve9 = new JTextField();
	private JTextField escreve10 = new JTextField();
	private JTextField escreve11 = new JTextField();
	private BomDiaAcademia bda;
	private String s;
	private String s1;
	private String s2;
	private String s3;
	
	public InterfaceSignIn(BomDiaAcademia bda) {
		this.bda=bda;
		frame = new JFrame("REGISTO NA APLICAÇÃO");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
	}
	
	public void open() {
		
		frame.setSize(1000, 650);
		frame.setVisible(true);

	}
	
	private void addFrameContent() {

		JPanel search = new JPanel(new GridLayout(12, 2));
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JTextArea text1 = new JTextArea();
		JTextArea text2 = new JTextArea();
		JTextArea text3 = new JTextArea();
		JTextArea text4 = new JTextArea();
		JTextArea text5 = new JTextArea();
		JTextArea text6 = new JTextArea();
		JTextArea text7 = new JTextArea();
		JTextArea text8 = new JTextArea();
		JTextArea text9 = new JTextArea();
		JTextArea text10 = new JTextArea();
		JTextArea text11 = new JTextArea();
		JPanel panel1 = new JPanel(new GridLayout(2, 1));
		JPanel panel5 = new JPanel(new GridLayout(2, 1));
		JPanel panel4 = new JPanel(new GridLayout(2, 1));
		JPanel panel3 = new JPanel(new GridLayout(2, 1));
		
		panel2.add(sair);
		panel.add(submeter);
		
	
		text1.setText("USERNAME :");
		text1.setEditable(false);
		text1.setFont(new Font("SansSerif :", Font.BOLD, 20));
		
		text2.setText("PASSWORD :");
		text2.setEditable(false);
		text2.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		text3.setText("Confirmar PASSWORD :");
		text3.setEditable(false);
		text3.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		text4.setText("Token de Acesso Facebook :");
		text4.setEditable(false);
		text4.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		text5.setText("Token de Acesso Twitter: setOAuthConsumerKey");
		text5.setEditable(false);
		text5.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		text9.setText("Token de Acesso Twitter: setOAuthConsumerSecret");
		text9.setEditable(false);
		text9.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		text10.setText("Token de Acesso Twitter: setOAuthAccessToken");
		text10.setEditable(false);
		text10.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		text11.setText("Token de Acesso Twitter: setOAuthAccessTokenSecret");
		text11.setEditable(false);
		text11.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		text6.setText("Conta de Email :");
		text6.setEditable(false);
		text6.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		text7.setText("Palavra-Passe de Email :");
		text7.setEditable(false);
		text7.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		text8.setText("Confirmar Palavra-Passe de Email :");
		text8.setEditable(false);
		text8.setFont(new Font("SansSerif", Font.BOLD, 20));
	
		Color color= new Color(128,128,255);
		
		escreve1.setBackground(color);
		escreve2.setBackground(color);
		escreve3.setBackground(color);
		escreve4.setBackground(color);
		escreve5.setBackground(color);
		escreve6.setBackground(color);
		escreve7.setBackground(color);
		escreve8.setBackground(color);
		escreve9.setBackground(color);
		escreve10.setBackground(color);
		escreve11.setBackground(color);
		
		escreve1.setForeground(Color.white);
		escreve2.setForeground(Color.white);
		escreve3.setForeground(Color.white);
		escreve4.setForeground(Color.white);
		escreve5.setForeground(Color.white);
		escreve6.setForeground(Color.white);
		escreve7.setForeground(Color.white);
		escreve8.setForeground(Color.white);
		escreve9.setForeground(Color.white);
		escreve10.setForeground(Color.white);
		escreve11.setForeground(Color.white);
		
		JCheckBox b = new JCheckBox("Ver password");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b.isSelected()) {
					escreve2.setEchoChar((char)0);
				}
				else {
					escreve2.setEchoChar('\u25CF');
				}
			}
	});	
		
		JCheckBox b1 = new JCheckBox("Ver password");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b1.isSelected()) {
					escreve3.setEchoChar((char)0);
				}
				else {
					escreve3.setEchoChar('\u25CF');
				}
			}
	});	
		
		JCheckBox b2 = new JCheckBox("Ver password");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b2.isSelected()) {
					escreve7.setEchoChar((char)0);
				}
				else {
					escreve7.setEchoChar('\u25CF');
				}
			}
	});	
		
		JCheckBox b3 = new JCheckBox("Ver password");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b3.isSelected()) {
					escreve8.setEchoChar((char)0);
				}
				else {
					escreve8.setEchoChar('\u25CF');
				}
			}
	});	
		
			
		panel1.add(escreve2);
		panel1.add(b);
		panel3.add(escreve3);
		panel3.add(b1);
		panel4.add(escreve7);
		panel4.add(b2);
		panel5.add(escreve8);
		panel5.add(b3);
		
		
		search.add(text1);
		search.add(escreve1);
		search.add(text2);
		search.add(panel1);
		search.add(text3);
		search.add(panel3);
		search.add(text4);
		search.add(escreve4);
		search.add(text5);
		search.add(escreve5);
		search.add(text9);
		search.add(escreve9);
		search.add(text10);
		search.add(escreve10);
		search.add(text11);
		search.add(escreve11);
		search.add(text6);
		search.add(escreve6);
		search.add(text7);
		search.add(panel4);
		search.add(text8);
		search.add(panel5);
		search.add(panel2);
		search.add(panel);
		
		frame.add(search);
		
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					frame.setVisible(false);
					InterfaceInicio in = new InterfaceInicio (bda);
					in.open();
							
				
				
			}
	});	
		
		registocomsucesso();
		Sairsemguardar();

	}

	private void registocomsucesso() {
			
			submeter.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					s= new String(escreve2.getPassword());
					s1= new String(escreve3.getPassword());
					s2= new String(escreve7.getPassword());
					s3= new String(escreve8.getPassword());
				
					if(escreve1.getText().equals("") || s.equals("") || s1.equals("") ||escreve4.getText().equals("")||escreve5.getText().equals("")||escreve6.getText().equals("")||s2.equals("")||s3.equals("")) {
						JOptionPane.showMessageDialog(frame, "Campos de escrita obrigatórios");
					
					}	
						else {
								if(!(s.equals(s1)))  {
								JOptionPane.showMessageDialog(frame, "Reintrodução da PASSWORD da Aplicação errada, por favor tente novamente!");	
								
							}
									else {
										if(!(s2.equals(s3)))  {
											JOptionPane.showMessageDialog(frame, "Reintrodução da PASSWORD da Conta de Email errada, por favor tente novamente!");	
									
										}
										else {
											if(escreve1.getText().contains(" ") || s.contains(" ") || escreve4.getText().contains(" ") || escreve5.getText().contains(" ") || escreve9.getText().contains(" ") || escreve10.getText().contains(" ") || escreve11.getText().contains(" ") || escreve6.getText().contains(" ") || s2.contains(" ")) {
											JOptionPane.showMessageDialog(frame, "AVISO: Todos os campos para preencher não podem ter espaço entre palavras!");
											}
										
											else {
												JOptionPane.showMessageDialog(frame, "Registo realizado com sucesso!");
												frame.setVisible(false);
												InterfaceInicio in = new InterfaceInicio (bda);
												in.open();
												try {
													AddToFile();
													
												} catch (Exception e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
											}
										}
							}
					
					}
			}
		});	
			
	}
	
	public void  Sairsemguardar() {
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					frame.setVisible(false);
					InterfaceInicio in = new InterfaceInicio (bda);
					in.open();
							
				
				
			}
	});		
}	
	
	public void  AddToFile() throws Exception {
		
		SignIN i= new SignIN(escreve1.getText(),s,escreve4.getText(),escreve5.getText(),escreve9.getText(),escreve10.getText(),escreve11.getText(),escreve6.getText(),s2);
		AddToFile a = new AddToFile (bda.getXml().getDoc(),i);
		Save s= new Save(bda.getXml().getDoc());
	}
}
