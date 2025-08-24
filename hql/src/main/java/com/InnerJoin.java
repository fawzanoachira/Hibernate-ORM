package com;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Person;

public class InnerJoin {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Person.class).addAnnotatedClass(Adhar.class);
        Session openSession = configuration.buildSessionFactory().openSession();
        Transaction beginTransaction = openSession.beginTransaction();

        String hql = "from Person";
    }
}
