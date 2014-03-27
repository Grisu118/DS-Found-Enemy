package ch.grisu118.diestämme.foundenemy.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {
	
	private final JPanel southPanel;
	
	public MainGUI() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 1024, 750);
		setMinimumSize(new Dimension(600, 450));
		setTitle("DS - Found enemy by Grisu118");
		
		getContentPane().setLayout(new BorderLayout());
		
		southPanel = new JPanel();
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		
		
	}
	
	public JPanel geSouthPanel() {
		return this.southPanel;
	}
	
	

}
