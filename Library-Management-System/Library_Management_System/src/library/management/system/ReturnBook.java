package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;

public class ReturnBook extends JFrame implements ActionListener{

	private JPanel mainPanel;
    JDateChooser chooseReturnDate;
    private JTextField book_id, book_name, book_publisher, book_edition, book_price, student_id, student_name, student_father_name, student_course, student_study_year,  student_semester, date_of_issue;
    private JButton bookSearch, studentSearch, returnBook,back;
	public ReturnBook() {
		
		super("Library Management System");
		ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
		this.setIconImage(appicon.getImage());
		this.setBounds(240, 100, 800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		this.setContentPane(mainPanel);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(null);
		
		JLabel studentId = new JLabel("Student ID");
		studentId.setForeground(new Color(47, 79, 79));
		studentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentId.setBounds(47, 63, 100, 23);
		mainPanel.add(studentId);

		JLabel studentName = new JLabel("Student Name");
		studentName.setForeground(new Color(47, 79, 79));
		studentName.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentName.setBounds(47, 103, 100, 23);
		mainPanel.add(studentName);

		JLabel studentFatherName = new JLabel("Father's Name");
		studentFatherName.setForeground(new Color(47, 79, 79));
		studentFatherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentFatherName.setBounds(47, 147, 140, 23);
		mainPanel.add(studentFatherName);

		JLabel studentCourse = new JLabel("Course");
		studentCourse.setForeground(new Color(47, 79, 79));
		studentCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentCourse.setBounds(47, 187, 100, 23);
		mainPanel.add(studentCourse);

		JLabel studentStudyYear = new JLabel("Year");
		studentStudyYear.setForeground(new Color(47, 79, 79));
		studentStudyYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentStudyYear.setBounds(47, 233, 100, 23);
		mainPanel.add(studentStudyYear);

		JLabel studentSemester = new JLabel("Semester");
		studentSemester.setForeground(new Color(47, 79, 79));
		studentSemester.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentSemester.setBounds(47, 284, 100, 23);
		mainPanel.add(studentSemester);

		student_id = new JTextField();
		student_id.setForeground(new Color(47, 79, 79));
		student_id.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		student_id.setBounds(171, 66, 86, 20);
		student_id.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(student_id);

		studentSearch = new JButton("Search");
		studentSearch.addActionListener(this);
		studentSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		studentSearch.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		studentSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		studentSearch.setBounds(267, 59, 100, 30);
		studentSearch.setBackground(Color.BLACK);
		studentSearch.setForeground(Color.WHITE);
		studentSearch.setFocusable(false);
	    mainPanel.add(studentSearch);

		student_name = new JTextField();
		student_name.setForeground(new Color(47, 79, 79));
		student_name.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		student_name.setEditable(false);
		student_name.setBounds(171, 106, 208, 20);
		mainPanel.add(student_name);

		student_father_name = new JTextField();
		student_father_name.setForeground(new Color(47, 79, 79));
		student_father_name.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		student_father_name.setEditable(false);
		student_father_name.setBounds(171, 150, 208, 20);
		mainPanel.add(student_father_name);

		student_course = new JTextField();
		student_course.setForeground(new Color(47, 79, 79));
		student_course.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		student_course.setEditable(false);
		student_course.setBounds(171, 190, 208, 20);
		mainPanel.add(student_course);

		student_study_year = new JTextField();
		student_study_year.setForeground(new Color(47, 79, 79));
		student_study_year.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		student_study_year.setEditable(false);
		student_study_year.setBounds(171, 236, 208, 20);
		mainPanel.add(student_study_year);

		student_semester = new JTextField();
		student_semester.setForeground(new Color(47, 79, 79));
		student_semester.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		student_semester.setEditable(false);
		student_semester.setBounds(171, 286, 208, 20);
		mainPanel.add(student_semester);

		JPanel studentPanel = new JPanel();
		studentPanel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180), 2, true), "Student Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 149, 237)));
		studentPanel.setForeground(new Color(0, 100, 0));
		studentPanel.setBounds(10, 38, 398, 352);
		studentPanel.setBackground(Color.WHITE);
	    mainPanel.add(studentPanel);
	        
