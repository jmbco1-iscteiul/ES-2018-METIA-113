package MainWork;

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

public class InterfaceSignIn {

	
	private JFrame frame;
	private JButton submeter= new JButton("SUBMETER");
	private JButton sair= new JButton("Sair sem Guardar");
	private JTextField escreve2 = new JTextField();
	private JTextField escreve3 = new JTextField();
	private JTextField escreve1 = new JTextField();
	private JTextField escreve4 = new JTextField();
	private JTextField escreve5 = new JTextField();
	private JTextField escreve6 = new JTextField();
	private JTextField escreve7 = new JTextField();
	private JTextField escreve8 = new JTextField();
	private BomDiaAcademia bda;
	
	public InterfaceSignIn(BomDiaAcademia bda) {
		this.bda=bda;
		frame = new JFrame("REGISTO NA APLICAÇÃO");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
	}
	
	public void open() {
		
		frame.setSize(1000, 400);
		frame.setVisible(true);

	}
	
	private void addFrameContent() {

		JPanel search = new JPanel(new GridLayout(9, 2));
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
		
		text5.setText("Token de Acesso Twitter :");
		text5.setEditable(false);
		text5.setFont(new Font("SansSerif", Font.BOLD, 20));
		
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
		
		escreve1.setForeground(Color.white);
		escreve2.setForeground(Color.white);
		escreve3.setForeground(Color.white);
		escreve4.setForeground(Color.white);
		escreve5.setForeground(Color.white);
		escreve6.setForeground(Color.white);
		escreve7.setForeground(Color.white);
		escreve8.setForeground(Color.white);
		
		
		search.add(text1);
		search.add(escreve1);
		search.add(text2);
		search.add(escreve2);
		search.add(text3);
		search.add(escreve3);
		search.add(text4);
		search.add(escreve4);
		search.add(text5);
		search.add(escreve5);
		search.add(text6);
		search.add(escreve6);
		search.add(text7);
		search.add(escreve7);
		search.add(text8);
		search.add(escreve8);
		search.add(panel2);
		search.add(panel);
		
		frame.add(search);
		
		registocomsucesso();
		Sairsemguardar();

	}

	private void registocomsucesso() {
		
			submeter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					if(escreve1.getText().equals("") || escreve2.getText().equals("") || escreve3.getText().equals("") ||escreve4.getText().equals("")||escreve5.getText().equals("")||escreve6.getText().equals("")||escreve7.getText().equals("")||escreve8.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Campos de escrita obrigatórios");
					
					}	
						else {
							if(!escreve2.getText().equals(escreve3.getText()))  {
								JOptionPane.showMessageDialog(frame, "Reintrodução da PASSWORD da Aplicação errada, por favor tente novamente!");	
								
							}
							else {
								if(!escreve7.getText().equals(escreve8.getText()))  {
									JOptionPane.showMessageDialog(frame, "Reintrodução da PASSWORD da Conta de Email errada, por favor tente novamente!");	
									
								}
								else {
									frame.setVisible(false);
									InterfaceInicio in = new InterfaceInicio (bda);
									in.open();
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
}
