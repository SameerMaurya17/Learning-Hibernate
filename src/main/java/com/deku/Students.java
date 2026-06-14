package com.deku;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  // These Annotations are important
public class Students {

    @Id
    private int rollNo;
    private String sName;
    private int sAge;

    public int getRollNo() {
        return rollNo;
    }

    public String getsName() {
        return sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    @Override
    public String toString() {
        return "Students{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}
