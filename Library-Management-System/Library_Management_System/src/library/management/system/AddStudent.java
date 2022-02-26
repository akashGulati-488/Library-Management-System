package library.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener {

	private JPanel mainPanel;
	private JComboBox course_comboBox, year_comboBox, sem_comboBox;
	private JTextField studentName, studID, fatherName, bookMRP;
	private JButton back, add, generate_id;
	
	public AddStudent() {
		
		super("Library Management System");
		ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
		this.setIconImage(appicon.getImage());
		this.setBounds(400, 175, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		this.setContentPane(mainPanel);
		
		JLabel stud_name = new JLabel("Student Name :");
		stud_name.setBounds(121, 63, 136, 20);
		stud_name.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(stud_name);
		
		studentName = new JTextField();
		studentName.setBounds(260, 65, 193, 23);
		studentName.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		studentName.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(studentName);
		
		JLabel stud_id = new JLabel("Student ID :");
		stud_id.setBounds(142, 103, 120, 20);
		stud_id.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(stud_id);
		
		studID = new JTextField();
		studID.setBounds(260, 105, 193, 23);
		studID.setFont(new Font("Cosmic Sans", Font.PLAIN, 15));
		studID.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(studID);
		
		generate_id = new JButton("Generate");
		generate_id.setBounds(455, 105, 100, 21);
		generate_id.setBorder(new LineBorder(new Color(0, 0, 0)));
		generate_id.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		generate_id.setFocusable(false);
		generate_id.addActionListener(this);
		generate_id.setBackground(Color.black);
		generate_id.setForeground(Color.white);
		mainPanel.add(generate_id);
		
		JLabel fath_name = new JLabel("Father's Name :");
		fath_name.setBounds(113, 143, 138, 20);
		fath_name.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(fath_name);
		
		fatherName = new JTextField();
		fatherName.setBounds(260, 145, 193, 23);
		fatherName.setFont(new Font("Cosmic Sans", Font.PLAIN,15));
		fatherName.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(fatherName);
		
		JLabel course = new JLabel("Course :");
		course.setBounds(168, 183, 190, 20);
		course.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(course);
		
		String[] courseNames = {"B.Com", "B.Tech", "B.E", "M.B.A", "B.C.A", "M.B.B.S"};
		course_comboBox = new JComboBox(courseNames);
		course_comboBox.setBounds(260, 183, 193, 20);
		course_comboBox.setFont(new Font("Cosmic sans", Font.PLAIN, 13));
		mainPanel.add(course_comboBox);
		
		JLabel year = new JLabel("Year  :");
		year.setBounds(174, 223, 190, 20);
		year.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(year);
		
		String[] study_year = {"First", "Second", "Third", "Fourth"};
		year_comboBox = new JComboBox(study_year);
		year_comboBox.setBounds(260, 223, 193, 20);
		year_comboBox.setFont(new Font("Cosmic sans", Font.PLAIN, 13));
		mainPanel.add(year_comboBox);
		
		JLabel semester = new JLabel("Semester  :");
		semester.setBounds(134, 263, 190, 20);
		semester.setFont(new Font("MV BOLI", Font.BOLD,15));
		mainPanel.add(semester);
		
		String[] sem_no = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
		sem_comboBox = new JComboBox(sem_no);
		sem_comboBox.setBounds(260, 263, 193, 20);
		sem_comboBox.setFont(new Font("Cosmic sans", Font.PLAIN, 13));
		mainPanel.add(sem_comboBox);
		
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
		
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(218,165,32), 3, true), "Add Student",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("MV BOLI", Font.BOLD, 25), new Color(255, 0, 0)));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			this.setVisible(false);
			new Home().setVisible(true);
		}
		
		if(e.getSource() == add) {
			try {
				Conn con = new Conn();
				String sql = "insert into student(student_id, student_name, stud_father_name, course_name, year, semester) values (?, ?, ?, ?, ?, ?)";
				PreparedStatement st = con.conn.prepareStatement(sql);
				
				st.setString(1,  studID.getText());
				st.setString(2,  studentName.getText());
				st.setString(3, fatherName.getText());
				st.setString(4, (String) course_comboBox.getSelectedItem());
				st.setString(5, (String) year_comboBox.getSelectedItem());
				st.setString(6, (String) sem_comboBox.getSelectedItem());
				
				int temp = st.executeUpdate();
				if(temp > 0) {
					JOptionPane.showMessageDialog(null, "Student Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
					new Home().setVisible(true);
				}else {
				JOptionPane.showMessageDialog(null, "Failed To Add Student Successfully", "Error", JOptionPane.ERROR_MESSAGE);
				}
				st.close();
				con.conn.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		if(e.getSource() == generate_id) {
			Random rd = new Random();
			studID.setText("" + rd.nextInt(10000));
		}
		
	}
	
	public static void main(String[] args) {
		new AddStudent().setVisible(true);
	}

}
