package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Adhaar;
import entity.Person;

public class InnerJoin {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Person.class).addAnnotatedClass(Adhaar.class);
        Session openSession = configuration.buildSessionFactory().openSession();
        Transaction beginTransaction = openSession.beginTransaction();

        String hql = "FROM Adhaar a INNER JOIN a.person p";
        Query<Adhaar> query = openSession.createQuery(hql, Adhaar.class);
        List<Adhaar> resultList = query.getResultList();

        resultList.stream().forEach((x) -> System.out.println(x));

        beginTransaction.commit();
        openSession.close();
    }
}
