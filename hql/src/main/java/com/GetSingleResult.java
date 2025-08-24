package com;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Person;

public class GetSingleResult {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Person.class);
        Session openSession = configuration.buildSessionFactory().openSession();
        Transaction beginTransaction = openSession.beginTransaction();

        String hql = "from Person where personName=:x";
        Query<Person> namedQuery = openSession.createQuery(hql, Person.class);
        namedQuery.setParameter("x", "fawzan");
        Person singleResult = (Person) namedQuery.getSingleResult();
        System.out.println(singleResult);

        beginTransaction.commit();
        openSession.close();
    }
}
