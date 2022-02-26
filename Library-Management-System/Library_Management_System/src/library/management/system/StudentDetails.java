package library.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener{

    private JPanel mainPanel;
    private JTable table;
    private JTextField searchText;
    private JButton search, delete;
    private JScrollPane scrollPane;

    public StudentDetails() {
    	
    	super("Library Management System");
		ImageIcon appicon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/AppIcon.jpg"));
		this.setIconImage(appicon.getImage());
        this.setBounds(220, 100, 890, 475);
        
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(220, 220, 220));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainPanel);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 288);
        scrollPane.setBorder(new LineBorder(new Color(218,165,32), 3, true));
        mainPanel.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent arg0) {
            		int row = table.getSelectedRow();
            		searchText.setText(table.getModel().getValueAt(row, 1).toString());
            	}
        });
        table.setBackground(new Color(240, 248, 255));
        table.setForeground(new Color(50, 205, 50));
        table.setFont(new Font("Cosmic Sans", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        search = new JButton("Search");
        search.addActionListener(this);
        search.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/SearchIcon.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        search.setIcon(i3);
        search.setForeground(new Color(199, 21, 133));
        search.setFont(new Font("Cosmic Sans", Font.BOLD, 18));
		search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        search.setFocusable(false);
        search.setBounds(564, 89, 138, 33);
        mainPanel.add(search);

        delete = new JButton("Delete");
        delete.addActionListener(this);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/DeleteIcon.png"));
        Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        delete.setIcon(i6);
        delete.setForeground(new Color(199, 21, 133));
        delete.setFont(new Font("Cosmic Sans", Font.BOLD, 18));
        delete.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
		delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        delete.setBounds(712, 89, 138, 33);
        delete.setFocusable(false);
        mainPanel.add(delete);

        searchText = new JTextField();
        searchText.setBackground(new Color(255, 240, 245));
        searchText.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
        searchText.setForeground(new Color(47, 79, 79));
        searchText.setFont(new Font("Cosmic Sans", Font.BOLD, 17));
        searchText.setBounds(189, 89, 357, 33);
        mainPanel.add(searchText);

        JLabel back = new JLabel("Back");
        back.addMouseListener(new MouseAdapter() {
        		@Override
        		public void mouseClicked(MouseEvent e) {
        			setVisible(false);
        			Home home = new Home();
        			home.setVisible(true);
        		}
        });
        back.setForeground(Color.GRAY);
        back.setFont(new Font("Cosmic Sans", Font.BOLD, 18));
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/BackIcon.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        back.setIcon(i9);
        back.setBounds(97, 89, 72, 33);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(back);

        mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(95, 158, 160), 3, true), "Student Details",
    			TitledBorder.CENTER, TitledBorder.TOP, new Font("MV BOLI", Font.BOLD, 25), new Color(102, 205, 170)));
        studentDetails();
    	}
    
    public void studentDetails() {
        try {
            Conn con = new Conn();
            String sql = "select * from student";
            PreparedStatement st = con.conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
            con.conn.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    
    public void actionPerformed(ActionEvent ae){
    	try{
            
            Conn con = new Conn();
            if( ae.getSource() == search){
                String sql = "select * from student where student_name like ?";
                PreparedStatement st = con.conn.prepareStatement(sql);
                st.setString(1, "%" + searchText.getText() + "%");
                ResultSet rs = st.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();
            }
    
            if(ae.getSource() == delete){
                String sql = "delete from student where student_name = '" + searchText.getText() + "'";
                PreparedStatement st = con.conn.prepareStatement(sql);

                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {

                } else if (response == JOptionPane.YES_OPTION) {
                	int rs = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted !!");
                    String sql1 = "select * from student";
                    PreparedStatement s = con.conn.prepareStatement(sql1);
               
                    ResultSet r = s.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(r));
                } else if (response == JOptionPane.CLOSED_OPTION) {
			
                }
                st.close();
		
            }
            con.conn.close();
        }catch(Exception e){
            
        }
    }
    public static void main(String[] args) {
    	new StudentDetails().setVisible(true);
        }
}