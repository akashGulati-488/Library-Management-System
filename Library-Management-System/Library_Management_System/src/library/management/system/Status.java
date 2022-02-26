package library.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Status extends JFrame {
	
	private JPanel mainPanel, issuepanel, returnpanel;
    private JTable issuetable;
    private JTable returntable;
    private JScrollPane scrollPane;

    public Status() {
    	
    	super("Library Management System");
		ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
		this.setIconImage(appicon.getImage());
		this.setBounds(40, 50, 1200, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
		mainPanel = new JPanel();
		this.setContentPane(mainPanel);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 51, 1108, 217);
		mainPanel.add(scrollPane);
		
		issuetable = new JTable();
		issuetable.setBackground(new Color(224, 255, 255));
		issuetable.setForeground(new Color(128, 128, 0));
		issuetable.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		scrollPane.setViewportView(issuetable);
		
		issuepanel = new JPanel();
		issuepanel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issued Book Details",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
		issuepanel.setForeground(new Color(0, 128, 128));
		issuepanel.setBounds(26, 36, 1137, 240);
		issuepanel.setBackground(Color.WHITE);
	    mainPanel.add(issuepanel);
		
		issueBookDetails();
		
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
		mainPanel.add(back);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 316, 1117, 217);
		mainPanel.add(scrollPane_1);

		returntable = new JTable();
		returntable.setBackground(new Color(204, 255, 255));
		returntable.setForeground(new Color(153, 51, 0));
		returntable.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		scrollPane_1.setViewportView(returntable);

		returnpanel = new JPanel();
		returnpanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 204, 153), 2, true), "Return Book Details",
			TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 102, 51)));
		returnpanel.setBounds(22, 299, 1141, 240);
		returnpanel.setBackground(Color.WHITE);
		mainPanel.add(returnpanel);
	        
		returnBookDetails();
    }
    
    public void issueBookDetails() {
    	try {
                Conn con =  new Conn();
                String sql = "select * from issuedBooks";
                PreparedStatement st = con.conn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

                issuetable.setModel(DbUtils.resultSetToTableModel(rs));
                st.close();
                con.conn.close();
    	} 
    	catch (Exception e) {
    			e.printStackTrace();
    	}
    }
    
    public void returnBookDetails() {
        try {
            Conn con = new Conn();
            String sql = "select * from returnBook";
            PreparedStatement st = con.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            returntable.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
            con.conn.close();
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    	new Status().setVisible(true);
    }
}
