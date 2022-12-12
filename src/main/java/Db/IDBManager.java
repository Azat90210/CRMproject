package Db;

import entity.Disciplin;
import entity.Student;
import entity.Term;

import java.util.ArrayList;

public interface IDBManager {
    ArrayList <Student> getAllStudent();
    ArrayList <Disciplin> getAllDisciplin();
    ArrayList <Term> getAllTerm();
    void studentCreating(String lastName, String firstName, String groupName, String registrationDate);
    void disciplinCreating(String disciplinName);

    void deleteStudent(String ids);
    void deleteDisciplin(String ids);
}


