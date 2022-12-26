package Db;

import entity.*;

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
    public void newsCreating(String newsName, String news) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `new` (`name`, `text`,`status`) " +
                    "VALUES ('"+newsName+"','"+news+"', '1')");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<News> getAllNews() {
        ArrayList<News> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `new`");
            while (rs.next()) {
                News t = new News();
                t.setId((rs.getInt("id")));
                t.setName((rs.getString("name")));
                t.setText((rs.getString("text")));
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
                t.setId((rs.getInt("duration")));
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
    public void deleteNews(String ids) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `new` SET `status` = '0' WHERE (`id` in("+ ids +"));");
            stmt.execute("DELETE from `new` WHERE (`id` in("+ ids +"));");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
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

    @Override
    public Student getStudentById(String ids) {
       Student s = new Student();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `student` where `status` = 1 and `id` = " + ids );
            while (rs.next()) {
                s.setId((rs.getInt("id")));
                s.setName((rs.getString("name")));
                s.setSurname((rs.getString("surname")));
                s.setGroup((rs.getString("group")));
                s.setData_enter(rs.getDate("data_enter"));
            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    @Override
    public ArrayList<Term> getTermbyIdStudent(String ids) {
        ArrayList<Term> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct t.* from term t\n" +
                    "join term_discipline td on t.id = td.id_term\n" +
                    "join student_termdiscipline_mark stm on td.id = stm.id_termDiscipline\n" +
                    "and stm.id_student = " + ids);
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
    public ArrayList<Disciplin> getDisciplineByTerm(Term term) {
        ArrayList<Disciplin> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct d.* from term t\n" +
                    "join term_discipline td on t.id = td.id_term\n" +
                    "join discipline d on d.id = td.id_discipline\n" +
                    "where td.id_term =" + term.getId());
            while (rs.next()) {
                Disciplin t = new Disciplin();
                t.setId((rs.getInt("id")));
                t.setName((rs.getString("name")));
                t.setStatus((rs.getByte("status")));
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
    public ArrayList<DisciplineMark> getDisciplineMarkbyTerm(Term term, String ids) {
        ArrayList<DisciplineMark> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct d.*, m.name as mark from term t\n" +
                    "join term_discipline td on t.id = td.id_term\n" +
                    "join student_termdiscipline_mark stm \n" +
                    "on td.id = stm.id_termDiscipline\n" +
                    "and stm.id_student = " + ids + "\n" +
                    "join discipline d on d.id = td.id_discipline\n" +
                    "join mark m on m.id = stm.id_mark\n" +
                    "where td.id_term = " + term.getId());
            while (rs.next()) {
                DisciplineMark t = new DisciplineMark();
                t.setId((rs.getInt("id")));
                t.setName((rs.getString("name")));
                t.setStatus((rs.getByte("status")));
                t.setMark((rs.getString("mark")));
                res.add(t);
            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }


}

