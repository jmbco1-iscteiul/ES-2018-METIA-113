package MainWork;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import facebook.Facebook;

/**
 * Interface gráfica principal desenvolvida, com todos os butões descritos para Facebook, Twitter e E-mail. Também
 * se apresenta a barra de pesquisa e o botão  respetivo (search).
 * 
 * @author Brogueira
 *
 */
public class Interfacegrafica{

	private JFrame frame;
	private BomDiaAcademia bda;

	JTextField label = new JTextField();
	JTextArea text1 = new JTextArea();
	JTextArea text2 = new JTextArea();
	JButton bface = new JButton("FACEBOOK");
	JButton bmail = new JButton("EMAIL");
	JButton btwitter = new JButton("TWITTER");
	JButton borigem = new JButton("Origem");
	JButton bkeyword = new JButton("Palavra-Chave");
	JButton bperiodoinfo = new JButton("Período da Informação");
	DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> list = new JList<>(model);

	
	public Interfacegrafica(BomDiaAcademia bda) {
		
		this.bda = bda;

		frame = new JFrame("MAIN MENU");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
		open();
	}
/**
 * 
 * Fun��o que abre a janela principal e lhe o tamanha pretendido
 * 
 * @author Brogueira
 * 
 */
	public void open() {

		frame.setSize(1000, 1000);
		frame.setVisible(true);

	}
/**
 * 
 * Fun��o que cria a disposi��o dos bot�es, da barra e da caixa onde se representa os resultados das pesquisas.
 * � criado um Layout principal e posteriormente os Layouts secund�rios.
 * 
 * @author Brogueira
 * 
 */
	private void addFrameContent() {

		JPanel search = new JPanel(new GridLayout(1, 2));
		JPanel panelp = new JPanel();
		JPanel panelp1 = new JPanel(new GridLayout(1,2));
		//				JPanel panelp2 = new JPanel(new GridLayout(1,2));
		JPanel panel1= new JPanel(new GridLayout(5,1));
		JPanel panel13= new JPanel(new GridLayout(4,1));
		JPanel panel6= new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();

		Dimension d1= new Dimension(500,30);
		label.setPreferredSize(d1);
		panelp.add(label, BorderLayout.CENTER);

		JPanel panel12 = new JPanel();

		JTextArea area1 = new JTextArea();
		area1.setText("Filtros:");
		area1.setEditable(false);
		Color color= new Color(128,128,255);
		area1.setFont(new Font("SansSerif", Font.BOLD, 40));
		area1.setForeground(color);
		panel13.add(area1);


		panel7.add(borigem);
		panel13.add(panel7);

		panel8.add(bkeyword);
		panel13.add(panel8);

		panel9.add(bperiodoinfo);
		panel13.add(panel9);

		panel1.add(panel13);

		JTextArea area = new JTextArea();
		area.setText("Plataformas Online:");
		area.setEditable(false);
		area.setFont(new Font("SansSerif", Font.BOLD, 45));
		area.setForeground(color);
		Dimension d4= new Dimension(490,60);
		area.setPreferredSize(d4);
		panel12.add(area);
		panel1.add(panel12);

		bface.setFont(new Font("SansSerif", Font.BOLD, 20));
		bmail.setFont(new Font("SansSerif", Font.BOLD, 20));
		btwitter.setFont(new Font("SansSerif", Font.BOLD, 20));

		Dimension d5= new Dimension(160,60);
		bface.setPreferredSize(d5);
		bface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String procurar=label.getText();
				System.out.println(procurar);
				bda.getFacebook().search(procurar,model);
			}
		});	
		panel2.add(bface);
		panel1.add(panel2);

		bmail.setPreferredSize(d5);
		panel3.add(bmail);
		panel1.add(panel3);

		btwitter.setPreferredSize(d5);
		panel4.add(btwitter);
		panel1.add(panel4);

		panelp.add(search);
		panelp1.add(panel1);
		//				panelp2.add(panel6);

		JScrollPane scrollpane1 = new JScrollPane(list);
		panelp1.add(scrollpane1);

		Dimension d2= new Dimension(170,60);
		panelp.setPreferredSize(d2);

		Dimension d3= new Dimension(170,900);
		panelp1.setPreferredSize(d3);

		frame.add(panelp,BorderLayout.NORTH);
		frame.add(panelp1,BorderLayout.SOUTH);

	}
//
//	/**
//	 * Fun��o onde que faz a pesquisa de uma palava inserida, na barra de pesquisa, clicando bot�o Facebook.
//	 * Aqui faz-se a pesquisa de de todos os estados onde se encontre a palavra pretendida 
//	 * @author Brogueira
//	 */

}


