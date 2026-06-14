package com.deku;

import jakarta.persistence.*;

import java.util.List;

//@Embeddable // It is used when we want to Embed this inside another table (not creating a new table)
// Its fields are merged into another entity
@Entity
@Cacheable
public class Laptop {
    @Id
    private int lid;
    private String brand;
    private String model;
    private int ram;
//    @ManyToOne // This will make it so that it doesn't create a 3rd table (if it is already not created by Alien so we have to let Alien know that it will be mapped by Laptop variable Alien so don't create a new table let this variable handle it)
//    private Alien alien;

//    @ManyToMany(mappedBy = "laptops") // This is to make sure that it doesn't create another table (Laptop_Alien) and let the Alien class variable laptops handle the mapping and only create one single table Alien_Laptop
//    private List<Alien> aliens;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public String getModel() {
        return model;
    }

//    public List<Alien> getAliens() {
//        return aliens;
//    }
//
//    public void setAliens(List<Alien> aliens) {
//        this.aliens = aliens;
//    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
