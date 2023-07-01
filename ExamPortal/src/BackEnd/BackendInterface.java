package BackEnd;

import javax.swing.*;
import java.sql.*;

public class BackendInterface
{
    public static String localstuname;
    public static String localsturegno;
    public static String localfacname;
    public static String localfacid;


    public static int SRI[] = {0,0,0};
    public static int StudentLoginIndex;
    public static int FacultyLoginIndex;
    public static String[] Exam = {"CSE1010: Coding in Python","MAT1001: Advanced Calculus","PHY1008: Modern Physics","ECE1003: Digital Login Design","CSE2005: Object Oriented Programming","MAT1001: Calculus for Engineers"};
    public static String roomNo[]={"101","102","103","201","202","203"};




    //STUDENT METHODS
    public static boolean get_RegNo_Pass(String regno , String pass)
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

            int countRegNo=-1;
            int countPass=-2;
            while (rs.next()) {
                if(rs.getString("StudentRegNo").equalsIgnoreCase(regno))
                {
                    countRegNo = rs.getRow();
                }
                if(rs.getString("StudentPass").equals(pass))
                {
                    countPass = rs.getRow();
                }
            }
            if(countPass==countRegNo)
            {
                BackendInterface.StudentLoginIndex = countPass;
                return true;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    public static void setExam(String ExamChoice)
    {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/studentdb";
            String DBusername = "root";
            String DBpass = "1234";

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(databaseUrl, DBusername, DBpass);


            Statement st = conn.createStatement();
            String query = "SELECT * FROM studentinfo";


            Statement st1 = conn.createStatement();
            String sql1 = "SELECT * FROM studentinfo WHERE StudentIndex=" + StudentLoginIndex;
            PreparedStatement p1 = conn.prepareStatement(sql1);
            ResultSet rs1 = st.executeQuery(sql1);

            int ExamRegisterNo = 1;
            while (rs1.next()) {
                if (rs1.getString("RegisteredExam1") == null) {
                    ExamRegisterNo = 1;
                } else if (rs1.getString("RegisteredExam2") == null) {
                    ExamRegisterNo = 2;
                } else if (rs1.getString("RegisteredExam3") == null) {
                    ExamRegisterNo = 3;
                } else {
                    ExamRegisterNo = 0;
                }
            }

            if (ExamRegisterNo != 0) {
                String sql2 = "UPDATE studentinfo SET RegisteredExam" + ExamRegisterNo + "='" + ExamChoice + "' WHERE StudentIndex=" + StudentLoginIndex;
                Statement stm2 = conn.createStatement();
                stm2.executeUpdate(sql2);
                ResultSet rs = stm2.executeQuery(query);


                JOptionPane.showMessageDialog(null, "Registered Successfully");
            }
            else {
                JOptionPane.showMessageDialog(null, "Already Registered for "+Exam.length+" Exams");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public static void setRoomSeat()
    {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/studentdb";
            String DBusername = "root";
            String DBpass = "1234";

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(databaseUrl, DBusername, DBpass);

            Statement stev = conn.createStatement();
            String sqlev = "SELECT * FROM extravariable";
            PreparedStatement pev = conn.prepareStatement(sqlev);
            ResultSet rsev = stev.executeQuery(sqlev);
            while (rsev.next())
            {
                SRI[0]=rsev.getInt("StudentRegistrationIndexDay1");
                SRI[1]=rsev.getInt("StudentRegistrationIndexDay2");
                SRI[2]=rsev.getInt("StudentRegistrationIndexDay3");
            }

            Statement stsi = conn.createStatement();
            String sqlsi = "SELECT * FROM studentinfo WHERE StudentIndex="+StudentLoginIndex;
            PreparedStatement psi = conn.prepareStatement(sqlsi);
            ResultSet rssi = stev.executeQuery(sqlsi);


            while (rssi.next()) {

                int CountOfExam = rssi.getInt("NoOfExamRegistered");
                String sqlupdate = "";
                if(CountOfExam==1) {
                    if (SRI[0] / 8 == 0) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom1='" + roomNo[0] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] / 8 == 1) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom1='" + roomNo[1] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] / 8 == 2) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom1='" + roomNo[2] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] / 8 == 3) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom1='" + roomNo[3] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] / 8 == 4) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom1='" + roomNo[4] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    }

                    Statement stmupdate = conn.createStatement();
                    stmupdate.executeUpdate(sqlupdate);
                    ResultSet rsupdate = stmupdate.executeQuery(sqlsi);

                    if (SRI[0] % 8 == 1) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat1='R1C1' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] % 8 == 2) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat1='R1C2' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] % 8 == 3) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat1='R1C3' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] % 8 == 4) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat1='R1C4' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] % 8 == 5) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat1='R2C1' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] % 8 == 6) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat1='R2C2' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] % 8 == 7) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat1='R2C3' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[0] % 8 == 0) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat1='R2C4' WHERE StudentIndex=" + StudentLoginIndex;
                    }

                    stmupdate = conn.createStatement();
                    stmupdate.executeUpdate(sqlupdate);
                    rsupdate = stmupdate.executeQuery(sqlsi);
                }

                if(CountOfExam==2)
                {
                    if (SRI[1] / 8 == 0) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom2='" + roomNo[0] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] / 8 == 1) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom2='" + roomNo[1] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] / 8 == 2) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom2='" + roomNo[2] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] / 8 == 3) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom2='" + roomNo[3] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] / 8 == 4) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom2='" + roomNo[4] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    }

                    Statement stmupdate = conn.createStatement();
                    stmupdate.executeUpdate(sqlupdate);
                    ResultSet rsupdate = stmupdate.executeQuery(sqlsi);

                    if (SRI[1] % 8 == 1) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat2='R1C1' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] % 8 == 2) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat2='R1C2' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] % 8 == 3) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat2='R1C3' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] % 8 == 4) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat2='R1C4' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] % 8 == 5) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat2='R2C1' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] % 8 == 6) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat2='R2C2' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] % 8 == 7) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat2='R2C3' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[1] % 8 == 0) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat2='R2C4' WHERE StudentIndex=" + StudentLoginIndex;
                    }

                    stmupdate = conn.createStatement();
                    stmupdate.executeUpdate(sqlupdate);
                    rsupdate = stmupdate.executeQuery(sqlsi);
                }
                else if(CountOfExam==3)
                {
                    if (SRI[2] / 8 == 0) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom3='" + roomNo[0] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] / 8 == 1) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom3='" + roomNo[1] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] / 8 == 2) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom3='" + roomNo[2] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] / 8 == 3) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom3='" + roomNo[3] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] / 8 == 4) {
                        sqlupdate = "UPDATE studentinfo SET StudentRoom3='" + roomNo[4] + "' WHERE StudentIndex=" + StudentLoginIndex;
                    }


                    Statement stmupdate = conn.createStatement();
                    stmupdate.executeUpdate(sqlupdate);
                    ResultSet rsupdate = stmupdate.executeQuery(sqlsi);

                    if (SRI[2] % 8 == 1) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat3='R1C1' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] % 8 == 2) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat3='R1C2' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] % 8 == 3) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat3='R1C3' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] % 8 == 4) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat3='R1C4' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] % 8 == 5) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat3='R2C1' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] % 8 == 6) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat3='R2C2' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] % 8 == 7) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat3='R2C3' WHERE StudentIndex=" + StudentLoginIndex;
                    } else if (SRI[2] % 8 == 0) {
                        sqlupdate = "UPDATE studentinfo SET StudentSeat3='R2C4' WHERE StudentIndex=" + StudentLoginIndex;
                    }

                    stmupdate = conn.createStatement();
                    stmupdate.executeUpdate(sqlupdate);
                    rsupdate = stmupdate.executeQuery(sqlsi);
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public static void setStudentRegistrationIndex()
    {
        try {
            String driver1 = "com.mysql.cj.jdbc.Driver";
            String databaseUrl1 = "jdbc:mysql://localhost:3306/studentdb";
            String DBusername1 = "root";
            String DBpass1 = "1234";

            Class.forName(driver1);

            Connection conn = DriverManager.getConnection(databaseUrl1, DBusername1, DBpass1);

            Statement st1 = conn.createStatement();
            String query1 = "SELECT * FROM extravariable";


            Statement st = conn.createStatement();
            String query = "SELECT * FROM studentinfo";
            PreparedStatement p1 = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);

            int d1=0,d2=0,d3=0;
            while (rs.next())
            {
                if(rs.getString("RegisteredExam1")!=null)
                {
                    d1++;
                }
                if(rs.getString("RegisteredExam2")!=null)
                {
                    d2++;
                }
                if(rs.getString("RegisteredExam3")!=null)
                {
                    d3++;
                }
            }



            String sql = "UPDATE extravariable SET StudentRegistrationIndexDay1="+d1;
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            ResultSet rs1 = stm.executeQuery(query);


            sql = "UPDATE extravariable SET StudentRegistrationIndexDay2="+d2;
            stm.executeUpdate(sql);
            rs1 = stm.executeQuery(query);


            sql = "UPDATE extravariable SET StudentRegistrationIndexDay3="+d3;
            stm.executeUpdate(sql);
            rs1 = stm.executeQuery(query);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void setNoOfExamRegistered()
    {
        try {
            String driver1 = "com.mysql.cj.jdbc.Driver";
            String databaseUrl1 = "jdbc:mysql://localhost:3306/studentdb";
            String DBusername1 = "root";
            String DBpass1 = "1234";

            Class.forName(driver1);

            Connection conn = DriverManager.getConnection(databaseUrl1, DBusername1, DBpass1);

            Statement st1 = conn.createStatement();
            String query1 = "SELECT * FROM studentinfo";
            PreparedStatement p1 = conn.prepareStatement(query1);
            ResultSet rs = st1.executeQuery(query1);

            int cnt=1;
            while (rs.next())
            {
                int count=0;
                for(int i = 1 ; i <= 3 ; i++)
                {
                    if(rs.getString("RegisteredExam"+i)!=null)
                    {
                        count++;
                    }
                }
//                System.out.println(count+" "+cnt);
                String sql = "UPDATE studentinfo SET NoOfExamRegistered="+count+" WHERE StudentIndex="+cnt;
                Statement stm = conn.createStatement();
                stm.executeUpdate(sql);
                cnt++;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static String[] getdetailsStudent()
    {
        try {
            String driver1 = "com.mysql.cj.jdbc.Driver";
            String databaseUrl1 = "jdbc:mysql://localhost:3306/studentdb";
            String DBusername1 = "root";
            String DBpass1 = "1234";

            Class.forName(driver1);

            Connection conn = DriverManager.getConnection(databaseUrl1, DBusername1, DBpass1);

            Statement st1 = conn.createStatement();
            String query1 = "SELECT * FROM studentinfo WHERE StudentIndex="+StudentLoginIndex;
            PreparedStatement p1 = conn.prepareStatement(query1);
            ResultSet rs = st1.executeQuery(query1);

            String[] StudentDetail = {"","","","","","","","","","",""};
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
        return null;
    }



    //Faculty Methods

    public static boolean get_FacId_Pass(String regno , String pass)
    {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/studentdb";
            String DBusername = "root";
            String DBpass = "1234";

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(databaseUrl,DBusername,DBpass);


            Statement st = conn.createStatement();
            String sql = "SELECT * FROM facultyinfo";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);

            int countRegNo=-1;
            int countPass=-2;
            while (rs.next()) {
                if(rs.getString("FacultyId").equalsIgnoreCase(regno))
                {
                    localfacid=rs.getString("FacultyId");
                    localfacname=rs.getString("FacultyName");
                    countRegNo = rs.getRow();
                }
                if(rs.getString("FacultyPass").equals(pass))
                {
                    countPass = rs.getRow();
                }
            }
            if(countPass==countRegNo)
            {

                BackendInterface.FacultyLoginIndex = countPass;
                return true;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

}