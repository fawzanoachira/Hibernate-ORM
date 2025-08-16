package com;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Student;

public class Fetch {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);

        Session openSession = configuration.buildSessionFactory().openSession();
        Transaction beginTransaction = openSession.beginTransaction();

        Course course = openSession.find(Course.class, 1);
        System.out.println(course.getCourseName());

        System.out.println(course.getStudents().getFirst().getStudentName());

        beginTransaction.commit();
        openSession.close();
    }
}
