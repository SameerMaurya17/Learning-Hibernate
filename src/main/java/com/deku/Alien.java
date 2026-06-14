package com.deku;

import jakarta.persistence.*;

import java.util.List;

// If you don't want the table name as Alien (as we know Java follows camelCasing but in DB we follow snake_casing)
// we can either change the Entity name or me can change the Table name
// So Basically we have 3 names : the Class name , Table name and the Entity name (and we get the Table name form the Entity name by default)

//@Entity(name = "alien_table") // Changes the Entity name
@Entity
//@Table(name = "alien_table") // change the table name
public class Alien {

    @Id
    private  int aid;
//    @Column(name = "alien_name") // To change the column name
    private  String aname;
//    @Column(name = "alien_tech")
//    @Transient // using this annotation this will not create a column and don't store data in DB for that variable (use for when we need to perform some processing only in object but doesn't want it to store in DB)
    // So use Transient when you don't to create column for that variable in the database
    private  String tech;
//    @OneToOne // Will Map one Table to Another table in One to One mapping order (so now in DB table laptop will contain the primary key of the Laptop Table/class (Which is a Foreign Key)  in DB)
//    private Laptop laptop;

    // For one to many mapping
//    @OneToMany(mappedBy = "alien") // this will make it so that it doesn't create a new table and let the alien variable inside Laptop class handle the mapping
//    private List<Laptop> laptops;

//    @ManyToMany
//    private List<Laptop> laptops;

  @OneToMany(fetch = FetchType.EAGER) // ByDefault the FetchType is Lazy meaning when we have a collection in our variable it won't get values for it until or unless we are gonna use ir or need them
    private List<Laptop> laptops;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}
