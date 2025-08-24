package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Person;

public class GetResultList {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Person.class);
        Session openSession = configuration.buildSessionFactory().openSession();
        Transaction beginTransaction = openSession.beginTransaction();

        String hql = "from Person";
        Query<Person> namedQuery = openSession.createQuery(hql, Person.class);
        List<Person> resultList = namedQuery.getResultList();
        for (Person person : resultList) {
            System.out.println(person);
        }
        System.out.println("\n**************************\n");
        namedQuery.getResultStream().forEach((x) -> System.out.println(x));

        beginTransaction.commit();
        openSession.close();
    }
}
