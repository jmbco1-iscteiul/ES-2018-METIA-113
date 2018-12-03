package MainWork;

import java.awt.BorderLayout;
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
import javax.swing.WindowConstants;

public class Interfaceeditar {
	private JFrame frame;
	private JButton confirmar= new JButton("CONFIRMAR");
	private JButton sair= new JButton("Sair sem guardar");
	private JTextField escreve1 = new JTextField();
	private JTextField escreve2 = new JTextField();
	private JPasswordField escreve3 = new JPasswordField();
	private JPasswordField escreve4 = new JPasswordField();
	private JPasswordField escreve5 = new JPasswordField();
	private BomDiaAcademia bda;
	String s;
	String s1;
	String s2;
	
	public Interfaceeditar(BomDiaAcademia bda) {
		this.bda=bda;
		frame = new JFrame("EDITAR USERNAME/PASSWORD");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
	}
	
	public void open() {
		
		frame.setSize(1000, 400);
		frame.setVisible(true);

	}
	
	private void addFrameContent() {

		JPanel search = new JPanel(new GridLayout(6, 2));
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		
		JTextArea text1 = new JTextArea();
		JTextArea text2 = new JTextArea();
		JTextArea text3 = new JTextArea();
		JTextArea text4 = new JTextArea();
		JTextArea text5 = new JTextArea();
		JPanel panel2 = new JPanel(new GridLayout(2,1));
		JPanel panel3 = new JPanel(new GridLayout(2,1));
		JPanel panel4 = new JPanel(new GridLayout(2,1));
		
		panel.add(sair);
		panel1.add(confirmar);
	
		text1.setText("USERNAME");
		text1.setEditable(false);
		text1.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		text2.setText("Novo USERNAME");
		text2.setEditable(false);
		text2.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		text3.setText("PASSWORD");
		text3.setEditable(false);
		text3.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		text4.setText("Nova PASSWORD");
		text4.setEditable(false);
		text4.setFont(new Font("SansSerif", Font.BOLD, 20));
	
		text5.setText("Confirmar nova  PASSWORD");
		text5.setEditable(false);
		text5.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		Color color= new Color(128,128,255);
		
		escreve1.setBackground(color);
		escreve2.setBackground(color);
		escreve3.setBackground(color);
		escreve4.setBackground(color);
		escreve5.setBackground(color);
		
		escreve1.setForeground(Color.white);
		escreve2.setForeground(Color.white);
		escreve3.setForeground(Color.white);
		escreve4.setForeground(Color.white);
		escreve5.setForeground(Color.white);
		
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
					escreve4.setEchoChar((char)0);
				}
				else {
					escreve4.setEchoChar('\u25CF');
				}
			}
	});	
		
		JCheckBox b3 = new JCheckBox("Ver password");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b3.isSelected()) {
					escreve5.setEchoChar((char)0);
				}
				else {
					escreve5.setEchoChar('\u25CF');
				}
			}
	});	
		
		panel2.add(escreve3);
		panel2.add(b1);
		panel3.add(escreve4);
		panel3.add(b2);
		panel4.add(escreve5);
		panel4.add(b3);
		
		search.add(text1);
		search.add(escreve1);
		search.add(text2);
		search.add(escreve2);
		search.add(text3);
		search.add(panel2);
		search.add(text4);
		search.add(panel3);
		search.add(text5);
		search.add(panel4);
		search.add(panel);
		search.add(panel1);
		
		frame.add(search,BorderLayout.CENTER);
		
		Editadocomsucesso();
		Sairsemguardar();
	}
	
	public void  Editadocomsucesso() {
		
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s= new String(escreve4.getPassword());
				s1= new String(escreve5.getPassword());
				s2= new String(escreve3.getPassword());
				if(escreve1.getText().equals("") || escreve2.getText().equals("") || s2.equals("") || s.equals("") || s1.equals("")) {
					JOptionPane.showMessageDialog(frame, "Campos de escrita obrigatórios");
		
				}	
					else {
							if(!(s.equals(s1)))  {
								JOptionPane.showMessageDialog(frame, "Reintrodução da PASSWORD  errada, por favor tente novamente");	
								
							}
							else {
								if(escreve1.getText().contains(" ") || s.contains(" ") || escreve2.getText().contains(" ") || s1.contains(" ") ||  s2.contains(" ")) {
								JOptionPane.showMessageDialog(frame, "AVISO: Todos os campos para preencher não podem ter espaço entre palavras!");
								}
					
									else {
									try {
										EditarnoXML();
										
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
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
	
	public void EditarnoXML() throws Exception {
		SignIN i= new SignIN(escreve2.getText(),s1,"","","","","","","");
		Remove r = new Remove (bda.getXml().getDoc(),escreve1.getText(),frame,s2,i);
		if(r.isB() && r.isT()) {
		AddToFile a = new AddToFile (bda.getXml().getDoc(),i);
		Save s= new Save(bda.getXml().getDoc());
		JOptionPane.showMessageDialog(frame, "Edição efetuada com sucesso!");
		frame.setVisible(false);
		InterfaceInicio in = new InterfaceInicio (bda);
		in.open();
		}
		}
	}
	

