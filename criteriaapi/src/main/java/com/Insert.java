package com;

import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import entity.Student;

public class Insert {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure().addAnnotatedClass(Student.class);
        Session session = cfg.buildSessionFactory().openSession();
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        JpaCriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        JpaRoot<Student> from = query.from(Student.class);
        query.select(from);

        Query<Student> query2 = session.createQuery(query);
        Stream<Student> resultStream = query2.getResultStream();
        resultStream.forEach((x) -> System.out.println(x));

        session.close();
    }
}
