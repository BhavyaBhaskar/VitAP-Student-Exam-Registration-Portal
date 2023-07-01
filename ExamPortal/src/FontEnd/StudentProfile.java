package FontEnd;

import BackEnd.BackendInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class StudentProfile extends BackendInterface
{
    public void main()
    {
        String str[] = get_RegNo_Pass();
        BackendInterface.localstuname=str[0];
        BackendInterface.localsturegno=str[1];
        JFrame jfrm = new JFrame("Student Profile");
        JButton jbregister = new JButton("Register for Exam");
        JButton jblogout = new JButton("LogOut");
        JButton jbslot = new JButton("Slot");
        JLabel jlblname = new JLabel("Student Name: "+str[0]);
        JLabel jlblregno = new JLabel("Registration Number: "+str[1]);


        JLabel jlbllogo = new JLabel();
        jlbllogo.setIcon(new ImageIcon("C:\\Users\\bhavy\\IdeaProjects\\ExamPortal\\src\\FontEnd\\VitShortLogo.png"));


        jbregister.setBounds(300,100,200,60);
        jbslot.setBounds(300,180,200,60);
        jblogout.setBounds(470,300,150,50);
        jlbllogo.setBounds(20,10,400,250);
        jlblname.setBounds(300,20,200,30);
        jlblregno.setBounds(300,50,200,30);


        jbregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                StudentExamRegistration SER = new StudentExamRegistration();
                SER.main();
            }
        });
        jbslot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                StudentExamRegistered SER = new StudentExamRegistered();
                SER.Day1();
            }
        });
        jblogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                StudentLogin SL = new StudentLogin();
                SL.main();
            }
        });


        jfrm.getContentPane().setBackground(Color.white);
        jfrm.setSize(650,400);
        jfrm.add(jbregister);
        jfrm.add(jblogout);
        jfrm.add(jbslot);
        jfrm.add(jlbllogo);
        jfrm.add(jlblname);
        jfrm.add(jlblregno);



        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
    public static String[] get_RegNo_Pass()
    {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/studentdb";
            String DBusername = "root";
            String DBpass = "1234";

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(databaseUrl,DBusername,DBpass);


            Statement st = conn.createStatement();
            String sql = "SELECT * FROM studentinfo";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                if(rs.getInt("StudentIndex")==BackendInterface.StudentLoginIndex)
                {
                    String str[] = {rs.getString("StudentName"),rs.getString("StudentRegNo")};
                    return (str);
                }
            }

            System.out.println(rs.getString("StudentName"));

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        String str[] = {"",""};
        return (str);
    }
}