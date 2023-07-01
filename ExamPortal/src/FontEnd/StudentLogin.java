package FontEnd;

import BackEnd.BackendInterface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentLogin extends BackendInterface
{
    public void main()
    {
        JFrame jfrm = new JFrame("Student Login");
        JLabel jlblregno = new JLabel("Registration Number");
        JLabel jlblpass = new JLabel("PassWord");
        JTextField jtxtregno = new JTextField();
        JPasswordField jtxtpass = new JPasswordField();
        JButton jbnext = new JButton("NEXT");
        JButton jbcancel = new JButton("CANCEL");

        JLabel jlbllogo = new JLabel();
        jlbllogo.setIcon(new ImageIcon("C:\\Users\\bhavy\\IdeaProjects\\ExamPortal\\src\\FontEnd\\VitShortLogo.png"));




        jlblregno.setBounds(360,45,150,20);
        jtxtregno.setBounds(320,75,200,20);
        jlblpass.setBounds(388,115,150,20);
        jtxtpass.setBounds(320,145,200,20);
        jbnext.setBounds(295,212,120,40);
        jbcancel.setBounds(425,212,120,40);
        jlbllogo.setBounds(30,15,400,250);




        jbnext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String regno = jtxtregno.getText();
                String pass = new String(jtxtpass.getPassword());

                if(get_RegNo_Pass(regno,pass))
                {
                    StudentProfile SP = new StudentProfile();
                    SP.main();
                    jfrm.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Registration Number or PassWord");
                }
            }
        });

        jbcancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                StudentFaculty stufac = new StudentFaculty();
                stufac.main();
            }
        });


        jfrm.getContentPane().setBackground(Color.white);
        jfrm.setSize(650,400);
        jfrm.add(jlblregno);
        jfrm.add(jlblpass);
        jfrm.add(jtxtregno);
        jfrm.add(jtxtpass);
        jfrm.add(jbnext);
        jfrm.add(jbcancel);
        jfrm.add(jlbllogo);



        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
}