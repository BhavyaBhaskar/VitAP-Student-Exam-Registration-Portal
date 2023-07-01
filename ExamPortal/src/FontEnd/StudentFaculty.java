package FontEnd;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StudentFaculty
{
    public void main(){
        JFrame jfrm = new JFrame("Student / Faculty");
        JLabel jlblstu = new JLabel("Student Login Portal");
        JLabel jlblfac = new JLabel("Faculty Login Portal");
        JButton jbstu = new JButton("Student");
        JButton jbfac = new JButton("Faculty");
        JButton jbclose = new JButton("Close");

        JLabel jlbllogo = new JLabel();
        jlbllogo.setIcon(new ImageIcon("C:\\Users\\bhavy\\IdeaProjects\\ExamPortal\\src\\FontEnd\\VitShortLogo.png"));



        jbstu.setBounds(350,60,200,65);
        jbfac.setBounds(350,180,200,65);
        jbclose.setBounds(10,290,610,60);
        jlbllogo.setBounds(50,10,400,250);
        jlblstu.setBounds(390,10,300,70);
        jlblfac.setBounds(395,130,200,70);


//      Adding Action to Buttons
        jbstu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                StudentLogin stuobj = new StudentLogin();
                stuobj.main();
            }
        });

        jbfac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                FacultyLogin facobj = new FacultyLogin();
                facobj.main();
            }
        });

        jbclose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
            }
        });


        jfrm.getContentPane().setBackground(Color.white);
        jfrm.setSize(650,400);
        jfrm.add(jbstu);
        jfrm.add(jbfac);
        jfrm.add(jbclose);
        jfrm.add(jlbllogo);
        jfrm.add(jlblstu);
        jfrm.add(jlblfac);


        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
}
