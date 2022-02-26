package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Home extends JFrame implements ActionListener {
	
	private JPanel mainPanel;
	private JButton add_user, add_books, issue_book, return_book, stats;
	private JMenuBar menuBar;
	private JMenu records, help, exit;
	private JMenuItem logout, sys_exit, contact_us, users_details, all_records;
	public Home() {
		
		super("Library Management System");
		ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
		this.setIconImage(appicon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(280, 70, 800, 600);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		this.setContentPane(mainPanel);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 30);
		menuBar.setBackground(Color.yellow);
		mainPanel.add(menuBar);
		
		records = new JMenu("Record");
		records.setFont(new Font("MV BOLI", Font.BOLD, 15));
		records.setForeground(Color.RED);
		records.setMnemonic(KeyEvent.VK_R);// press alt + R key to open record
		
		help = new JMenu("Help");
		help.setFont(new Font("MV BOLI", Font.BOLD, 15));
		help.setMnemonic(KeyEvent.VK_H);// press alt + H key to open help
		help.setForeground(Color.RED);
		
		exit = new JMenu("Exit");
		exit.setFont(new Font("MV BOLI", Font.BOLD, 15));
		exit.setMnemonic(KeyEvent.VK_E);// press alt + E key to open exit
		exit.setForeground(Color.RED);
		
		users_details = new JMenuItem("Users Details");
		users_details.setFont(new Font("MV BOLI", Font.BOLD, 10));
		users_details.addActionListener(this);
		records.add(users_details);
		users_details.setMnemonic(KeyEvent.VK_U);// press U key to open user details
		
		all_records = new JMenuItem("Records");
		all_records.setFont(new Font("MV BOLI", Font.BOLD, 10));
		all_records.addActionListener(this);
		records.add(all_records);
		all_records.setMnemonic(KeyEvent.VK_R);// press R key to open records
		
		logout = new JMenuItem("Logout");
		logout.setFont(new Font("MV BOLI", Font.BOLD, 10));
		logout.addActionListener(this);
		exit.add(logout);
		logout.setMnemonic(KeyEvent.VK_L);// press L key to open logout
		
		sys_exit = new JMenuItem("Exit");
		sys_exit.setFont(new Font("MV BOLI", Font.BOLD, 10));
		sys_exit.addActionListener(this);
		exit.add(sys_exit);
		sys_exit.setMnemonic(KeyEvent.VK_E);// press E key to open exit
		
		contact_us = new JMenuItem("Contact Us");
		contact_us.setFont(new Font("MV BOLI", Font.BOLD, 10));
		contact_us.addActionListener(this);
		help.add(contact_us);
		contact_us.setMnemonic(KeyEvent.VK_C);// press C key to open contact us
		
		menuBar.add(records);
		menuBar.add(help);
		menuBar.add(exit);
		
		JLabel name = new JLabel("Library Management System");
		name.setForeground(Color.CYAN);
		name.setBounds(250, 48, 330, 40);
		name.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		mainPanel.add(name);
		
		ImageIcon addUserImgIcn = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AddUserIcon.png"));
		Image addUserImg1 = addUserImgIcn.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
		ImageIcon addUserImgIcn1 = new ImageIcon(addUserImg1);
		JLabel addUserLabel = new JLabel(addUserImgIcn1);
		addUserLabel.setBounds(80, 120, 130, 130);
		mainPanel.add(addUserLabel);
		
		add_user = new JButton("Add User");
		add_user.setBounds(83, 270, 100, 30);
		add_user.setBackground(Color.black);
		add_user.setForeground(Color.white);
		add_user.setBorder(new LineBorder(new Color(0, 0, 0)));
		add_user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add_user.setFocusable(false);
		add_user.addActionListener(this);
		mainPanel.add(add_user);
		
		ImageIcon issueBookImgIcn = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/IssueBook.png"));
		Image issueBookImg1 = issueBookImgIcn.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
		ImageIcon issueBookImgIcn1 = new ImageIcon(issueBookImg1);
		JLabel issueBookLabel = new JLabel(issueBookImgIcn1);
		issueBookLabel.setBounds(330, 120, 130, 130);
		mainPanel.add(issueBookLabel);
		
		issue_book = new JButton("Issue Book");
		issue_book.setBounds(349, 270, 100, 30);
		issue_book.setBackground(Color.black);
		issue_book.setForeground(Color.white);
		issue_book.setBorder(new LineBorder(new Color(0, 0, 0)));
		issue_book.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		issue_book.setFocusable(false);
		issue_book.addActionListener(this);
		mainPanel.add(issue_book);
		
		ImageIcon returnBookImgIcn = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/ReturnBook.png"));
		Image returnBookImg1 = returnBookImgIcn.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
		ImageIcon returnBookImgIcn1 = new ImageIcon(returnBookImg1);
		JLabel returnBookLabel = new JLabel(returnBookImgIcn1);
		returnBookLabel.setBounds(588, 120, 130, 130);
		mainPanel.add(returnBookLabel);
		
		return_book = new JButton("Return Book");
		return_book.setBounds(598, 270, 120, 30);
		return_book.setBackground(Color.black);
		return_book.setForeground(Color.white);
		return_book.setBorder(new LineBorder(new Color(0, 0, 0)));
		return_book.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return_book.setFocusable(false);
		return_book.addActionListener(this);
		mainPanel.add(return_book);
		
		ImageIcon statsImgIcn = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/Stats.png"));
		Image statsImg1 = statsImgIcn.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
		ImageIcon statsImgIcn1 = new ImageIcon(statsImg1);
		JLabel statsLabel = new JLabel(statsImgIcn1);
		statsLabel.setBounds(190, 330, 130, 130);
		mainPanel.add(statsLabel);
		
		stats = new JButton("Status");
		stats.setBounds(203, 486, 110, 30);
		stats.setBackground(Color.black);
		stats.setForeground(Color.white);
		stats.setBorder(new LineBorder(new Color(0, 0, 0)));
		stats.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stats.setFocusable(false);
		stats.addActionListener(this);
		mainPanel.add(stats);
		
		ImageIcon addBookImgIcn = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AddBookIcon.png"));
		Image addBookImg1 = addUserImgIcn.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
		ImageIcon addBookImgIcn1 = new ImageIcon(addBookImg1);
		JLabel addBookLabel = new JLabel(addBookImgIcn1);
		addBookLabel.setBounds(480, 330, 130, 130);
		mainPanel.add(addBookLabel);
		
		add_books = new JButton("Add Books");
		add_books.setBounds(482, 486, 110, 30);
		add_books.setBackground(Color.black);
		add_books.setForeground(Color.white);
		add_books.setBorder(new LineBorder(new Color(0, 0, 0)));
		add_books.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add_books.setFocusable(false);
		add_books.addActionListener(this);
		mainPanel.add(add_books);
		
//		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/LibraryManagementBG.jpg"));
//		JLabel bg = new JLabel(img, JLabel.CENTER);
//		bg.setBounds(0, 0, 800, 600);
//		mainPanel.add(bg);
	}
	
	public static void main(String[] args) {
		new Home().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand();
		
		if(e.getSource() == add_user) {
			this.setVisible(false);
			new AddStudent().setVisible(true);
		}
		
		if(e.getSource() == add_books) {
			this.setVisible(false);
			new AddBooks().setVisible(true);
		}
		
		if(e.getSource() == issue_book) {
			this.setVisible(false);
			new IssueBook().setVisible(true);
		}
		
		if(e.getSource() == return_book) {
			this.setVisible(false);
			new ReturnBook().setVisible(true);
		}
		
		if(e.getSource() == stats) {
			this.setVisible(false);
			new Status().setVisible(true);
		}
		
		if(str.equals("Users Details")) {
			this.setVisible(false);
			new StudentDetails().setVisible(true);
		}
		
		if(str.equals("Records")) {
			this.setVisible(false);
			new Status().setVisible(true);
		}
		
		if(str.equals("Logout")) {
			int response = JOptionPane.showConfirmDialog(null, "Do You Want To LogOut?", "Confirm",
            		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(response == JOptionPane.YES_NO_OPTION) {
				this.setVisible(false);
//				System.out.println("Logout");
				new LoginPage().setVisible(true);
			}
			
		}
		
		if(str.equals("Exit")) {
			int response = JOptionPane.showConfirmDialog(null, "Do You Want To Exit?", "Confirm",
            		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(response == JOptionPane.YES_NO_OPTION) {
			System.exit(ABORT);
			}
		}
		
		if(str.equals("Contact Us")) {
			this.setVisible(false);
			new ContactUs().setVisible(true);
		}
	}
}
