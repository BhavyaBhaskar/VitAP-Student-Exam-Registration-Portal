package FontEnd;

import BackEnd.BackendInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyLogin extends BackendInterface
{
    public void main()
    {
        JFrame jfrm = new JFrame("Faculty Login");
        JLabel jlblregno = new JLabel("Faculty ID");
        JLabel jlblpass = new JLabel("PassWord");
        JTextField jtxtregno = new JTextField();
        JPasswordField jtxtpass = new JPasswordField();
        JButton jbnext = new JButton("NEXT");
        JButton jbcancel = new JButton("CANCEL");

        JLabel jlbllogo = new JLabel();
        jlbllogo.setIcon(new ImageIcon("C:\\Users\\bhavy\\IdeaProjects\\ExamPortal\\src\\FontEnd\\VitShortLogo.png"));


        jlblregno.setBounds(390,45,150,20);
        jtxtregno.setBounds(320,75,200,20);
        jlblpass.setBounds(388,115,150,20);
        jtxtpass.setBounds(320,145,200,20);
        jbnext.setBounds(295,212,120,40);
        jbcancel.setBounds(425,212,120,40);
        jlbllogo.setBounds(30,15,400,250);

        jbnext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String facid = jtxtregno.getText();
                String pass = new String(jtxtpass.getPassword());

                if(get_FacId_Pass(facid,pass))
                {
                    FacultyProfile FP = new FacultyProfile();
                    FP.Day1();
                    jfrm.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid FacultyID or PassWord");
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
