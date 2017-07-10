package com.mau.introductionSwing.gui;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Fenetre1 extends JFrame implements ActionListener {
	
	private JButton bouton1;
	private JTextField champTexte1;
	private JCheckBox caseCoche1;
    private JLabel label1;
    private JTextArea champMultiLigne;
    private MonListerner1 listerner1;
    
    
	public Fenetre1() throws HeadlessException {
		
		super(" fenetre 1");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		bouton1 = new JButton(" cliquer moi!");
		add(bouton1);
		
		champTexte1 = new JTextField(30);
		add(champTexte1);
		
		
		caseCoche1 = new JCheckBox("cocher moi!");
		add(caseCoche1);
		
		label1 = new JLabel(" je suis un label");
		add(label1);
		
		champMultiLigne = new JTextArea(5, 25);
		add(champMultiLigne);
		
		
		// demanderau bouton de prevenir mon objet  fenetre (qui est ActionListern)
		// quand il est cliqué
		
		bouton1.addActionListener(this);
		listerner1 = new MonListerner1(" premier listerner externe");
		caseCoche1.addActionListener(listerner1);
		caseCoche1.addActionListener(new MonListerner2(" deuxieme listern interne"));
		
		
		// classe anonyme interne
//		bouton1.addActionListener( new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				label1.setText("classe anonyme");
//				
//			}
//		});
		
		// une classe  lambda qui equivaut à ce que la cle=asse anonyme précedent fait.
		bouton1.addActionListener(e -> label1.setText("yolo le lambda"));
		
		
		
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "vous avez cliquez");
		
	}
	
	
	// debut classe interne 
	public class MonListerner2 implements ActionListener{
		private String name;

		public MonListerner2(String name) {
			this.name = name;
		}

		public String getName() {return name;}

		public void setName(String name) {this.name = name;}

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "action de " + getName());
			
			label1.setText(getName() + "was here on" + new Date());
		}
		
		
		
	}
	
    // fin classe interne
}
