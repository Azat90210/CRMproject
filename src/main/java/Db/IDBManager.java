package Db;

import entity.Disciplin;
import entity.Student;

import java.util.ArrayList;

public interface IDBManager {
    ArrayList <Student> getAllStudent();
    ArrayList <Disciplin> getAllDisciplin();
    void studentCreating(String lastName, String firstName, String groupName, String registrationDate);
    void disciplinCreating(String disciplinName);
}


