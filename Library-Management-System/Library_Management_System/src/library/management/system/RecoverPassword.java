package library.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class RecoverPassword extends JFrame implements ActionListener{
	
	private JPanel mainPanel;
	private JTextField username, fullname, sec_answer;
	private JTextField pass_field;
	private JTextField sec_ques;
	private JButton back, find, recover;
	
	public RecoverPassword() {
		
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
		
		find = new JButton("Find");
		find.setBounds(460, 85, 100, 22);
		find.setBackground(Color.BLACK);
		find.setForeground(Color.WHITE);
		find.setBorder(new LineBorder(new Color(0, 0, 0)));
		find.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		find.setFocusable(false);
		find.addActionListener(this);
		mainPanel.add(find);
		
		JLabel full_name = new JLabel("Full Name :");
		full_name.setBounds(131, 123, 120, 20);
		full_name.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(full_name);
		
		fullname = new JTextField();
		fullname.setBounds(260, 125, 193, 23);
		fullname.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		fullname.setEditable(false);
		mainPanel.add(fullname);
		
		JLabel scrtyques = new JLabel("Security Question :");
		scrtyques.setBounds(65, 163, 190, 20);
		scrtyques.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(scrtyques);
		
		sec_ques = new JTextField();
		sec_ques.setBounds(260, 165, 193, 20);
		sec_ques.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		sec_ques.setEditable(false);
		mainPanel.add(sec_ques);
		
		JLabel ans = new JLabel("Answer :");
		ans.setBounds(139, 203, 120, 20);
		ans.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(ans);
		
		sec_answer = new JTextField();
		sec_answer.setBounds(260, 205, 193, 20);
		sec_answer.setEditable(false);
		sec_answer.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		mainPanel.add(sec_answer);
		
		recover = new JButton("Recover");
		recover.setBounds(460, 205, 100, 20);
		recover.setBackground(Color.BLACK);
		recover.setForeground(Color.WHITE);
		recover.setBorder(new LineBorder(new Color(0, 0, 0)));
		recover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		recover.setFocusable(false);
		recover.addActionListener(this);
		mainPanel.add(recover);
		
		JLabel pswd = new JLabel("Password :");
		pswd.setBounds(124, 245, 120, 20);
		pswd.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(pswd);
		
		pass_field = new JTextField();
		pass_field.setBounds(260, 245, 193, 23);
		pass_field.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(pass_field);
		
		back = new JButton("Back");
		back.setBounds(250, 300, 100, 30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBorder(new LineBorder(new Color(0, 0, 0)));
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setFocusable(false);
		back.addActionListener(this);
		mainPanel.add(back);
		
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(218,165,32), 3), "Recover Password",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("MV BOLI", Font.BOLD, 25), new Color(255, 0, 0)));
	}
	
	public static void main(String[] args) {
		new RecoverPassword().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Conn con = new Conn();
		
			if(e.getSource() == find) {
				String sql = "select * from account where username = ?";
				PreparedStatement s = con.conn.prepareStatement(sql);
			
				s.setString(1,  username.getText());
			
				ResultSet rs = s.executeQuery();
				
				if(rs.next()) {
					fullname.setText(rs.getString("fullname"));
					fullname.setForeground(Color.BLUE);
					fullname.setBorder(new LineBorder(new Color(50, 205, 50), 1, true));
					sec_ques.setText("sec_ques");
					sec_ques.setForeground(Color.BLUE);
					sec_ques.setBorder(new LineBorder(new Color(50, 205, 50), 1, true));
					sec_answer.setEditable(true);
					sec_answer.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Username", "Please Enter Correct Username", JOptionPane.ERROR_MESSAGE);
				}
//				JOptionPane.showMessageDialog(null, "Correct Username", "Please Enter Correct Username", JOptionPane.INFORMATION_MESSAGE);
				s.close();
			}
			
			if(e.getSource() == recover) {
				String sql = "select * from account where sec_ans = ?";
				PreparedStatement s = con.conn.prepareStatement(sql);
				
				s.setString(1, sec_answer.getText());
				
				ResultSet rs = s.executeQuery();
				
				if(rs.next()) {
					pass_field.setText(rs.getString("password"));
					pass_field.setForeground(Color.black);
					pass_field.setBorder(new LineBorder(new Color(50, 205, 50), 1, true));
					pass_field.setEditable(false);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Answer", "Please Enter Correct Answer", JOptionPane.ERROR_MESSAGE);
				}
				s.close();
			}
			
			if(e.getSource() == back) {
				this.setVisible(false);
				new LoginPage().setVisible(true);
			}
			con.conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
