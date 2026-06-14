package com.deku;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class LaptopMain {

    public static void main(String[] args) {

//        Laptop l1 = new Laptop();
//        l1.setLid(1);
//        l1.setBrand("Asus");
//        l1.setModel("Rog");
//        l1.setRam(16);
//
//        Laptop l2 = new Laptop();
//        l2.setLid(2);
//        l2.setBrand("Dell");
//        l2.setModel("XPS");
//        l2.setRam(32);
//
//        Laptop l3 = new Laptop();
//        l3.setLid(3);
//        l3.setBrand("Apple");
//        l3.setModel("Macbook air");
//        l3.setRam(8);
//
//        Laptop l4 = new Laptop();
//        l4.setLid(4);
//        l4.setBrand("Asus");
//        l4.setModel("Gaming");
//        l4.setRam(32);

        SessionFactory sf = new Configuration()
                                .addAnnotatedClass(Laptop.class)
                                .configure()
                                .buildSessionFactory();

        Session session = sf.openSession();

//        Transaction transaction = session.beginTransaction();
//
//        session.persist(l1);
//        session.persist(l2);
//        session.persist(l3);
//        session.persist(l4);
//
//        transaction.commit();

        // select * from laptop where ram = 32 -> SQL
        // from Laptop where ram = 32 -> HQL (Hibernate Query Language)

        String brand = "Asus";

//        Query query = session.createQuery("from Laptop where ram = 32", Laptop.class);
//        Query query = session.createQuery("from Laptop where brand like 'Asus'", Laptop.class); // Here we are using like because we are working with text/string
//        Query query = session.createQuery("from Laptop where brand like ?1", Laptop.class); // we are using (?) to enter the value and also write it along with a Number to help set Parameter later
//        Query query = session.createQuery("select model from Laptop where brand like ?1", String.class); // Now we are only asking for model which is a type of string it will fetch us a List of String
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1", Object[].class); // Now we are only asking for more than 2 data types so it will give us an Array of Object (Object[])
        query.setParameter(1,brand); // to set Parameter in above query
        List<Object[]> laptops = query.getResultList(); // Now we are getting A Array of Objects
//        List<String> laptops = query.getResultList(); // Now we are getting A List of String
//        List<Laptop> laptops = query.getResultList();

//        Laptop l1 = session.find(Laptop.class,1);

//        System.out.println(l1);
//        System.out.println(laptops);

        for(Object[] data : laptops){
            System.out.println(data[0] + " " + data[1]);
        }

        session.close();
        sf.close();

    }

}
