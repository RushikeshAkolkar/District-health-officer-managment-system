    import javax.swing.*;  
    import java.awt.*;  
    import java.awt.event.*;  
    import java.sql.*;  
    public class Registration extends JFrame implements ActionListener   
    {  
        JLabel l1, l2, l3, l4, l5, l6, l7, l8;  
        JTextField tf1, tf2, tf3, tf4, tf5;  
        JButton btn1, btn2,btn3;  
        JPasswordField p1, p2;  
        Registration()
        {  
            setVisible(true);  
            setSize(600, 600);  
            setLayout(null);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            setTitle("Registration Form in Java");  
            l1 = new JLabel("Registration Form for medical officer");  
            l1.setForeground(Color.blue);  
            l1.setFont(new Font("Serif", Font.BOLD, 20));  
            
            l2 = new JLabel("District:");  
            l3 = new JLabel("Name of Officer:");  
            l4 = new JLabel("Registration Number:");  
            l5 = new JLabel("Mobile Number");
            l6 = new JLabel("Email ID:");
            
            l7 = new JLabel("Create Passowrd:");     
            l8 = new JLabel("Confirm Password:");
            
            tf1 = new JTextField();  
            tf2 = new JTextField(); 
            tf4 = new JTextField();
            tf5 = new JTextField();
             
            p1 = new JPasswordField();  
            p2 = new JPasswordField();   
            
            btn1 = new JButton("Submit");  
            btn2 = new JButton("Clear");  
            btn3 = new JButton("Back");
            
            btn1.addActionListener(this);  
            btn2.addActionListener(this);
            btn3.addActionListener(this);  
            
            l1.setBounds(100, 30, 400, 30);  
         
            l2.setBounds(80, 70, 100, 30);  
            l3.setBounds(80, 110, 100, 30);  
            l4.setBounds(80, 150, 100, 30);  
            l5.setBounds(80, 190, 100, 30);  
            
            l6.setBounds(80,230,100,30);
            l7.setBounds(80,270,100,30);
            l8.setBounds(80,310,100,30);
            
            tf1.setBounds(300, 70, 100, 30);  
            tf2.setBounds(300, 230, 100, 30); 
            tf3.setBounds(300, 270, 100, 30);  
            tf4.setBounds(300, 310, 100, 30);  
            tf5.setBounds(300, 350, 100, 30);
            
            p1.setBounds(300, 390, 100, 30); 
            p2.setBounds(300, 430, 100, 30);
            
            btn1.setBounds(50, 450, 100, 30);  
            btn2.setBounds(100, 450, 100, 30);  
            btn3.setBounds(290, 450, 100, 30);
            
            add(l1);  
          
            add(l2);  
            add(tf1);  
          
            add(l3);  
            add(tf2);  
          
            add(l4);  
            add(tf3);
            
            add(l5);
            add(tf4);
            
            add(l6);
            add(tf5);
            
            add(l7);
            add(p1);
            
            add(l8);
            add(p2);
             
            add(btn1);  
            add(btn2);
            add(btn3);  
        }  
        public void actionPerformed(ActionEvent e)   
        {  
         try  
            {
            if (e.getSource() == btn1)  
             {  
                int x = 0;  
                String s1 = tf1.getText(); 
                String s2 = tf2.getText();       
                String si1 = tf3.getText();  
                int s3 = new Integer(si1);
                String si2 = tf4.getText();
                int s4 = new Integer(si2);
                String s5 = tf5.getText();
                String s6 = p1.getText();
                String s7 = p2.getText();
                if (s6.equals(s7))  
                {    
                        Class.forName("org.postgresql.Driver");  
                        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "123");  
                        PreparedStatement ps = con.prepareStatement("insert into healthofficer values(?,?,?,?,?,?)");  
                        ps.setString(1, s1);  
                        ps.setString(2, s2);  
                        ps.setInt(3, s3);    
                        ps.setInt(4, s4);    
                        ps.setString(5, s5);    
                        ps.setString(6, s7);    
                        ResultSet rs = ps.executeQuery();  
                        x++;  
                        if (x > 0)   
                        {  
                            JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");  
                        }  
                    }  
                      
                }
                if (e.getSource() == btn3)
              {
              new Login();
              }  
               if(e.getSource() == btn2)  
              {  
                tf1.setText("");  
                tf2.setText("");  
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                p1.setText("");  
                p2.setText("");   
              }    
              }
              catch (Exception ex)   
                    {  
                        System.out.println(ex);  
                    }
        }       
        public static void main(String args[])
        {
       Registration rhf= new Registration();
        }
    }  

