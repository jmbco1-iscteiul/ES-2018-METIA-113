package MainWork;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class InterfaceLogin {
	private JFrame frame;
	private JButton entrar= new JButton("ENTRAR");
	private JTextField escreve1 = new JTextField();
	private JTextField escreve2 = new JTextField();
	private BomDiaAcademia bda;
	
	public InterfaceLogin() {
		
		frame = new JFrame("LOGIN NA APLICAÇÃO");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
	}
	
	public void open() {
		
		frame.setSize(1000, 300);
		frame.setVisible(true);

	}
	
	private void addFrameContent() {

		JPanel search = new JPanel(new GridLayout(4, 2));
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		
		JTextArea text1 = new JTextArea();
		JTextArea text2 = new JTextArea();			

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
	
		search.add(text1);
		search.add(escreve1);
		search.add(text2);
		search.add(escreve2);
		search.add(panel);
		search.add(panel1);
		
		frame.add(search,BorderLayout.CENTER);
		
		LoginNaAplicação();
	
		   
	}

	
	public void  LoginNaAplicação() {
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(escreve1.getText().equals("") || escreve2.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Campos de escrita obrigatórios");
					System.out.println(escreve2.getText());
					System.out.println(escreve1.getText());
				}	
					else {
							frame.setVisible(false);
							Interfacegrafica  in =  bda.getI ();
							in.open();
						}
				
			}
	});	
		
	}
	




}
