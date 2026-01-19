package com.example.cruddemo.entity.DAO;

import com.example.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
