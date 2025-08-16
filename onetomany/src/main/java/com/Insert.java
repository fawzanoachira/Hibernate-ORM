package com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Student;

public class Insert {
    public static void main(String[] args) {
        Course course = new Course();
        course.setCourseName("CSE");

        Student student1 = new Student();
        student1.setStudentName("ABC1");
        Student student2 = new Student();
        student2.setStudentName("ABC2");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        course.setStudents(students);

        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);

        Session openSession = configuration.buildSessionFactory().openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.persist(course);
        openSession.persist(student1);
        openSession.persist(student2);

        beginTransaction.commit();
        openSession.close();
    }
}
