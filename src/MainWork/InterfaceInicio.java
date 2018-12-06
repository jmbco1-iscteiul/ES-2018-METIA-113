package MainWork;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Interface gráfica inicial da aplicação onde se pode escolher entre fazer o login(entrar na aplicação tendo o registo já efetuado)
 * ou sign in(fazer o registo na aplicação com os respetivos dados)
 * @author Brogueira
 */
public class InterfaceInicio {

	private JFrame frame;
	private JButton blogin = new JButton("LOGIN");
	private JButton bsignin = new JButton("SIGN IN");
	private JButton balterar = new JButton("CLIQUE AQUI");
	private BomDiaAcademia bda;

	public InterfaceInicio(BomDiaAcademia bda) {

		this.bda=bda;
		frame = new JFrame("ENTRY MENU");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
	}

	/**
	 * Função que abre a janela principal e lhe o tamanha pretendido
	 * @author Brogueira
	 * 
	 */

	public void open() {
		frame.setSize(1000, 200);
		frame.setVisible(true);
	}

	/**
	 * Função que cria a disposição dos botões, onde se escolhe entre fazer login, sign in ou alterar a password
	 *  @author Brogueira
	 */

	private void addFrameContent() {

		JPanel search = new JPanel(new GridLayout(4, 2));
		JPanel panel = new JPanel();
		JPanel panel1= new JPanel();
		JPanel panel5= new JPanel();
		JPanel panel4= new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3= new JPanel();
		JTextArea text1 = new JTextArea();
		JTextArea text2 = new JTextArea();


		text1.setText("            SEJA MUITO BEM-VINDO À APLICAÇÃO DO");
		text1.setEditable(false);
		text1.setFont(new Font("SansSerif", Font.BOLD, 20));
		text2.setEditable(false);
		Color color= new Color(128,128,255);
		text1.setForeground(color);
		text2.setForeground(color);
		text2.setText("GRUPO 113 DE ES1!");
		text2.setFont(new Font("SansSerif", Font.BOLD, 20));


		panel.add(blogin);
		panel1.add(bsignin);

		JTextField a= new JTextField("Pretende alterar a password e/ou o username?");
		a.setEditable(false);


		panel5.add(a,BorderLayout.CENTER);
		panel5.add(balterar,BorderLayout.WEST);

		search.add(text1);
		search.add(text2);
		search.add(panel2);
		search.add(panel3);
		search.add(panel);
		search.add(panel1);
		search.add(panel4);
		search.add(panel5);

		frame.add(search);

		InterfaceSignIn();
		InterfaceLogin();
		Interfaceeditar();

	}

	/**
	 * Função que abre a interface de sign in, onde se faz o registo de utilizador
	 * @author Brogueira
	 */

	public void InterfaceSignIn()  {
		bsignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InterfaceSignIn in = new InterfaceSignIn (bda);
				in.open();
			}
		});	
	}

	/** 
	 * Função que abre a interface de login onde se introduz os dados para entrar na aplicação
	 * @author Brogueira
	 */

	public void InterfaceLogin()  {
		blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				InterfaceLogin login = new InterfaceLogin (bda);
				login.open();
			}
		});	
	}

	/**
	 * Função que abre a interface onde se atualizam os dados de utilizador
	 * @author Brogueira
	 */

	public void Interfaceeditar()  {
		balterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Interfaceeditar editar = new Interfaceeditar (bda);
				editar.open();
			}
		});	

	}

}
