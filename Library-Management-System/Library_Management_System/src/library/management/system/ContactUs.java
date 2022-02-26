package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ContactUs extends JFrame{
	
	private JPanel mainPanel;
	
	public ContactUs() {
		
		super("Library Management System");
		ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
		this.setIconImage(appicon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(40, 40, 1200, 600);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		this.setContentPane(mainPanel);
		
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/ContactUs.jpg"));
		JLabel bg = new JLabel(img);
		bg.setBounds(0, 0, 1200, 600);
		mainPanel.add(bg);
		
		JLabel back = new JLabel("Back");
		back.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent me) {
	            	setVisible(false);
	            	Home home = new Home();
	            	home.setVisible(true);
	            }
		});
		back.setForeground(Color.red);
		back.setFont(new Font("MV BOLI", Font.BOLD, 18));
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/BackIcon.png"));
	    Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    back.setIcon(i3);
	    back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    back.setBounds(40, 13, 96, 27);
		bg.add(back);
	}
	
	public static void main(String[] args) {
		new ContactUs().setVisible(true);
	}
}
