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

public class InterfaceLogin {
	private JFrame frame;
	private JButton voltar= new JButton("Voltar ao Início");
	private JButton entrar= new JButton("ENTRAR");
	private JTextField escreve1 = new JTextField();
	private JPasswordField escreve2 = new JPasswordField();
	private BomDiaAcademia bda;
	
	public InterfaceLogin(BomDiaAcademia bda) {
		this.bda=bda;
		frame = new JFrame("LOGIN NA APLICAÇÃO");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
	}
	
	public void open() {
		
		frame.setSize(1000, 250);
		frame.setVisible(true);

	}
	
	private void addFrameContent() {

		JPanel search = new JPanel(new GridLayout(3, 2));
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel(new GridLayout(2, 1));
		
		JTextArea text1 = new JTextArea();
		JTextArea text2 = new JTextArea();			
		
		panel.add(voltar);
		panel1.add(entrar);
	
		text1.setText("USERNAME");
		text1.setEditable(false);
		text1.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		text2.setText("Password");
		text2.setEditable(false);
		text2.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		Color color= new Color(128,128,255);
		
		escreve1.setBackground(color);
		escreve2.setBackground(color);
		
		escreve1.setForeground(Color.white);
		escreve2.setForeground(Color.white);
		
		JCheckBox b = new JCheckBox("Ver password");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b.isSelected()) {
					escreve2.setEchoChar((char)0);
				}
				else {
					escreve2.setEchoChar('*');
				}
			}
	});	
		
		panel2.add(escreve2);
		panel2.add(b);
	
		search.add(text1);
		search.add(escreve1);
		search.add(text2);
		search.add(panel2);
		search.add(panel);
		search.add(panel1);
		
		frame.add(search,BorderLayout.CENTER);
		
		LoginNaAplicação();
		VoltaraoInicio();
		   
	}

	
	public void  LoginNaAplicação() {
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s= new String(escreve2.getPassword());
				if(escreve1.getText().equals("") || s.equals("")) {
					JOptionPane.showMessageDialog(frame, "Campos de escrita obrigatórios");
					System.out.println(s);
					System.out.println(escreve1.getText());
				}	
					else {
							frame.setVisible(false);
							Interfacegrafica  in =  new Interfacegrafica (bda);
							in.open();
						}
				
			}
	});	
		
	}
	
	public void  VoltaraoInicio() {
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
							frame.setVisible(false);
							InterfaceInicio  in =  new InterfaceInicio (bda);
							in.open();
						
				
			}
	});	
		
	}




}
