import javax.swing.*;  
import javax.swing.table.*;
import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;  
public class SearchPatient extends JFrame implements ActionListener {  
    //Initializing Components  
        JLabel l1, lb, lb1, lb2, lb3, lb4, lb5, lb6;  
        JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;  
        JButton btn, b1, b2, b3, b4, b5, b6, b7;
        JFrame frame1;
        JTable table = new JTable();
        String[] columnNames = {"Patient name", "Patient Diagnosis", "Patient Problem"};
        String[] columnNames1 = {"Patient ID","Patient name", "Patient Diagnosis", "Patient Problem"};
            //Creating Constructor for initializing JFrame components  
            public SearchPatient(String s2,String s3) {  
            //Providing Title 
            super("Fetching Patient Information");  
            lb5 = new JLabel("Patient Name:");  
            lb5.setBounds(20, 20, 100, 20);  
            tf5 = new JTextField(50);  
            tf5.setBounds(130, 20, 200, 20);
            tf7 = new JTextField(s2);
            tf7.setBounds(350,20,100,20);
            tf8 = new JTextField(s3);
            tf8.setBounds(470,20,100,20);
            tf9 = new JTextField(50);
            tf9.setBounds(600,20,100,20);
            btn = new JButton("Submit");  
            btn.setBounds(240, 50, 100, 20);  
            btn.addActionListener(this);  
            lb = new JLabel("Fetching Doctor Information From Database");  
            lb.setBounds(30, 80, 600, 30);  
            lb.setForeground(Color.red);  
            lb.setFont(new Font("Serif", Font.BOLD, 20));  
            setVisible(true);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            setSize(1500, 1500);  
     	    
            
            lb1 = new JLabel("Patient id:");  
            lb1.setBounds(20, 120, 150, 20);  
            tf1 = new JTextField(50);  
            tf1.setBounds(230, 120, 200, 20); 
             
            lb2 = new JLabel("Patient Name:");  
            lb2.setBounds(20, 150, 150, 20);  
            tf2 = new JTextField(100);  
            tf2.setBounds(230, 150, 200, 20);  
            
            lb3 = new JLabel("Patient Diagnosis:");  
            lb3.setBounds(20, 180, 200, 20);  
            tf3 = new JTextField(50);  
            tf3.setBounds(230, 180, 200, 20);  
            
            lb4 = new JLabel("Patient Address :");  
            lb4.setBounds(20, 210, 150, 20);  
            tf4 = new JTextField(50);  
            tf4.setBounds(230, 210, 100, 20);
            
            lb6 = new JLabel("Patient Problem :");  
            lb6.setBounds(20, 240, 150, 20);  
            tf6 = new JTextField(50);  
            tf6.setBounds(230, 240, 100, 20);
            
            b1=new JButton("Back");
            b1.setBounds(50,310,100,20);
            
            b2=new JButton("Register Patient");
            b2.setBounds(170,310,150,20);
            
            b3=new JButton("Delete ");
            b3.setBounds(340,310,170,20);
            
            b4=new JButton("MedicalRecord");
            b4.setBounds(520,310,150,20);
            
            b5=new JButton("Add MedicalRecord");
            b5.setBounds(690,310,170,20);
            
            b6=new JButton("Delete Person Medical Record");
            b6.setBounds(170,380,270,20);
            
            b7=new JButton("View All Patient");
            b7.setBounds(20,380,150,20);
            
            l1=new JLabel("");
            l1.setBounds(860,310,300,20);
            setLayout(null); 
            
            add(lb5);  
            add(tf5); 
            add(tf7);
            add(tf8);
            add(tf8);
            add(tf9);
            add(btn);  
            add(lb);  
            add(lb1);  
            add(tf1);  
            add(lb2);  
            add(tf2);  
            add(lb3);  
            add(tf3);  
            add(lb4);  
            add(tf4);
            add(lb6);  
            add(tf6);
            add(b1);
            add(b2);
            add(b3);
            add(b4);
            add(b5);
            add(l1);
            add(b6);
            add(b7);
            
            btn.addActionListener(this);
            b1.addActionListener(this); 
            b2.addActionListener(this); 
            b3.addActionListener(this); 
            b4.addActionListener(this);
            b5.addActionListener(this);
            b6.addActionListener(this);
            b7.addActionListener(this);
            //Set TextField Editable False  
            
            tf1.setEditable(false);  
            tf2.setEditable(false);  
            tf3.setEditable(false);  
            tf4.setEditable(false);
            tf7.setEditable(false);
            tf8.setEditable(false);
            tf9.setEditable(false);
        }
public void showTableData() {
        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String name = (String) tf9.getText();
        String pname = "";
        String pd = "";
        String problem = "";
        try {
        int i = 0;
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123");
            PreparedStatement pst = con.prepareStatement("select * from medicalrecord where pname='" + name + "' limit 10");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                pname = rs.getString("pname");
                pd = rs.getString("pdignosis");
                problem = rs.getString("problem");
                model.addRow(new Object[]{pname, pd,problem});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
} 

public void showTableData1() {
        frame1 = new JFrame("Patient Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames1);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String name = (String) tf8.getText();
        int pid = new Integer(name);
        String pname = "";
        String pd = "";
        String paddress = "";
        try {
        int i = 0;
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123");
            PreparedStatement pst = con.prepareStatement("select * from patient where pid='" + pid + "'");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
            	pid = rs.getInt(1);
                pname = rs.getString(2);
                pd = rs.getString(3);
                paddress = rs.getString(4);
                model.addRow(new Object[]{pid,pname, pd,paddress});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
} 




        public void actionPerformed(ActionEvent ex) {  
            //Create DataBase Coonection and Fetching Records  
            try {  
            if(ex.getSource() == btn)
            { 
            int a=0;
            String str = tf5.getText();
            String str2 = tf8.getText();
            int str3 = new Integer(str2); 
            Class.forName("org.postgresql.Driver");  
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123"); 
                 PreparedStatement st = con.prepareStatement("select * from patient where pid=? and pname=?");  
                st.setInt(1, str3);
                st.setString(2, str);
                ResultSet rs = st.executeQuery();  
                if (rs.next()) {  
                    a++;
                    String s = rs.getString(1);  
                    String s1 = rs.getString(2);  
                    String s2 = rs.getString(3);  
                    String s3 = rs.getString(4);
                    //Sets Records in TextFields.  
                    tf1.setText(s);  
                    tf2.setText(s1);  
                    tf3.setText(s2);  
                    tf4.setText(s3);
                    tf9.setText(s1);
                    
                }
                if(a!=0)
                {
                l1.setText("Searched Record");
                }
                else
                {   tf1.setText("");  
                    tf2.setText("");  
                    tf3.setText("");  
                    tf4.setText("");
                l1.setText("Record Not Found Try Again...");
                }
                }
               else if(ex.getSource() == b1)
               {
               String s1 = tf7.getText();
               String s2 = tf8.getText();
               new SearchDoctor(s1,s2);
               }
               else if(ex.getSource() == b4)
               {
               showTableData();
               }
               else if(ex.getSource() == b5)
               {
               int a=0;
            String str1 = tf2.getText();
            String str2 = tf3.getText();
            String str3 = tf6.getText();
            Class.forName("org.postgresql.Driver");  
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123"); 
                 PreparedStatement st = con.prepareStatement("insert into medicalrecord values(?,?,?)");  
                st.setString(1, str1);
                st.setString(2, str2);
                a++;
                st.setString(3, str3);
                ResultSet rs = st.executeQuery();  
                
                if(a!=0)
                {
                l1.setText("Insert Medical  Record");
                }
               }
               
               else if(ex.getSource() == b6)
               {
               int a=0;
                String str1 = tf9.getText();
                Class.forName("org.postgresql.Driver");  
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123"); 
                PreparedStatement st = con.prepareStatement("delete from medicalrecord where pname=?");  
                st.setString(1, str1);
                a++;
                ResultSet rs = st.executeQuery();  
                
                if(a!=0)
                {
                l1.setText("Deleted Medical  Record");
                }
               }
               else if(ex.getSource() == b7)
               {
               showTableData1();
               }
               else if(ex.getSource() == b2)
               {
               String s2=tf7.getText();
               String s3=tf8.getText();
               new RegiPatient(s2,s3);
               }
               else if(ex.getSource() == b3)
               {
               String str = tf7.getText();
               String str1 = tf8.getText(); 
               int str2 = new Integer(str1); 
               Class.forName("org.postgresql.Driver");  
               Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123"); 
               PreparedStatement st = con.prepareStatement("delete from patient where pname=? and pid=?");  
               st.setString(1, str);  
               st.setInt(2, str2);  
               ResultSet rs1 = st.executeQuery();
               System.out.println("Record Deleted Successful");
               l1.setText("Deleted Patient record  Record");
                }
            } catch (Exception edsf) {
            System.out.println(edsf);
            }  
        }
   
    }  


