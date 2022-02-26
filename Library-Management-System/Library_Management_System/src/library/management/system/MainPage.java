package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainPage extends JFrame implements ActionListener{

	private JPanel mainPanel;
	private JLabel label;
	private JButton open;
	
	public MainPage() {
		
		super("Library Management System");
		ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
		this.setIconImage(appicon.getImage());
		this.setBounds(20, 100, 1250, 400);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		this.setContentPane(mainPanel);
		ImageIcon mainIcon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/LibraryManagementSystemIcon.jpg"));
		Image img = mainIcon.getImage().getScaledInstance(1250, 400, Image.SCALE_DEFAULT);
		ImageIcon result = new ImageIcon(img);
		label = new JLabel(result);
		open = new JButton("Open");
		open.setForeground(Color.black);
		open.setBackground(Color.white);
		open.setBorder(new LineBorder(new Color(255, 255, 255)));
		open.setFocusable(false);
		open.setBounds(1000 , 250, 120, 30);
		open.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		open.addActionListener(this);
		label.add(open);
		mainPanel.add(label);		
		
		
	}
	
	public static void main(String[] args) {
		new MainPage().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == open) {
			this.setVisible(false);
			new LoginPage().setVisible(true);
		}
		
	}
}
