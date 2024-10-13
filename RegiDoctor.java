import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;  
public class RegiDoctor extends JFrame implements ActionListener {  
    //Initializing Components  
        JLabel l1,lb, lb1, lb2, lb3,lb4,lb5,lb6;  
        JTextField tf1, tf2, tf3, tf4,tf5,tf6;  
        JButton btn,b1,b2,b3;  
        //Creating Constructor for initializing JFrame components  
        public RegiDoctor(String s1,String s2)  {  
            setVisible(true); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            setSize(1000, 1000);
            setLayout(null);
            //Providing Title  
            setTitle("Register Doctor Information");
            
            lb = new JLabel("RegisterDoctor Doctor Information From Database");  
            lb.setBounds(30, 20, 600, 30);  
            lb.setForeground(Color.red);  
            lb.setFont(new Font("Serif", Font.BOLD, 20)); 
             
            
            tf5 = new JTextField(s1);
            tf5.setBounds(650,90,90,20);
            
            tf6 = new JTextField(s2);
            tf6.setBounds(760,90,90,20);

            lb1 = new JLabel("Doctor id from Hospital:");  
            lb1.setBounds(20, 120, 150, 20);  
            tf1 = new JTextField(s2);  
            tf1.setBounds(180, 120, 200, 20); 
             
            lb2 = new JLabel("Doctor Name:");  
            lb2.setBounds(20, 150, 150, 20);  
            tf2 = new JTextField(100);  
            tf2.setBounds(180, 150, 200, 20);  
            
            lb3 = new JLabel("Doctor Qualification:");  
            lb3.setBounds(20, 180, 150, 20);  
            tf3 = new JTextField(50);  
            tf3.setBounds(180, 180, 200, 20);  
            
            lb4 = new JLabel("Doctor Salary:");  
            lb4.setBounds(20, 210, 150, 20);  
            tf4 = new JTextField(50);  
            tf4.setBounds(180, 210, 200, 20);
            
            btn=new JButton("Register Doctor");
            btn.setBounds(170,310,150,20);
            
            b1=new JButton("Back");
            b1.setBounds(50,310,100,20);

            b3=new JButton("Clear");
            b3.setBounds(340,310,170,20);
            
                        
            btn.addActionListener(this);
            b1.addActionListener(this);  
            b3.addActionListener(this);
            
           l1=new JLabel("");
           l1.setBounds(610,310,300,20);
           setLayout(null);
           
            add(lb);
            add(tf5);
            add(tf6);
            add(lb1);  
            add(tf1);  
            add(lb2);  
            add(tf2);  
            add(lb3);  
            add(tf3);  
            add(lb4);  
            add(tf4);
            add(btn);
            add(b1);
            add(btn);
            add(b3);
            add(l1);
 
            tf6.setEditable(false);
            tf1.setEditable(false);
            tf5.setEditable(false); 
        }  
        public void actionPerformed(ActionEvent ex) {  
            //Create DataBase Coonection and Fetching Records  
            try {  
            if(ex.getSource() == btn)
            { 
            String si = tf6.getText();
            int s1 = new Integer(si);
            String s2 = tf2.getText();
            String s3 = tf3.getText();
            String si1 = tf4.getText();
            float s4 = new Float(si1);
            Class.forName("org.postgresql.Driver");  
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123"); 
                 PreparedStatement st = con.prepareStatement("insert into doctor values(?,?,?,?)");  
                st.setInt(1, s1);
                st.setString(2, s2);
                st.setString(3, s3);
                st.setFloat(4, s4);
                ResultSet rs = st.executeQuery();  
                }
                else if(ex.getSource() == b1)
               {
               String s1 = tf5.getText();
               String s2 = tf6.getText();
               new SearchDoctor(s1,s2);
               }
               else if(ex.getSource() == b2)
               {
               
               }
               else if(ex.getSource() == b3)
               {
                tf1.setText("");  
                tf2.setText("");  
                tf3.setText("");
                tf4.setText("");
               }
            } catch (Exception edsf) {
            System.out.println(edsf);
            }  
        }
    }  


