
	import java.awt.BorderLayout;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.GridLayout;
	import javax.swing.DefaultListModel;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JList;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
	import javax.swing.WindowConstants;


	public class Interfacegrafica{
		
		private JFrame frame;
		
		JButton button = new JButton("Search");
		JTextField label = new JTextField();
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>(model);
		JTextArea text1 = new JTextArea();
		
		public Interfacegrafica() {
			
			frame = new JFrame("MAIN MENU");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			addFrameContent();
			frame.pack();
		}
		
		public void open() {
			
			frame.setSize(700, 700);
			frame.setVisible(true);

		}
		
		private void addFrameContent() {

			JPanel search = new JPanel(new GridLayout(1, 2));
			JPanel panel = new JPanel();
			JPanel panel1= new JPanel(new GridLayout(3,1));
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			JPanel panel4 = new JPanel();
			Dimension d1= new Dimension(500,30);
			label.setPreferredSize(d1);
			panel.add(label, BorderLayout.CENTER);
			panel.add(button, BorderLayout.EAST);
			frame.add(panel, BorderLayout.NORTH);

			JButton bface = new JButton("Facebook");
			panel2.add(bface);
			panel1.add(panel2);
			JButton bmail = new JButton("EMAIL");
			panel3.add(bmail);
			panel1.add(panel3);
			JButton btwitter = new JButton("TWITTER");
			panel4.add(btwitter);
			panel1.add(panel4);
			
			
			search.add(panel1,BorderLayout.WEST);

			
			text1.setWrapStyleWord(true);
			text1.setLineWrap(true);
			JScrollPane scrollpane1 = new JScrollPane(text1);
			search.add(scrollpane1);
			frame.add(search, BorderLayout.CENTER);

		
			   
		}


	

}
