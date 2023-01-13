package Db;

import constants.Conections;
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
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
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
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `new` (`name`, `text`,`status`) " +
                    "VALUES ('" + newsName + "','" + news + "', '1')");
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
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
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
    public void deleteNews(String ids) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `new` SET `status` = '0' WHERE (`id` in(" + ids + "));");
            stmt.execute("DELETE from `new` WHERE (`id` in(" + ids + "));");
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
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
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
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `group`, `status`, `data_enter`) " +
                    "VALUES ('" + lastName + "', '" + firstName + "', '" + groupName + "', '1',  '" + registrationDate + "')");
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
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `discipline` (`name`, `status`) " +
                    "VALUES ('" + disciplinName + "', '1')");
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
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` in(" + ids + "));");
            stmt.execute("DELETE from `student` WHERE (`id` in(" + ids + "));");
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
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` in(" + ids + "));");
            stmt.execute("DELETE from `discipline` WHERE (`id` in(" + ids + "));");
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
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `student` where `status` = 1 and `id` = " + ids);
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
    public ArrayList<Term> getAllTerm() {
        ArrayList<Term> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct t.* from term t join term_discipline td on t.id = td.id_term");
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
    public ArrayList<Term> getTermbyIdStudent(String ids) {
        ArrayList<Term> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
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
    public Term getTermId(String ids) {
        Term s = new Term();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `term` where `status` = 1 and `id` = " + ids);
            while (rs.next()) {
                s.setId((rs.getInt("id")));
                s.setName((rs.getString("name")));

            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    @Override
    public ArrayList<Term> getTermbyId(String idTerm) {
        ArrayList<Term> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct t.* from term t\n" +
                    "join term_discipline td on t.id = td.id_term;");
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
    public ArrayList<TermDiscipline> getDisciplineByTerm(Term term, String idTerm) {
        ArrayList<TermDiscipline> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct d.name as disciplineName from term_discipline td\n" +
                    "join term t on td.id_term = t.id\n" +
                    "join discipline d on td.id_discipline = d.id\n" +
                    "where td.id_term = " + term.getId());
            while (rs.next()) {
                TermDiscipline t = new TermDiscipline();
                t.setDisciplineName((rs.getString("disciplineName")));
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
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
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

    @Override
    public ArrayList<Role> getAllRole() {
        ArrayList<Role> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from role where status = 1; ");
            while (rs.next()) {
                Role t = new Role();
                t.setId((rs.getInt("id")));
                t.setName((rs.getString("name")));
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
    public boolean isLogin(String login, String password, String idRole) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user u \n" +
                    "join user_role ur on u.id = ur.id_user\n" +
                    "where login = '" + login + "' and password = '" + password + "' and ur.id_role = '" + idRole + "';");
            while (rs.next()) {
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public UserRole getUser(String login, String roleId) {
        UserRole res = new UserRole();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select u.id id_us, firstName, lastName, r.id id_r, r.name from user u \n" +
                    "join user_role ur on u.id = ur.id_user\n" +
                    "join role r on r.id = ur.id_role\n" +
                    "where login = '" + login + "'and r.id = '" + roleId + "';");
            while (rs.next()) {

                res.setIdUser((rs.getInt("id_us")));
                res.setFirstName((rs.getString("firstName")));
                res.setLastName((rs.getString("lastName")));
                res.setIdRole((rs.getInt("id_r")));
                res.setName((rs.getString("name")));
            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public void userCreating(String login, String password, String lastName, String firstName, int idRole, int idUser) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `user` (`login`, `password`, `firstName`, `lastName`, `status`) " +
                    "VALUES ('" + login + "', '" + password + "', '" + firstName + "', '" + lastName + "', '1');" +
                    "INSERT INTO `crm_student_4`.`user_role` (`id_user`, `id_role`) VALUES ('" + idUser + "', '" + idRole + "');");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void addUser(String login, String password, String lastName, String firstName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `user` (`login`, `password`, `firstName`, `lastName`, `status`) " +
                    "VALUES ('" + login + "', '" + password + "', '" + firstName + "', '" + lastName + "', '1');");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void addIds(String roleId, String userId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `crm_student_4`.`user_role` (`id_user`, `id_role`) VALUES ('" + userId + "', '" + roleId + "');");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Override
    public User getUserId(String login) {
        User res = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id , login from user \n" +
                                      "where login = '" + login + "';");
            while (rs.next()) {

                res.setId((rs.getInt("id")));
                res.setLogin((rs.getString("login")));

            }
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    @Override
    public ArrayList<User> getLogins() {
        ArrayList<User> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    Conections.CONECTIONS_URL, Conections.CONECTIONS_USER, Conections.CONECTIONS_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select `login` from `user`");
            while (rs.next()) {
                User t = new User();
                t.setLogin((rs.getString("login")));
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















