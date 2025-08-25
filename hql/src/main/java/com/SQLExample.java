package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        Session openSession = configuration.buildSessionFactory().openSession();
        Transaction beginTransaction = openSession.beginTransaction();

        String sql = "Select userName from user";

        NativeQuery nativeQuery = openSession.createNativeQuery(sql);
        List resultList = nativeQuery.getResultList();

        System.out.println(resultList);

        beginTransaction.commit();
        openSession.close();
    }
}
