package com.deku;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class AlienMain {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook air");
        l3.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Deku");
        a1.setTech("CSE");

        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Aryan Phuyal");
        a2.setTech("Python");

//        Alien a3 = new Alien();
//        a3.setAid(103);
//        a3.setAname("Pranav Lamba");
//        a3.setTech("AI");

//        a1.setLaptops(Arrays.asList(l1,l2));
//        a2.setLaptops(Arrays.asList(l2,l3));
//        a3.setLaptops(Arrays.asList(l1));

        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l3));

//        l1.setAliens(Arrays.asList(a1, a3));
//        l2.setAliens(Arrays.asList(a1, a2));
//        l3.setAliens(Arrays.asList(a2));

//        Configuration cfg = new Configuration();
//
//        cfg.addAnnotatedClass(Alien.class);
//        cfg.configure();
//
//        SessionFactory sf = cfg.buildSessionFactory();

        SessionFactory sf = new Configuration()
                                .addAnnotatedClass(Alien.class)
                                .addAnnotatedClass(Laptop.class)
                                .configure()
                                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
//        session.persist(a3);

        transaction.commit();

//        Alien a5 = session.find(Alien.class,101); // this will be a problem IF the mapping and cascade are not correct.
        // Data in not coming from DB it is coming from cache because it is in same session to use select query we need to ask data in different session

//        System.out.println(a2);

        session.close();

        Session session1 = sf.openSession();

        Alien a5 = session1.find(Alien.class,101); // ByDefault it does LazyFetch (Meaning it doesn't get the value for the Collection variable) but we can change it to Eager Fetch type
//        System.out.println(a5); // now we need the data for the Collection Variable(i.e Laptops in this case) so it will not do LazyFetch

        session1.close();

        sf.close();

    }

}
