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
	import javax.swing.JCheckBox;
	import javax.swing.JFrame;
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
		private JFrame frame;
		private JButton executar= new JButton("Mostrar Timeline");
		private BomDiaAcademia bda;
		private DefaultListModel<Mensagem> model;
		private JTextField t= new JTextField();
		
		public InterfacePeriododaInformacao(BomDiaAcademia bda, DefaultListModel<Mensagem> model) {
			this.bda=bda;
			this.model=model;
			frame = new JFrame("LOGIN NA APLICAÇÃO");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			addFrameContent();
			frame.pack();
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
					bda.getFacebook().timeline(model);
					bda.getTwitter().getTimeline(model);
					bda.getMail().caixaChegada(model);
								
								InterfaceInicio  in =  new InterfaceInicio (bda);
								in.open();
							
					
				}
		});	
			
		}
		
		
}
