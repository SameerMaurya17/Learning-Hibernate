package com.deku;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LazingLoading_EagerLoading {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(Laptop.class)
                            .configure()
                            .buildSessionFactory();

        Session session = sf.openSession();

        // Lazing Loading is done by default for the Collection data types
        // Mainly 2 method are there Get VS Load both are Deprecated
        // There replacement are now .find() for get and getReference() using these both method together works are load

        // load method does the lazing loading it doesn't fire the query until we are using the data

        Laptop l1 = session.find(Laptop.class,1);
        Laptop l2 = session.getReference(Laptop.class,2); // will only fire the query when the l2 object is getting used


        System.out.println(l1);
        System.out.println(l2);

        session.close();
        sf.close();

    }

}
