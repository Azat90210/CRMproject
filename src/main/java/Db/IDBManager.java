package Db;

import entity.Student;

import java.util.ArrayList;

public interface IDBManager {
    ArrayList <Student> getAllStudent();
    void studentCreating(String lastName, String firstName, String groupName, String registrationDate);
}
