package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Adhaar;
import entity.Person;

public class Insert {
    public static void main(String[] args) {

        Person person = new Person();
        person.setPersonName("fawzan");

        Adhaar adhaar = new Adhaar();
        adhaar.setAdhaarNo(234567);
        adhaar.setPerson(person);

        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Adhaar.class).addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();

        openSession.persist(person);
        openSession.persist(adhaar);

        beginTransaction.commit();
        openSession.close();
        sessionFactory.close();
    }
}
