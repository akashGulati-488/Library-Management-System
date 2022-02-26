package library.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener{
	
		private JPanel mainPanel;
		private JButton lgn_btn, sgnup_btn, frgt_passwd_btn;
		private JTextField text_field;
		private JPasswordField password_field;
		
		public LoginPage() {
			
			super("Library Management System");
			ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
			this.setIconImage(appicon.getImage());
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(400, 175, 600, 400);
			
			mainPanel = new JPanel();
			mainPanel.setLayout(null);
			mainPanel.setBackground(new Color(173, 216, 230));
			this.setContentPane(mainPanel);
			
//			JLabel symbolLabel = new JLabel();
//			symbolLabel.setText("Welcome To ATM Simulator");
//			symbolLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
//			symbolLabel.setBounds(170, 49, 270, 24);
//			symbolLabel.setForeground(Color.MAGENTA);
//			mainPanel.add(symbolLabel);
			
			JLabel label1 = new JLabel();
			label1.setText("Username : ");
			label1.setBounds(120, 89, 95, 24);
			label1.setFont(new Font("MV BOLI", Font.BOLD, 15));
			mainPanel.add(label1);
			
			JLabel label2 = new JLabel();
			label2.setText("Password : ");
			label2.setBounds(120, 128, 95, 24);
			label2.setFont(new Font("MV BOLI", Font.BOLD, 15));
			mainPanel.add(label2);
			
			text_field = new JTextField();
			text_field.setBounds(236, 90, 180, 24);
			text_field.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
			text_field.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
			mainPanel.add(text_field);
			
			password_field = new JPasswordField();
			password_field.setBounds(236, 128, 180, 24);
			password_field.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
			mainPanel.add(password_field);
			
			lgn_btn = new JButton("Login");
			lgn_btn.setBackground(new Color(255, 253, 208));
			lgn_btn.setForeground(new Color(50,205,50));
			lgn_btn.setBorder(new LineBorder(new Color(173, 216, 230)));
			lgn_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lgn_btn.setBounds(160, 181, 113, 30);
			lgn_btn.setFocusable(false);
			lgn_btn.addActionListener(this);
			mainPanel.add(lgn_btn);
			
			sgnup_btn = new JButton("Sign Up");
			sgnup_btn.setBackground(new Color(255, 253, 208));
			sgnup_btn.setForeground(new Color(255, 165, 0));
			sgnup_btn.setBorder(new LineBorder(new Color(173, 216, 230)));
			sgnup_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sgnup_btn.setBounds(280, 181, 113, 30);
			sgnup_btn.setFocusable(false);
			sgnup_btn.addActionListener(this);
			mainPanel.add(sgnup_btn);

			frgt_passwd_btn = new JButton("Forgot Password");
			frgt_passwd_btn.setBackground(new Color(255, 253, 208));
			frgt_passwd_btn.setForeground(new Color(255, 0, 0));
			frgt_passwd_btn.setBorder(new LineBorder(new Color(173, 216, 230)));
			frgt_passwd_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			frgt_passwd_btn.setBounds(210, 215, 125, 30);
			frgt_passwd_btn.setFocusable(false);
			frgt_passwd_btn.addActionListener(this);
			mainPanel.add(frgt_passwd_btn);
			
			JLabel label3 = new JLabel("Trouble While Login?");
			label3.setBounds(80, 217, 150, 24);
			label3.setFont(new Font("Tahoma", Font.BOLD, 12));
			label3.setForeground(new Color(139, 0, 0));
			mainPanel.add(label3);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == lgn_btn) {
				try {
					Conn con = new Conn();
					String sql = "select * from account where username = ? and password = ?";
					PreparedStatement st = con.conn.prepareStatement(sql);
					
					st.setString(1, text_field.getText());
					st.setString(2, password_field.getText());
					
					ResultSet res_set = st.executeQuery();
					if(res_set.next()) {
						this.setVisible(false);
						new Load().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Invalid Login!!", "Please Login Again", JOptionPane.ERROR_MESSAGE);
					}
					st.close();
					con.conn.close();
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
			
			}
			
			if(e.getSource() == sgnup_btn) {
				
				this.setVisible(false);
				new SignUp().setVisible(true);
				
			}
			if(e.getSource() == frgt_passwd_btn) {
				this.setVisible(false);
				new RecoverPassword().setVisible(true);
			}
		}
		public static void main(String[] args) {
			new LoginPage();
		}
}