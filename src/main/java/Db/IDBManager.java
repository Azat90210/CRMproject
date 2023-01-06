package Db;

import entity.*;

import java.util.ArrayList;

public interface IDBManager {
    ArrayList<Student> getAllStudent();

    ArrayList<Disciplin> getAllDisciplin();
    ArrayList<News> getAllNews();
    ArrayList<Term> getAllTerm();

    void studentCreating(String lastName, String firstName, String groupName, String registrationDate);

    void disciplinCreating(String disciplinName);

    void deleteStudent(String ids);

    void deleteDisciplin(String ids);
    void deleteNews(String ids);

    void newsCreating(String newsName, String news);

    Student getStudentById(String ids);

    ArrayList<DisciplineMark> getDisciplineMarkbyTerm(Term term, String ids);
    ArrayList<Term> getTermbyIdStudent(String ids);
    ArrayList<Disciplin> getDisciplineByTerm(Term term);

    ArrayList<Role> getAllRole();
    boolean isLogin (String login, String password, String idRole);

    UserRole getUser(String login);

}

















