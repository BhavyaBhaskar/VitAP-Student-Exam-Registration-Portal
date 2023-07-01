package FontEnd;

import BackEnd.BackendInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FacultyProfile extends BackendInterface
{
    public static void Day1()
    {
        JFrame jfrm = new JFrame();
        JButton jbback = new JButton("Back");
        JLabel jlblname = new JLabel("Faculty Name: "+localfacname);
        JLabel jlblfacid = new JLabel("Faculty ID: "+localfacid);


        JLabel jlblroom = new JLabel("Room: " + roomNo[FacultyLoginIndex-1]);
        JLabel[] jlblstuname = new JLabel[8];
        JLabel[] jlblsturegno = new JLabel[8];
        JLabel[] jlblstuexam = new JLabel[8];
        JLabel[] jlblstuseat = new JLabel[8];


        JButton day1 = new JButton("Day1");
        JButton day2 = new JButton("Day2");
        JButton day3 = new JButton("Day3");


        int cnt=0;
        try {
            for (int i = 0; i < 8; i++) {
                String[] detail = getdetails(((FacultyLoginIndex-1)*8)+(i+1));
                if(detail[2]!=null)
                {
                    jlblstuname[cnt] = new JLabel("Name: "+detail[0]);
                    jlblsturegno[cnt] = new JLabel("RegNo: "+detail[1]);
                    jlblstuexam[cnt] = new JLabel("Exam: "+detail[2]);
                    jlblstuseat[cnt] = new JLabel("Seat: "+detail[4]);

                    jlblstuname[cnt].setBounds(10, (70 + (30 * cnt)), 600, 30);
                    jlblsturegno[cnt].setBounds(190, (70 + (30 * cnt)), 600, 30);
                    jlblstuexam[cnt].setBounds(315, (70 + (30 * cnt)), 600, 30);
                    jlblstuseat[cnt].setBounds(540, (70 + (30 * cnt)), 600, 30);

                    cnt++;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        day2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                Day2();
            }
        });
        day3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                Day3();
            }
        });


        jlblname.setBounds(10,10,200,30);
        jlblfacid.setBounds(10,40,200,30);
        jbback.setBounds(510,310,100,30);
        jlblroom.setBounds(220,10,200,30);
        day1.setBounds(10,310,100,30);
        day2.setBounds(110,310,100,30);
        day3.setBounds(210,310,100,30);




        jbback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                FacultyLogin fl = new FacultyLogin();
                fl.main();
            }
        });



        jfrm.setSize(650,400);
        jfrm.add(jbback);
        jfrm.add(jlblname);
        jfrm.add(jlblfacid);
        jfrm.add(jlblroom);
        for(int i = 0 ; i < cnt ; i++)
        {
            jfrm.add(jlblstuname[i]);
            jfrm.add(jlblsturegno[i]);
            jfrm.add(jlblstuexam[i]);
            jfrm.add(jlblstuseat[i]);
        }
        jfrm.add(day1);
        jfrm.add(day2);
        jfrm.add(day3);


        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
    public static void Day2()
    {
        JFrame jfrm = new JFrame();
        JButton jbback = new JButton("Back");
        JLabel jlblname = new JLabel("Faculty Name: "+localfacname);
        JLabel jlblfacid = new JLabel("Faculty ID: "+localfacid);


        JLabel jlblroom = new JLabel("Room: " + roomNo[FacultyLoginIndex-1]);
        JLabel[] jlblstuname = new JLabel[8];
        JLabel[] jlblsturegno = new JLabel[8];
        JLabel[] jlblstuexam = new JLabel[8];
        JLabel[] jlblstuseat = new JLabel[8];


        JButton day1 = new JButton("Day1");
        JButton day2 = new JButton("Day2");
        JButton day3 = new JButton("Day3");


        int cnt=0;
        try {
            for (int i = 0; i < 8; i++) {
                String[] detail = getdetails(((FacultyLoginIndex-1)*8)+(i+1));
                if(detail[5]!=null)
                {
                    jlblstuname[cnt] = new JLabel("Name: "+detail[0]);
                    jlblsturegno[cnt] = new JLabel("RegNo: "+detail[1]);
                    jlblstuexam[cnt] = new JLabel("Exam: "+detail[5]);
                    jlblstuseat[cnt] = new JLabel("Seat: "+detail[7]);

                    jlblstuname[cnt].setBounds(10, (70 + (30 * cnt)), 600, 30);
                    jlblsturegno[cnt].setBounds(190, (70 + (30 * cnt)), 600, 30);
                    jlblstuexam[cnt].setBounds(315, (70 + (30 * cnt)), 600, 30);
                    jlblstuseat[cnt].setBounds(540, (70 + (30 * cnt)), 600, 30);

                    cnt++;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        day1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                Day1();
            }
        });
        day3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                Day3();
            }
        });


        jlblname.setBounds(10,10,200,30);
        jlblfacid.setBounds(10,40,200,30);
        jbback.setBounds(510,310,100,30);
        jlblroom.setBounds(220,10,200,30);
        day1.setBounds(10,310,100,30);
        day2.setBounds(110,310,100,30);
        day3.setBounds(210,310,100,30);




        jbback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                FacultyLogin fl = new FacultyLogin();
                fl.main();
            }
        });



        jfrm.setSize(650,400);
        jfrm.add(jbback);
        jfrm.add(jlblname);
        jfrm.add(jlblfacid);
        jfrm.add(jlblroom);
        for(int i = 0 ; i < cnt ; i++)
        {
            jfrm.add(jlblstuname[i]);
            jfrm.add(jlblsturegno[i]);
            jfrm.add(jlblstuexam[i]);
            jfrm.add(jlblstuseat[i]);
        }
        jfrm.add(day1);
        jfrm.add(day2);
        jfrm.add(day3);


        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
    public static void Day3()
    {
        JFrame jfrm = new JFrame();
        JButton jbback = new JButton("Back");
        JLabel jlblname = new JLabel("Faculty Name: "+localfacname);
        JLabel jlblfacid = new JLabel("Faculty ID: "+localfacid);


        JLabel jlblroom = new JLabel("Room: " + roomNo[FacultyLoginIndex-1]);
        JLabel[] jlblstuname = new JLabel[8];
        JLabel[] jlblsturegno = new JLabel[8];
        JLabel[] jlblstuexam = new JLabel[8];
        JLabel[] jlblstuseat = new JLabel[8];


        JButton day1 = new JButton("Day1");
        JButton day2 = new JButton("Day2");
        JButton day3 = new JButton("Day3");


        int cnt=0;
        try {
            for (int i = 0; i < 8; i++) {
                String[] detail = getdetails(((FacultyLoginIndex-1)*8)+(i+1));
                if(detail[8]!=null)
                {
                    jlblstuname[cnt] = new JLabel("Name: "+detail[0]);
                    jlblsturegno[cnt] = new JLabel("RegNo: "+detail[1]);
                    jlblstuexam[cnt] = new JLabel("Exam: "+detail[8]);
                    jlblstuseat[cnt] = new JLabel("Seat: "+detail[10]);

                    jlblstuname[cnt].setBounds(10, (70 + (30 * cnt)), 600, 30);
                    jlblsturegno[cnt].setBounds(190, (70 + (30 * cnt)), 600, 30);
                    jlblstuexam[cnt].setBounds(315, (70 + (30 * cnt)), 600, 30);
                    jlblstuseat[cnt].setBounds(540, (70 + (30 * cnt)), 600, 30);

                    cnt++;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        day1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                Day1();
            }
        });
        day2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                Day2();
            }
        });


        jlblname.setBounds(10,10,200,30);
        jlblfacid.setBounds(10,40,200,30);
        jbback.setBounds(510,310,100,30);
        jlblroom.setBounds(220,10,200,30);
        day1.setBounds(10,310,100,30);
        day2.setBounds(110,310,100,30);
        day3.setBounds(210,310,100,30);




        jbback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfrm.dispose();
                FacultyLogin fl = new FacultyLogin();
                fl.main();
            }
        });



        jfrm.setSize(650,400);
        jfrm.add(jbback);
        jfrm.add(jlblname);
        jfrm.add(jlblfacid);
        jfrm.add(jlblroom);
        for(int i = 0 ; i < cnt ; i++)
        {
            jfrm.add(jlblstuname[i]);
            jfrm.add(jlblsturegno[i]);
            jfrm.add(jlblstuexam[i]);
            jfrm.add(jlblstuseat[i]);
        }
        jfrm.add(day1);
        jfrm.add(day2);
        jfrm.add(day3);


        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }
    public static String[] getdetails(int i)
    {
        String[] StudentDetail = {"","","","","","","","","","",""};
        try {
            String driver1 = "com.mysql.cj.jdbc.Driver";
            String databaseUrl1 = "jdbc:mysql://localhost:3306/studentdb";
            String DBusername1 = "root";
            String DBpass1 = "1234";

            Class.forName(driver1);

            Connection conn = DriverManager.getConnection(databaseUrl1, DBusername1, DBpass1);

            Statement st1 = conn.createStatement();
            String query1 = "SELECT * FROM studentinfo WHERE StudentIndex="+i;
            PreparedStatement p1 = conn.prepareStatement(query1);
            ResultSet rs = st1.executeQuery(query1);

            while (rs.next())
            {
                StudentDetail[0]=rs.getString("StudentName");
                StudentDetail[1]=rs.getString("StudentRegNo");
                StudentDetail[2]=rs.getString("RegisteredExam1");
                StudentDetail[3]=rs.getString("StudentRoom1");
                StudentDetail[4]=rs.getString("StudentSeat1");
                StudentDetail[5]=rs.getString("RegisteredExam2");
                StudentDetail[6]=rs.getString("StudentRoom2");
                StudentDetail[7]=rs.getString("StudentSeat2");
                StudentDetail[8]=rs.getString("RegisteredExam3");
                StudentDetail[9]=rs.getString("StudentRoom3");
                StudentDetail[10]=rs.getString("StudentSeat3");
            }
            return (StudentDetail);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return (StudentDetail);
    }
}