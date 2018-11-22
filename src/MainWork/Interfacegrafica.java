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
 * Interface gráfica principal desenvolvida, com todos os botões descritos para Facebook, Twitter e E-mail. Também
 * se apresenta a barra de pesquisa e o botão  respetivo (search).
 * 
 * @author Brogueira
 *
 */
public class Interfacegrafica{

	private JFrame frame;
	private BomDiaAcademia bda;

	private JTextField label = new JTextField();
	private JTextField textface = new JTextField();
	private JTextField textmail = new JTextField();
	private JTextField texttwitter = new JTextField();
	private JTextField textde = new JTextField();
	private JTextField textpara = new JTextField();
	private JButton bface = new JButton("TimeLine");
	private JButton bmail = new JButton("TimeLine");
	private JButton btwitter = new JButton("TimeLine");
	private	JButton bfaceprocurar = new JButton("Procurar Palavra");
	private JButton bmailprocurar = new JButton("Procurar Palavra");
	private JButton btwitterprocurar = new JButton("Procurar Palavra");
	private JButton borigem = new JButton("Origem");
	private JButton bkeyword = new JButton("Palavra-Chave");
	private	JButton bperiodoinfo = new JButton("Período da Informação");
	private	JButton bescreverpost = new JButton("Escrever Post");
	private	JButton bescreverpostf = new JButton("Escrever Post");
	private	JButton bescrevermail = new JButton("Escrever Email");
	private	DefaultListModel<String> model = new DefaultListModel<>();
	private	JList<String> list = new JList<>(model);

	
	public Interfacegrafica(BomDiaAcademia bda) {
		
		this.bda = bda;

		frame = new JFrame("MAIN MENU");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
		open();
		
		getFaceTimeLine();
		getTwitterTimeLine();
		getEmailTimeLine();
		
		escreverPostFace();
		escreverPostTwitter();
		escreverMail();
		
		procurarpalavraFace();
		procurarpalavraTwitter();
		procurarpalavraMail();	
	}
/**
 * 
 * Fun��o que abre a janela principal e lhe o tamanha pretendido
 * 
 * @author Brogueira
 * 
 */
	public void open() {

		frame.setSize(1000, 900);
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
		JPanel panel16= new JPanel(new GridLayout(6,1));
		JPanel panel15= new JPanel();
		JPanel panel14= new JPanel();
		JPanel panel17= new JPanel(new GridLayout(2,1));
		JPanel panel18= new JPanel();
		JPanel panel1= new JPanel(new GridLayout(2,1));
		JPanel panel13= new JPanel(new GridLayout(5,1));
		JPanel panel19= new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel20 = new JPanel();
		JPanel panel21 = new JPanel();
		Color color= new Color(128,128,255);
		
		list.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		Dimension d1= new Dimension(500,20);
		label.setPreferredSize(d1);
		JTextArea area3 = new JTextArea();
		area3.setText("Escrever palavra que desejar procurar:");
		area3.setEditable(false);
		
		area3.setFont(new Font("SansSerif", Font.BOLD, 15));
		area3.setForeground(color);
		panelp.add(area3, BorderLayout.CENTER);
		panelp.add(label, BorderLayout.EAST);


		JTextArea area1 = new JTextArea();
		area1.setText("Filtros:");
		area1.setEditable(false);
		area1.setFont(new Font("SansSerif", Font.BOLD, 40));
		area1.setForeground(color);
		Dimension d10= new Dimension(490,30);
		area1.setPreferredSize(d10);
		panel13.add(area1);


		
		panel7.add(borigem);
		panel13.add(panel7);

		panel8.add(bkeyword);
		panel13.add(panel8);

		panel9.add(bperiodoinfo);
		panel13.add(panel9);

		

		JTextArea area = new JTextArea();
		area.setText("Plataformas Online:");
		area.setEditable(false);
		area.setFont(new Font("SansSerif", Font.BOLD, 45));
		area.setForeground(color);
		
		panel13.add(area);
		panel19.add(panel13);
		panel20.add(panel13);
//		panel1.add(panel13);
		bface.setFont(new Font("SansSerif", Font.BOLD, 20));
		bmail.setFont(new Font("SansSerif", Font.BOLD, 20));
		btwitter.setFont(new Font("SansSerif", Font.BOLD, 20));
		bfaceprocurar.setFont(new Font("SansSerif", Font.BOLD, 15));
		bmailprocurar.setFont(new Font("SansSerif", Font.BOLD, 15));
		btwitterprocurar.setFont(new Font("SansSerif", Font.BOLD, 15));

		Dimension d5= new Dimension(150,60);
		bface.setPreferredSize(d5);
		bmail.setPreferredSize(d5);
		btwitter.setPreferredSize(d5);
		
		Dimension d8= new Dimension(180,60);
		bfaceprocurar.setPreferredSize(d8);
		bmailprocurar.setPreferredSize(d8);
		btwitterprocurar.setPreferredSize(d8);
		
		Dimension d6= new Dimension(300,30);
		textmail.setPreferredSize(d6);
		texttwitter.setPreferredSize(d6);
		textface.setPreferredSize(d6);
		

		JTextArea face = new JTextArea();
		face.setText("FACEBOOK:");
		face.setEditable(false);
		face.setFont(new Font("SansSerif", Font.BOLD, 20));
		face.setForeground(color);
		panel2.add(face);
		panel2.add(bface);
		panel2.add(bfaceprocurar);
		
		panel14.add(textface, BorderLayout.CENTER);
		panel14.add(bescreverpostf, BorderLayout.EAST);
		
		panel16.add(panel2);
		panel16.add(panel14);

	
		JTextArea twitter = new JTextArea();
		twitter.setText("TWITTER:");
		twitter.setEditable(false);
		twitter.setFont(new Font("SansSerif", Font.BOLD, 20));
		twitter.setForeground(color);
		panel3.add(twitter);
		panel3.add(btwitter);
		panel3.add(btwitterprocurar);
		
		panel15.add(texttwitter, BorderLayout.CENTER);
		panel15.add(bescreverpost, BorderLayout.EAST);
		
		panel16.add(panel3);
		panel16.add(panel15);

		JTextArea mail = new JTextArea();
		mail.setText("E-MAIL:");
		mail.setEditable(false);
		mail.setFont(new Font("SansSerif", Font.BOLD, 20));
		mail.setForeground(color);
		panel4.add(mail);
		panel4.add(bmail);
		panel4.add(bmailprocurar);
		panel16.add(panel4);
		
		panel6.add(textmail, BorderLayout.CENTER);
		panel6.add(bescrevermail, BorderLayout.EAST);
		panel17.add(panel6);
		
		Dimension d7= new Dimension(200,30);
		textpara.setPreferredSize(d7);
		textde.setPreferredSize(d7);
		
		JTextArea area2 = new JTextArea();
		area2.setText("Para:");
		area2.setEditable(false);
		area2.setFont(new Font("SansSerif", Font.BOLD, 15));
		area2.setForeground(color);
		
		JTextArea area4 = new JTextArea();
		area4.setText("De:");
		area4.setEditable(false);
		area4.setFont(new Font("SansSerif", Font.BOLD, 15));
		area4.setForeground(color);
		
		panel19.add(area4, BorderLayout.CENTER);
		panel19.add(textde, BorderLayout.EAST);
		
		panel19.add(area2, BorderLayout.CENTER);
		panel19.add(textpara, BorderLayout.EAST);
		

		panel17.add(panel19);
		panel16.add(panel17);
		
		panel18.add(panel16);
		
		panel21.add(panel20);
		panel21.add(panel18);
		
		panelp.add(search);
		panelp1.add(panel21);
		//				panelp2.add(panel6);

		JScrollPane scrollpane1 = new JScrollPane(list);
		panelp1.add(scrollpane1);



	

		frame.add(panelp,BorderLayout.NORTH);
		frame.add(panelp1);

	}
//
//	/**
//	 * Fun��o onde que faz a pesquisa de uma palava inserida, na barra de pesquisa, clicando bot�o Facebook.
//	 * Aqui faz-se a pesquisa de de todos os estados onde se encontre a palavra pretendida 
//	 * @author Brogueira
//	 */

	
	public void getFaceTimeLine() {
		bface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				bda.getFacebook().timeline(model);
			}
		});
	}
	
	public void getTwitterTimeLine() {
		btwitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				bda.getTwitter().getTimeline(model);
			}
		});
	}
	
	public void getEmailTimeLine() {
		bmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				bda.getMail().caixaChegada(model);
			}
		});
	}


  public void escreverPostFace() {
	  bescreverpostf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				String procurar=textface.getText();
				System.out.println(procurar);
				bda.getFacebook();
			}
		});
  }
  
  public void escreverPostTwitter() {
	  bescreverpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				String procurar=texttwitter.getText();
				System.out.println(procurar);
				bda.getTwitter().updateStatus(procurar);
			}
		});
  }
  
  public void escreverMail() {
	  bescrevermail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				String procurar=textmail.getText();
				System.out.println(procurar);
				bda.getMail().sendMail(textpara.getText(),textmail.getText(),textde.getText());
			}
		});
  }
  
  public void procurarpalavraFace() {
	  bfaceprocurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				String procurar=label.getText();
				System.out.println(procurar);
				bda.getFacebook().search(procurar,model);
			}
		});
  }
  
  public void procurarpalavraTwitter() {
	  btwitterprocurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				String procurar=label.getText();
				System.out.println(procurar);
				bda.getTwitter().searchTweet(procurar, model);
			}
		});
  }
  
  public void procurarpalavraMail() {
	  bmailprocurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				String procurar=label.getText();
				System.out.println(procurar);
				bda.getMail().procurarpalavra(model,procurar);
			}
		});
  }
  
  
}