		JLabel bookID = new JLabel("Book ID");
		bookID.setFont(new Font("Tahoma", Font.BOLD, 14));
		bookID.setForeground(new Color(47, 79, 79));
		bookID.setBounds(444, 63, 100, 23);
		mainPanel.add(bookID);

		JLabel bookName = new JLabel("Book Name");
		bookName.setForeground(new Color(47, 79, 79));
		bookName.setFont(new Font("Tahoma", Font.BOLD, 14));
		bookName.setBounds(444, 103, 100, 23);
		mainPanel.add(bookName);

		JLabel publisher = new JLabel("Publisher");
		publisher.setForeground(new Color(47, 79, 79));
		publisher.setFont(new Font("Tahoma", Font.BOLD, 14));
		publisher.setBounds(444, 147, 100, 23);
		mainPanel.add(publisher);

		JLabel edition = new JLabel("Edition");
		edition.setForeground(new Color(47, 79, 79));
		edition.setFont(new Font("Tahoma", Font.BOLD, 14));
		edition.setBounds(444, 185, 100, 23);
		mainPanel.add(edition);

		JLabel price = new JLabel("Price");
		price.setForeground(new Color(47, 79, 79));
		price.setFont(new Font("Tahoma", Font.BOLD, 14));
		price.setBounds(444, 233, 100, 23);
		mainPanel.add(price);

		JLabel dateOfIssue = new JLabel("Date Of Issue");
		dateOfIssue.setForeground(new Color(47, 79, 79));
		dateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateOfIssue.setBounds(444, 281, 100, 23);
		mainPanel.add(dateOfIssue);
		
		book_id = new JTextField();
		book_id.setForeground(new Color(47, 79, 79));
		book_id.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		book_id.setBounds(543, 66, 86, 20);
		book_id.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
		mainPanel.add(book_id);
		
		bookSearch = new JButton("Search");
		bookSearch.addActionListener(this);
		bookSearch.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		bookSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bookSearch.setBackground(Color.BLACK);
		bookSearch.setForeground(Color.WHITE);
		bookSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		bookSearch.setFocusable(false);
		bookSearch.setBounds(652, 59, 100, 30);
		mainPanel.add(bookSearch);

		book_name = new JTextField();
		book_name.setEditable(false);
		book_name.setForeground(new Color(47, 79, 79));
		book_name.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		book_name.setBounds(543, 106, 208, 20);
		mainPanel.add(book_name);
		
		book_publisher = new JTextField();
		book_publisher.setEditable(false);
		book_publisher.setForeground(new Color(47, 79, 79));
		book_publisher.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		book_publisher.setBounds(543, 150, 208, 20);
		mainPanel.add(book_publisher);

		book_edition = new JTextField();
		book_edition.setEditable(false);
		book_edition.setForeground(new Color(47, 79, 79));
		book_edition.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		book_edition.setBounds(543, 188, 208, 20);
		mainPanel.add(book_edition);

		book_price = new JTextField();
		book_price.setEditable(false);
		book_price.setForeground(new Color(47, 79, 79));
		book_price.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		book_price.setBounds(543, 236, 208, 20);
		mainPanel.add(book_price);

		date_of_issue = new JTextField();
		date_of_issue.setEditable(false);
		date_of_issue.setForeground(new Color(47, 79, 79));
		date_of_issue.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		date_of_issue.setBounds(543, 284, 208, 20);
		mainPanel.add(date_of_issue);
		
		JPanel bookPanel = new JPanel();
		bookPanel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Return Book",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
		bookPanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		bookPanel.setBounds(420, 38, 355, 278);
		bookPanel.setBackground(Color.WHITE);
	    mainPanel.add(bookPanel);
	        
		JLabel dateOfReturn = new JLabel(" Date of Return :");
		dateOfReturn.setForeground(new Color(105, 105, 105));
		dateOfReturn.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		dateOfReturn.setBounds(444, 340, 145, 26);
		mainPanel.add(dateOfReturn);

		chooseReturnDate = new JDateChooser();
		chooseReturnDate.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		chooseReturnDate.setForeground(new Color(105, 105, 105));
		chooseReturnDate.setBounds(570, 337, 200, 29);
		mainPanel.add(chooseReturnDate);

