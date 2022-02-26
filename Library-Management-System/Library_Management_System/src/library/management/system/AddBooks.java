package library.management.system;

import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddBooks extends JFrame implements ActionListener {
	
	private JPanel mainPanel;
	private JComboBox comboBox;
	private JTextField bookName, bookID, bookPublisher, bookMRP;
	private JButton back, add, generate_id;
	
	public AddBooks() {
		
		super("Library Management System");
		ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
		this.setIconImage(appicon.getImage());
		this.setBounds(400, 175, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		this.setContentPane(mainPanel);
		
		JLabel book_name = new JLabel("Book Name :");
		book_name.setBounds(140, 83, 120, 20);
		book_name.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(book_name);
		
		bookName = new JTextField();
		bookName.setBounds(260, 85, 193, 23);
		bookName.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		bookName.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(bookName);
		
		JLabel book_id = new JLabel("Book ID :");
		book_id.setBounds(159, 123, 120, 20);
		book_id.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(book_id);
		
		bookID = new JTextField();
		bookID.setBounds(260, 125, 193, 23);
		bookID.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		bookID.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(bookID);
		
		generate_id = new JButton("Generate");
		generate_id.setBounds(455, 125, 100, 21);
		generate_id.setBorder(new LineBorder(new Color(0, 0, 0)));
		generate_id.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		generate_id.setFocusable(false);
		generate_id.addActionListener(this);
		generate_id.setBackground(Color.black);
		generate_id.setForeground(Color.white);
		mainPanel.add(generate_id);
		
		JLabel book_publisher = new JLabel("Publisher :");
		book_publisher.setBounds(145, 163, 120, 20);
		book_publisher.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(book_publisher);
		
		bookPublisher = new JTextField();
		bookPublisher.setBounds(260, 165, 193, 23);
		bookPublisher.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		bookPublisher.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(bookPublisher);
		
		JLabel book_edition = new JLabel("Book Edition :");
		book_edition.setBounds(112, 203, 190, 20);
		book_edition.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(book_edition);
		
		String[] ed_no = {"1", "2", "3", "4", "5", "6"};
		comboBox = new JComboBox(ed_no);
		comboBox.setBounds(260, 203, 193, 20);
		comboBox.setFont(new Font("Cosmic sans", Font.PLAIN, 13));
		mainPanel.add(comboBox);
		
		JLabel book_mrp = new JLabel("M . R . P :");
		book_mrp.setBounds(127, 243, 190, 20);
		book_mrp.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(book_mrp);
		
		bookMRP = new JTextField();
		bookMRP.setBounds(260, 241, 193, 23);
		bookMRP.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		bookMRP.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(bookMRP);
		
		back = new JButton("Back");
		back.setBounds(160, 300, 100, 30);
		back.setBorder(new LineBorder(new Color(0, 0, 0)));
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setFocusable(false);
		back.addActionListener(this);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		mainPanel.add(back);
		
		add = new JButton("Add");
		add.setBounds(290, 300, 100, 30);
		add.setBorder(new LineBorder(new Color(0, 0, 0)));
		add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add.setFocusable(false);
		add.addActionListener(this);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		mainPanel.add(add);
		
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(218,165,32), 3), "Add Book",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("MV BOLI", Font.BOLD, 25), new Color(255, 0, 0)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == generate_id) {
			Random rd = new Random();
			bookID.setText("" + rd.nextInt(10000));
		}
		
		try {
			
			Conn con = new Conn();
			
			if(e.getSource() == back) {
				this.setVisible(false);
				new Home().setVisible(true);
			}
			
			if(e.getSource() == add) {
				String sql = "insert into book(bookName, bookID, bookPublisher, bookEdition, bookPrice) values(?, ?, ?, ?, ?)";
				PreparedStatement st = con.conn.prepareStatement(sql);
				
				st.setString(1,  bookName.getText());
				st.setString(2,  bookID.getText());
				st.setString(3,  bookPublisher.getText());
				st.setString(4,  (String) comboBox.getSelectedItem());
				st.setString(5,  bookMRP.getText());
				
				int temp = st.executeUpdate();
				if(temp > 0) {
					JOptionPane.showMessageDialog(null, "Book Added In Your Library", "Success", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
					new Home().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "There Was Some Error", "Error", JOptionPane.ERROR_MESSAGE);
				}
				st.close();
			}
			con.conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new AddBooks().setVisible(true);
	}
}
