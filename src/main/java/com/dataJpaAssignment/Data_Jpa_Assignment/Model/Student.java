package com.dataJpaAssignment.Data_Jpa_Assignment.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    public Student(){}
    public Student(long ID, String std_name, Character std_gender, String std_Branch, String std_Percentage, String std_Contact) {
        this.ID = ID;
        this.std_name = std_name;
        this.std_gender = std_gender;
        this.std_Branch = std_Branch;
        this.std_Percentage = std_Percentage;
        this.std_Contact = std_Contact;
    }
    public Student(String std_name, Character std_gender, String std_Branch, String std_Percentage, String std_Contact) {
        this.std_name = std_name;
        this.std_gender = std_gender;
        this.std_Branch = std_Branch;
        this.std_Percentage = std_Percentage;
        this.std_Contact = std_Contact;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public Character getStd_gender() {
        return std_gender;
    }

    public void setStd_gender(Character std_gender) {
        this.std_gender = std_gender;
    }

    public String getStd_Branch() {
        return std_Branch;
    }

    public void setStd_Branch(String std_Branch) {
        this.std_Branch = std_Branch;
    }

    public String getStd_Percentage() {
        return std_Percentage;
    }

    public void setStd_Percentage(String std_Percentage) {
        this.std_Percentage = std_Percentage;
    }

    public String getStd_Contact() {
        return std_Contact;
    }

    public void setStd_Contact(String std_Contact) {
        this.std_Contact = std_Contact;
    }

     String std_name;
    private Character std_gender;
    private String std_Branch;
    private String std_Percentage;
    private String std_Contact;
}