		returnBook = new JButton("Return");
		returnBook.addActionListener(this);
		returnBook.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		returnBook.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		returnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		returnBook.setBounds(640, 377, 118, 33);
		returnBook.setFocusable(false);
		returnBook.setBackground(Color.BLACK);
		returnBook.setForeground(Color.WHITE);
	    mainPanel.add(returnBook);

	    back = new JButton("Back");
	    back.addActionListener(this);
	    back.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	    back.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	    back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    back.setBounds(520, 377, 100, 33);
	    back.setFocusable(false);
	    back.setBackground(Color.BLACK);
	    back.setForeground(Color.WHITE);
	    mainPanel.add(back);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			this.setVisible(false);
			new Home().setVisible(true);
		}
		
		if(e.getSource() == studentSearch) {
			try {
				Conn con = new Conn();
				
				String sql = "select * from student where student_id = ?";
				PreparedStatement s = con.conn.prepareStatement(sql);
				s.setString(1,  student_id.getText());
				ResultSet rs = s.executeQuery();
				
				while(rs.next()) {
					student_name.setText(rs.getString("student_name"));
					student_name.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
					student_father_name.setText(rs.getString("stud_father_name"));
					student_father_name.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
					student_course.setText(rs.getString("course_name"));
					student_course.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
					student_study_year.setText(rs.getString("year"));
					student_study_year.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
					student_semester.setText(rs.getString("semester"));
					student_semester.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
				}
				
				s.close();
				con.conn.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		if(e.getSource() == bookSearch) {
			try {
				Conn con = new Conn();
				
				String sql = "select * from book where bookID = ?";
				PreparedStatement s = con.conn.prepareStatement(sql);
				s.setString(1,  book_id.getText());
				ResultSet rs = s.executeQuery();
				
				while(rs.next()) {
					book_name.setText(rs.getString("bookName"));
					book_name.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
					book_publisher.setText(rs.getString("bookPublisher"));
					book_publisher.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
					book_edition.setText(rs.getString("bookEdition"));
					book_edition.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
					book_price.setText(rs.getString("bookPrice"));
					book_price.setBorder(new LineBorder(new Color(173, 216, 230), 1, true));
				}
				String sql1 = "select * from issuedBooks where bookID = ?";
				PreparedStatement st = con.conn.prepareStatement(sql1);
				st.setString(1,  book_id.getText());
				ResultSet r = st.executeQuery();
				while(r.next()) {
					date_of_issue.setText(r.getString("dateOfIssue"));
				}
				
				st.close();
				s.close();
				con.conn.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		if(e.getSource() == returnBook) {
			try {
				Conn con = new Conn();
				
				String sql = "insert into returnBook values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement st = con.conn.prepareStatement(sql);
				
				st.setString(1, student_id.getText());
				st.setString(2, student_name.getText());
				st.setString(3, student_father_name.getText());
				st.setString(4, student_course.getText());
				st.setString(5, student_study_year.getText());
				st.setString(6, student_semester.getText());
				st.setString(7, book_name.getText());
				st.setString(8, book_id.getText());
				st.setString(9, book_publisher.getText());
				st.setString(10, book_edition.getText());
				st.setString(11, book_price.getText());
				st.setString(12, date_of_issue.getText());
				st.setString(13, ((JTextField) chooseReturnDate.getDateEditor().getUiComponent()).getText());
				
				int res = st.executeUpdate();
				if(res > 0) {
					JOptionPane.showMessageDialog(null, "Book Returned Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
					new Home().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Error In Returning The Book", "Error", JOptionPane.ERROR_MESSAGE);
				}
				String sql1 = "delete from issuedBooks where bookID = ?";
				PreparedStatement s = con.conn.prepareStatement(sql1);
				s.setString(1, book_id.getText());
				
				int r = s.executeUpdate();
				if(r > 0) {
					JOptionPane.showMessageDialog(null, "Book Removed From Issue Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Error In Removing The Book", "Error", JOptionPane.ERROR_MESSAGE);
				}
				st.close();
				con.conn.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ReturnBook().setVisible(true);
		}
}
