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

    Term getTermId(String ids);
    ArrayList<Term> getTermbyId(String idTerm);
    ArrayList <TermDiscipline> getDisciplineByTerm(Term term, String idTerm);

    ArrayList<Role> getAllRole();
    boolean isLogin (String login, String password, String idRole);

    UserRole getUser(String login, String roleId);
    void userCreating(String login, String password, String lastName, String firstName, int idRole, int idUser);
    void addUser(String login, String password, String lastName, String firstName);
    void addIds(String roleId, String userId);

    User getUserId(String login);
}

















