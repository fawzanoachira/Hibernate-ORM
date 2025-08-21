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

        Course course1 = new Course();
        course1.setCourseName("CSE");

        Course course2 = new Course();
        course2.setCourseName("CSE/AI");

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        Student student1 = new Student();
        student1.setStudentName("ABC");

        Student student2 = new Student();
        student2.setStudentName("DEF");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        student1.setCourse(courses);
        student2.setCourse(courses);

        course1.setStudents(students);
        course2.setStudents(students);

        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);
        Session openSession = configuration.buildSessionFactory().openSession();
        Transaction beginTransaction = openSession.beginTransaction();

        openSession.persist(course1);
        openSession.persist(course2);

        openSession.persist(student1);
        openSession.persist(student2);

        beginTransaction.commit();
        openSession.close();
    }
}
