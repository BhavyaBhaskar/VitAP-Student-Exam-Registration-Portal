package FontEnd;

import BackEnd.BackendInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentExamRegistered extends BackendInterface
{
    public void Day1()
    {
        JFrame jfrm = new JFrame("Exam Registered");
        JButton jbback = new JButton("Back");
        JLabel jlblstuName[];
        JLabel jlblregNo[];
        JLabel jlblExam[];
        JLabel jlblroom[];
        JLabel jlblseat[];

        String StudentDetails[] = BackendInterface.getdetailsStudent();

        if(StudentDetails[2]==null && StudentDetails[5]==null && StudentDetails[8]==null)
        {
            JOptionPane.showMessageDialog(null,"Havent Registered for an exam");
            jfrm.dispose();
            StudentProfile Sp = new StudentProfile();
            Sp.main();
        }
        else if(StudentDetails[2]!=null && StudentDetails[5]==null && StudentDetails[8]==null)
        {
            jlblstuName = new JLabel[1];
            jlblregNo = new JLabel[1];
            jlblExam = new JLabel[1];
            jlblroom = new JLabel[1];
            jlblseat = new JLabel[1];

            for(int i = 0 ; i < 1 ; i++)
            {
                jlblstuName[i] = new JLabel("Name: "+StudentDetails[0]);
                jlblregNo[i] = new JLabel("Registration Number: "+StudentDetails[1]);
                jlblExam[i] = new JLabel("Exam: "+StudentDetails[2]);
                jlblroom[i] = new JLabel("Room: "+StudentDetails[3]);
                jlblseat[i] = new JLabel("Seat: "+StudentDetails[4]);


                jbback.setBounds(10,120+100*i,100,30);
                jlblstuName[i].setBounds(10,10,200,30);
                jlblregNo[i].setBounds(10,40,200,30);
                jlblExam[i].setBounds(10,70+100*i,300,30);
                jlblroom[i].setBounds(290,70+100*i,220,30);
                jlblseat[i].setBounds(290,100+100*i,220,30);


                jfrm.setSize(500,200);
                jfrm.add(jbback);
                jfrm.add(jlblstuName[i]);
                jfrm.add(jlblregNo[i]);
                jfrm.add(jlblExam[i]);
                jfrm.add(jlblroom[i]);
                jfrm.add(jlblseat[i]);

                jfrm.setLayout(null);
                jfrm.setVisible(true);
            }
        }
        else if(StudentDetails[2]!=null && StudentDetails[5]!=null && StudentDetails[8]==null)
        {
            jlblstuName = new JLabel[2];
            jlblregNo = new JLabel[2];
            jlblExam = new JLabel[2];
            jlblroom = new JLabel[2];
            jlblseat = new JLabel[2];

            for(int i = 0 ; i < 2 ; i++)
            {
                jlblstuName[i] = new JLabel("Name: "+StudentDetails[0]);
                jlblregNo[i] = new JLabel("Registration Number: "+StudentDetails[1]);
                jlblExam[i] = new JLabel("Exam: "+StudentDetails[2+(3*i)]);
                jlblroom[i] = new JLabel("Room: "+StudentDetails[3+(3*i)]);
                jlblseat[i] = new JLabel("Seat: "+StudentDetails[4+(3*i)]);


                jbback.setBounds(10,120+100*i,100,30);
                jlblstuName[i].setBounds(10,10,200,30);
                jlblregNo[i].setBounds(10,40,200,30);
                jlblExam[i].setBounds(10,70+100*i,300,30);
                jlblroom[i].setBounds(290,70+100*i,220,30);
                jlblseat[i].setBounds(290,100+100*i,220,30);


                jfrm.setSize(500,300);
                jfrm.add(jbback);
                jfrm.add(jlblstuName[i]);
                jfrm.add(jlblregNo[i]);
                jfrm.add(jlblExam[i]);
                jfrm.add(jlblroom[i]);
                jfrm.add(jlblseat[i]);

                jfrm.setLayout(null);
                jfrm.setVisible(true);
            }
        }
        else if(StudentDetails[2]!=null && StudentDetails[5]!=null && StudentDetails[8]!=null)
        {
            jlblstuName = new JLabel[3];
            jlblregNo = new JLabel[3];
            jlblExam = new JLabel[3];
            jlblroom = new JLabel[3];
            jlblseat = new JLabel[3];

            for(int i = 0 ; i < 3 ; i++)
            {
                jlblstuName[i] = new JLabel("Name: "+StudentDetails[0]);
                jlblregNo[i] = new JLabel("Registration Number: "+StudentDetails[1]);
                jlblExam[i] = new JLabel("Exam: "+StudentDetails[2+(3*i)]);
                jlblroom[i] = new JLabel("Room: "+StudentDetails[3+(3*i)]);
                jlblseat[i] = new JLabel("Seat: "+StudentDetails[4+(3*i)]);


                jbback.setBounds(10,120+100*i,100,30);
                jlblstuName[i].setBounds(10,10,200,30);
                jlblregNo[i].setBounds(10,40,200,30);
                jlblExam[i].setBounds(10,70+100*i,300,30);
                jlblroom[i].setBounds(290,70+100*i,220,30);
                jlblseat[i].setBounds(290,100+100*i,220,30);


                jfrm.setSize(500,400);
                jfrm.add(jbback);
                jfrm.add(jlblstuName[i]);
                jfrm.add(jlblregNo[i]);
                jfrm.add(jlblExam[i]);
                jfrm.add(jlblroom[i]);
                jfrm.add(jlblseat[i]);

                jfrm.setLayout(null);
                jfrm.setVisible(true);
            }
        }



        jbback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                StudentProfile stu = new StudentProfile();
                stu.main();
            }
        });

    }
}