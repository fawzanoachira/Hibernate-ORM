package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Adhaar;
import entity.Person;

public class Fetch {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Adhaar.class).addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();

        Adhaar adhaar = openSession.find(Adhaar.class, 1);
        System.out.println(adhaar.getAdhaarId());
        System.out.println(adhaar.getAdhaarNo());
        System.out.println(adhaar.getPerson().getPersonName());
        System.out.println(adhaar.getPerson().getPersonId());
        
        beginTransaction.commit();
        openSession.close();
        sessionFactory.close();
    }
}
