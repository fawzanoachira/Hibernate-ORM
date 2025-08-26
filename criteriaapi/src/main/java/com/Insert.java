package com;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import entity.Student;

public class Insert {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setStudentName("ABC");

        Student student2 = new Student();
        student2.setStudentName("DEF");

        Configuration cfg = new Configuration();
        cfg.configure().addAnnotatedClass(Student.class);
        Session session = cfg.buildSessionFactory().openSession();
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        criteriaBuilder.createQuery(Student.class);
    }
}
