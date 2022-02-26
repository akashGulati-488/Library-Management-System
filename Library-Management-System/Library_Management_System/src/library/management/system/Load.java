package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Load extends JFrame implements Runnable{
	
	private JPanel main_panel;
	private JProgressBar bar;
	Thread t;
	
	public Load() {
		
		super("Please Wait");
		ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
		this.setIconImage(appicon.getImage());
		t = new Thread((Runnable) this);
		this.setBounds(400, 175, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main_panel = new JPanel();
		main_panel.setLayout(null);
		main_panel.setBackground(new Color(255, 253, 208));
		this.setContentPane(main_panel);
		
		JLabel lib_name = new JLabel();
		lib_name.setText("Library Management");
		lib_name.setForeground(new Color(173, 216, 230));
		lib_name.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lib_name.setBounds(130, 46, 500, 35);
		main_panel.add(lib_name);
		
		JLabel lib_ver = new JLabel("v1.0");
		lib_ver.setForeground(new Color(173, 216, 230));
		lib_ver.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lib_ver.setBounds(250, 90, 500, 35);
		main_panel.add(lib_ver);
		
		bar = new JProgressBar();
		bar.setStringPainted(true);
		bar.setBounds(130, 155, 300, 25);
		bar.setFont(new Font("MV BOLI", Font.BOLD, 13));
		main_panel.add(bar);
		
		JLabel loading_lbl = new JLabel("Home Page Loading...");
		loading_lbl.setBounds(194, 185, 150, 20);
		loading_lbl.setForeground(new Color(210, 105, 30));
		loading_lbl.setFont(new Font("Cosmic Sans", Font.BOLD,14));
		main_panel.add(loading_lbl);
		
		t.start();
	}
	@Override
	public void run() {
		
		try {
			for(int i = 0; i <= 100; i++) {
				bar.setValue(i);
				t.sleep(70);
			}
			this.setVisible(false);
			new Home().setVisible(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Load().setVisible(true);
	}

}
