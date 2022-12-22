package Db;

import entity.*;

import java.util.ArrayList;

public interface IDBManager {
    ArrayList<Student> getAllStudent();

    ArrayList<Disciplin> getAllDisciplin();



    void studentCreating(String lastName, String firstName, String groupName, String registrationDate);

    void disciplinCreating(String disciplinName);

    void deleteStudent(String ids);

    void deleteDisciplin(String ids);

    void newsCreating(String newsName, String news);

    ArrayList<News> getAllNews();

    void deleteNews(String ids);

    Student getStudentById(String ids);

    ArrayList<DisciplineMark> getDisciplineMarkbyTerm(Term term, String ids);
    ArrayList<Term> getTermbyIdStudent(String ids);

}


