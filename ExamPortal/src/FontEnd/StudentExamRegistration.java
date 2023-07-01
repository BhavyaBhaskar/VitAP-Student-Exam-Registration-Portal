package FontEnd;
import BackEnd.BackendInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentExamRegistration extends BackendInterface
{
    public void main()
    {
        JFrame jfrm = new JFrame("Exam Registration");
        JLabel jlblname = new JLabel("Full Name");
        JLabel jlblregno = new JLabel("Registration Number");
        JTextField jtxtname = new JTextField();
        JTextField jtxtregno = new JTextField();
        JButton jbregister = new JButton("Register");
        JButton jbcancel = new JButton("Cancel");

        JComboBox jcb = new JComboBox(BackendInterface.Exam);



        jlblname.setBounds(10,10,200,30);
        jtxtname.setBounds(200,10,200,30);
        jlblregno.setBounds(10,50,200,30);
        jtxtregno.setBounds(200,50,200,30);
        jcb.setBounds(10,90,200,30);
        jbregister.setBounds(10,130,100,30);
        jbcancel.setBounds(110,130,100,30);


        jtxtname.setText(BackendInterface.localstuname);
        jtxtregno.setText(BackendInterface.localsturegno);


        jbregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ExamChoice = (String) jcb.getItemAt(jcb.getSelectedIndex());
                jfrm.dispose();
                StudentProfile SP = new StudentProfile();
                SP.main();
                setExam(ExamChoice);
                setNoOfExamRegistered();
                setStudentRegistrationIndex();
                setRoomSeat();

            }
        });

        jbcancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                StudentProfile stu = new StudentProfile();
                stu.main();
            }
        });


        jfrm.setSize(500,200);
        jfrm.add(jlblname);
        jfrm.add(jlblregno);
        jfrm.add(jtxtname);
        jfrm.add(jtxtregno);
        jfrm.add(jcb);
        jfrm.add(jbregister);
        jfrm.add(jbcancel);


        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
}