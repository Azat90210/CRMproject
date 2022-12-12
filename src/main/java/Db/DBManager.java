package Db;

import entity.Disciplin;
import entity.Student;
import entity.Term;

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
    public ArrayList<Disciplin> getAllDisciplin() {
        ArrayList<Disciplin> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `discipline` where status = 1");
            while (rs.next()) {
                Disciplin d = new Disciplin();
                d.setId((rs.getInt("id")));
                d.setName((rs.getString("name")));
                res.add(d);
            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public ArrayList<Term> getAllTerm() {
        ArrayList<Term> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `term`");
            while (rs.next()) {
                Term t = new Term();
                t.setId((rs.getInt("id")));
                t.setName((rs.getString("name")));
                t.setDuration((rs.getInt("duration")));
                res.add(t);
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

    @Override
    public void disciplinCreating(String disciplinName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `discipline` (`name`, `status`) " +
                    "VALUES ('"+disciplinName+"', '1')");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteStudent(String ids) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` in("+ ids +"));");
            stmt.execute("DELETE from `student` WHERE (`id` in("+ ids +"));");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteDisciplin(String ids) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` in("+ ids +"));");
            stmt.execute("DELETE from `discipline` WHERE (`id` in("+ ids +"));");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

