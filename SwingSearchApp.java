import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;  
public class SwingSearchApp extends JFrame implements ActionListener {  
    //Initializing Components  
        JLabel l1,lb, lb1, lb2, lb3,lb4,lb5,lb6;  
        JTextField tf1, tf2, tf3, tf4,tf5,tf7,tf8;  
        JButton b4,btn,b1,b2,b3;  
        //Creating Constructor for initializing JFrame components  
        public SwingSearchApp(String s3,String s1) {  
            //Providing Title  
            super("Fetching Hospital Information");   
            lb5 = new JLabel("Enter Name:");  
            lb5.setBounds(20, 20, 100, 20);  
            tf5 = new JTextField(20);  
            tf5.setBounds(130, 20, 200, 20);
            tf7 = new JTextField(s3);
            tf7.setBounds(600, 20, 100, 20);
            tf8 = new JTextField(s1);
            tf8.setBounds(800,20,100,20);
            btn = new JButton("Submit");  
            btn.setBounds(350, 50, 100, 20);  
            btn.addActionListener(this);  
            lb = new JLabel("Fetching Hospital Information From Database");  
            lb.setBounds(30, 80, 600, 30);  
            lb.setForeground(Color.red);  
            lb.setFont(new Font("Serif", Font.BOLD, 20));  
            setVisible(true);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            setSize(1500, 1500);  
            
            lb1 = new JLabel("Hospital id:");  
            lb1.setBounds(20, 120, 150, 20);  
            tf1 = new JTextField(50);  
            tf1.setBounds(180, 120, 200, 20); 
             
            lb2 = new JLabel("Hospital Name:");  
            lb2.setBounds(20, 150, 150, 20);  
            tf2 = new JTextField(100);  
            tf2.setBounds(180, 150, 200, 20);  
            
            lb3 = new JLabel("Hospital Address:");  
            lb3.setBounds(20, 180, 150, 20);  
            tf3 = new JTextField(50);  
            tf3.setBounds(180, 180, 200, 20);  
            
            lb4 = new JLabel("Hospital City:");  
            lb4.setBounds(20, 210, 150, 20);  
            tf4 = new JTextField(50);  
            tf4.setBounds(180, 210, 100, 20);
            
            
            b1=new JButton("Logout");
            b1.setBounds(50,310,100,20);
            
            b2=new JButton("Register Hospital");
            b2.setBounds(170,310,150,20);
            
            b3=new JButton("Delete Hospital");
            b3.setBounds(340,310,170,20);
            
            b4=new JButton("NextPage");
            b4.setBounds(520,310,120,20);
           l1=new JLabel("");
           l1.setBounds(680,310,300,20);
            setLayout(null); 
            add(tf7);
            add(tf8);
            add(lb5);  
            add(tf5); 
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
            add(b1);
            add(b2);
            add(b3);
            add(b4);
            add(l1);
            
            btn.addActionListener(this);
            b1.addActionListener(this); 
            b2.addActionListener(this); 
            b3.addActionListener(this); 
            b4.addActionListener(this);
            //Set TextField Editable False  
            
            tf1.setEditable(false);  
            tf2.setEditable(false);  
            tf3.setEditable(false);  
            tf4.setEditable(false);
            tf7.setEditable(false);
            tf8.setEditable(false);
        }
          
        public void actionPerformed(ActionEvent ex) {  
            //Create DataBase Coonection and Fetching Records  
            try {  
            if(ex.getSource() == btn)
            { 
            int a=0;
            String str = tf5.getText();
            String str1 = tf7.getText(); 
            String str2 = tf8.getText();
            Class.forName("org.postgresql.Driver");  
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123"); 
                 PreparedStatement st = con.prepareStatement("select hid,hname,haddress,hdistrict from hospital,healthofficer where hospital.hdistrict=healthofficer.district and hname=? and hdistrict=?;");  
                st.setString(1, str);
                st.setString(2, str1);
                ResultSet rs = st.executeQuery();  
                if (rs.next()) {  
                    a++;
                    String s = rs.getString(1);  
                    String s1 = rs.getString(2);  
                    String s2 = rs.getString(3);  
                    String s3 = rs.getString(4);
                    //Sets Records in TextFields.  
                    tf8.setText(s);  
                    tf1.setText(s);
                    tf2.setText(s1);  
                    tf3.setText(s2);  
                    tf4.setText(s3);
                    
       
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
               Login r=new Login();
               }
               else if(ex.getSource() == b4)
               {
               String s2=tf7.getText();
               String s3=tf8.getText();
               SearchDoctor r=new SearchDoctor(s2,s3);
               }
               else if(ex.getSource() == b2)
               {
               String s3=tf7.getText();
               String s4=tf8.getText();
               new RegistrationH(s3,s4);
               }
               else if(ex.getSource() == b3)
               {
               String str = tf5.getText();
               String str1 = tf7.getText(); 
               String stri = tf8.getText();
               int str2 = new Integer(stri);
               Class.forName("org.postgresql.Driver");  
               Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123"); 
               PreparedStatement st = con.prepareStatement("delete from doctor where dname=? and did=?");  
               st.setString(1, str1);  
               st.setInt(2, str2);  
               ResultSet rs1 = st.executeQuery();
               System.out.println("Record Deleted Successful");
                }
            } catch (Exception edsf) {
            System.out.println(edsf);
            }  
        }
   
    }  


