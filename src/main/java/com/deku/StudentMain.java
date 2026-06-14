package com.deku;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentMain {

    // Hibernate works by creating a configuration, building a session factory, opening a session, beginning a transaction, persisting the entity, and committing the transaction.
    public static void main(String[] args) {

        Students s1 = new Students();
        Students s2 = new Students();

        s1.setRollNo(4);
        s1.setsName("Aryan Phuyal");
        s1.setsAge(20);

        // Create object → Configure Hibernate → Open Session → Begin Transaction → Persist → Commit
        // Configuration -> SessionFactory -> Open a Session -> Begin a Transaction -> persist (save method) -> commit the Transaction
//        Configuration cfg = new Configuration(); // make sure to use Configuration class form org.hibernate

//        cfg.addAnnotatedClass(com.deku.Students.class);
//        cfg.addAnnotatedClass(Students.class);
        /*
        Tells Hibernate: “This class is mapped to a database table.”
        Hibernate reads annotations like: @Entity,@Id,@Column
         */

//        cfg.configure(); // this method loads the XML (Note :- XML files are in resources folder)

//        SessionFactory sf = cfg.buildSessionFactory();
        // we can also perform above 4 steps into one statement to set SessionFactory object
        SessionFactory sf = new Configuration()
                                .addAnnotatedClass(Students.class)
                                .configure()
                                .buildSessionFactory(); // all the above steps into one line

        Session session = sf.openSession();

        Transaction  transaction = session.beginTransaction(); // Transaction only need when we need to add ,create or update some data into a database (not used when fetching data)

//        session.persist(s1); // the persist method was called save before version 7 (used to save data into a database)

//        s2 = session.load(Students.class, 1);// it is also Deprecated
//        s2 = session.get(Students.class, 1);// Deprecated in 7.1.0
//        s2 = session.find(Students.class,10); // use to fetch data from database (first parameter is for the return type and the 2nd is for the telling the primary key value to fetch that data from)
        // NOTE :- But be Careful as if it doesn't find any data then it will return null now if you get object as a null and if you try to perform operation on that object it will give an error so make sure to use some Checks or exceptions

        // For Updating some values or save if that values is not present inside the database
//        session.merge(s1); // For saving or update the values

        // For Deleting
        session.remove(s1); // Removes the data from the database

        transaction.commit();

        System.out.println(s2);

        session.close();
        sf.close();

    }
}