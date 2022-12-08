package Db;

import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager implements IDBManager {
    @Override
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `student` where status = 1");
            while (rs.next()) {
                Student s = new Student();
                s.setId((rs.getInt("id")));
                s.setName((rs.getString("name")));
                s.setSurname((rs.getString("surname")));
                s.setGroup((rs.getString("group")));

                s.setData_enter(rs.getDate("data_enter"));
                res.add(s);
            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }


    @Override
    public void studentCreating(String lastName, String firstName, String groupName, String registrationDate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `group`, `status`, `data_enter`) " +
                    "VALUES ('"+lastName+"', '"+firstName+"', '"+groupName+"', '1',  '"+registrationDate+"')");


            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}

