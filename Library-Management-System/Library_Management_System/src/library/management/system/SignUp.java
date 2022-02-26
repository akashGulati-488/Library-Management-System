package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

class SignUp extends JFrame implements ActionListener{
	
	private JPanel mainPanel;
	private JTextField username, fullname;
	private JTextField sec_ans;
	private JPasswordField pass_field;
	private JComboBox comboBox;
	private JButton create, back;
	
	public SignUp() {
		
		super("Library Management System");
		ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
		this.setIconImage(appicon.getImage());
		this.setBounds(400, 175, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		this.setContentPane(mainPanel);
		
		JLabel user_name = new JLabel("Username :");
		user_name.setBounds(140, 83, 120, 20);
		user_name.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(user_name);
		
		username = new JTextField();
		username.setBounds(260, 85, 193, 23);
		username.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		username.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(username);
		
		JLabel full_name = new JLabel("Full Name :");
		full_name.setBounds(130, 123, 120, 20);
		full_name.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(full_name);
		
		fullname = new JTextField();
		fullname.setBounds(260, 125, 193, 23);
		fullname.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		fullname.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(fullname);
		
		JLabel pswd = new JLabel("Password :");
		pswd.setBounds(130, 163, 120, 20);
		pswd.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(pswd);
		
		pass_field = new JPasswordField();
		pass_field.setBounds(260, 165, 193, 23);
		pass_field.addActionListener(this);
		pass_field.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(pass_field);
		
		JLabel scrtyques = new JLabel("Security Question :");
		scrtyques.setBounds(60, 203, 190, 20);
		scrtyques.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(scrtyques);
		
		String[] ques = {"Your Pet Name?", "Favourite Teacher's Name?", "Favourite Childhood Superhero?", "Favourite Color?"};
		comboBox = new JComboBox(ques);
		comboBox.setBounds(260, 203, 193, 20);
		comboBox.setFont(new Font("Cosmic sans", Font.PLAIN, 13));
		mainPanel.add(comboBox);
		
		JLabel scrtyans = new JLabel("Security Answer :");
		scrtyans.setBounds(68, 243, 190, 20);
		scrtyans.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(scrtyans);
		
		sec_ans = new JTextField();
		sec_ans.setBounds(260, 241, 193, 23);
		sec_ans.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		sec_ans.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(sec_ans);
		
		back = new JButton("Back");
		back.setBounds(160, 300, 100, 30);
		back.setFocusable(false);
		back.addActionListener(this);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBorder(new LineBorder(new Color(0, 0, 0)));
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mainPanel.add(back);
		
		create = new JButton("Create");
		create.setBounds(290, 300, 100, 30);
		create.setFocusable(false);
		create.addActionListener(this);
		create.setBackground(Color.black);
		create.setForeground(Color.white);
		create.setBorder(new LineBorder(new Color(0, 0, 0)));
		create.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mainPanel.add(create);
		
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(218,165,32), 3), "Create Account",
			TitledBorder.CENTER, TitledBorder.TOP, new Font("MV BOLI", Font.BOLD, 25), new Color(255, 0, 0)));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == pass_field) {
			pass_field.setBorder(new LineBorder(Color.blue));
    	}
		
		if(e.getSource() == create) {
			String temp = pass_field.getText();
			
			if(temp.length() < 8) {
//				JLabel warning = new JLabel("Password length should be greater than or equal to 8");
//				warning.setBounds(300, 165, 400, 23);
//				warning.setForeground(Color.red);
//				mainPanel.add(warning);
				JOptionPane.showMessageDialog(null, "Password length should be greater than or equal to 8", "Try Again", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				try {
					
					Conn con = new Conn();
					String sql1 = "select * from account where username = ?";
					PreparedStatement st = con.conn.prepareStatement(sql1);
					st.setString(1, username.getText());
					ResultSet rs = st.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "This username already exist \n \t \t \t \t \t \t \t try new username", "Try Again", JOptionPane.INFORMATION_MESSAGE);
					}
					
					else {
				    String sql = "insert into account(username, fullname, password, sec_ques, sec_ans) values(?, ?, ?, ?, ?)";
					PreparedStatement s = con.conn.prepareStatement(sql);
			
					s.setString(1, username.getText());
					s.setString(2,  fullname.getText());
					s.setString(3, pass_field.getText());
					s.setString(4, (String) comboBox.getSelectedItem());
					s.setString(5, sec_ans.getText());
			
					int i = s.executeUpdate();
					if(i > 0) {
						JOptionPane.showMessageDialog(null, "Account Successfully Created", "Created", JOptionPane.INFORMATION_MESSAGE);
					}
			
					username.setText("");
					pass_field.setText("");
					fullname.setText("");
					sec_ans.setText("");
					s.close();
					}
					st.close();
					con.conn.close();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
	  if(e.getSource() == back) {
			this.setVisible(false);
			new LoginPage().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new SignUp().setVisible(true);
	}
	
}