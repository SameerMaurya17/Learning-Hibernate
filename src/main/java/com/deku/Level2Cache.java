package com.deku;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Level2Cache {

    public static void main(String[] args) {

        // Level 1 Cache: this memory is on session based meaning when we fetch data from DB in that session we don't need to fire another query for that data cause it is already present in cache for that session
        // Level 2 Cache: if that data in already present is any of session present then we don't need to fire another query for that data cause it is already stored inside cache
        // For L2 Cache we do need to add some plugins and add some new properties in our hibernate.cfg.xml file (and we are using EhCache plugin)
        // and also need to use the @Cacheable annotation

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Laptop l1 = session.find(Laptop.class,1);
        System.out.println(l1);

//        Laptop l2 = session.find(Laptop.class,2); // This will not fetch the query again because this session already got the data for it and it is stored cache L1
//        System.out.println(l2);

        session.close();

        Session session1 = sf.openSession();

        Laptop l2 = session1.find(Laptop.class,1);
        System.out.println(l2);

        session1.close();

        sf.close();

    }

}
