package com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.CourseBiDirectional;
import entity.StudentBiDirectional;

public class InsertBiDirectional {
    public static void main(String[] args) {
        CourseBiDirectional course = new CourseBiDirectional();
        course.setCourseName("New Course");

        StudentBiDirectional student1 = new StudentBiDirectional();
        student1.setStudentName("ABC 1");
        student1.setCourse(course);

        StudentBiDirectional student2 = new StudentBiDirectional();
        student2.setStudentName("ABC2");
        student2.setCourse(course);

        List<StudentBiDirectional> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        course.setStudents(students);

        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(StudentBiDirectional.class).addAnnotatedClass(CourseBiDirectional.class);

        Session openSession = configuration.buildSessionFactory().openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.persist(course);
        openSession.persist(student1);
        openSession.persist(student2);

        beginTransaction.commit();
        openSession.close();
    }
}
