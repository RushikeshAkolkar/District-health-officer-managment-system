    import javax.swing.*;  
    import java.awt.*;  
    import java.awt.event.*;  
    import java.sql.*;  
    public class RegistrationH extends JFrame implements ActionListener   
    {  
        JLabel l1, l2, l3, l4, l5,l6;  
        JTextField tf1, tf2, tf3, tf4,tf5,tf6;  
        JButton btn1, btn2,btn3,btn4;  
          
        RegistrationH(String s3,String s4)
        {  
            setVisible(true);  
            setSize(1500, 1500);  
            setLayout(null);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            setTitle("Registration Form in Java");  
            l1 = new JLabel("Registration Form for Hospital");  
            l1.setForeground(Color.blue);  
            l1.setFont(new Font("Serif", Font.BOLD, 20));  
            
            l2 = new JLabel("Hospital id:");  
            l3 = new JLabel("Hospital Name:");  
            l4 = new JLabel("Hospital Address:");  
            l5 = new JLabel("Hospital District:");
            l6 = new JLabel("");
            tf1 = new JTextField(50);  
            tf2 = new JTextField(50); 
            tf3 = new JTextField(50);
            tf4 = new JTextField(s3);
            tf5 = new JTextField(s3);
            tf6 = new JTextField(s4);
            btn1 = new JButton("Submit");  
            btn2 = new JButton("Clear");  
            btn3 = new JButton("Back");
            btn1.addActionListener(this);  
            btn2.addActionListener(this);
            btn3.addActionListener(this);
            
            l1.setBounds(100, 30, 400, 20);  
         
            l2.setBounds(80, 70, 120, 20);
            tf1.setBounds(300, 70, 150, 20);  
            l3.setBounds(80, 110, 120, 20); 
            tf2.setBounds(300,110, 150, 20); 
            l4.setBounds(80, 150, 130, 20); 
            tf3.setBounds(300,150, 150, 20); 
            l5.setBounds(80,190, 120, 20);  
            tf4.setBounds(300,190, 150, 20);
            
            l6.setBounds(80,230,100,20);
            
            btn1.setBounds(50, 270, 100, 20);  
            btn2.setBounds(170, 270, 100, 20);  
            btn3.setBounds(290, 270, 100, 20);
            
            add(tf5);
            add(tf6);
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
            add(btn1);  
            add(btn2);
            add(btn3);  
            tf1.setEditable(false);
            tf4.setEditable(false);
        }  
        public void actionPerformed(ActionEvent e)   
        {
         try  
            {
            if (e.getSource() == btn1)  
             {  
            int y=1;
            Class.forName("org.postgresql.Driver");  
                        Connection con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123");
                        PreparedStatement ps1 = con1.prepareStatement("select max(hid) from hospital");
                        ResultSet rs1 = ps1.executeQuery();  
                        if (rs1.next()) {
                        y=rs1.getInt(1);
                        y++;
                        String a = Integer.toString(y);
                        tf1.setText(a); 
                        }
                        
                String si = tf1.getText();  
                int s1 = new Integer(si);     
                String s2 = tf2.getText();  
                String s3 = tf3.getText();
                String s4 = tf4.getText(); 
                        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123");
                        PreparedStatement ps = con.prepareStatement("insert into  hospital values(?,?,?,?)");  
                        ps.setInt(1, y);  
                        ps.setString(2, s2);  
                        ps.setString(3, s3);    
                        ps.setString(4, s4);            
                        ResultSet rs = ps.executeQuery(); 
                    }  
                if (e.getSource() == btn3)
              {
              String s3 = tf5.getText();
              String s4 = tf6.getText();
              new SwingSearchApp(s3,s4);
              }  
               if(e.getSource() == btn2)  
              {  
                tf1.setText("");  
                tf2.setText("");  
                tf3.setText("");
              }       
              }
              catch (Exception ex)   
                    {  
                        System.out.println(ex);  
                    }
        }       
    }  
