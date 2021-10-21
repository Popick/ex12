package com.example.ex12;

public class student {
    private String fName, lName, dob, phone;

    public student(String fname, String lname, String dob, String phone) {
        this.phone = phone;
        this.dob = dob;
        this.lName = lname;
        this.fName = fname;
    }

    public String getFirstName() {
        return fName;
    }
    public String getLastName() {
        return lName;
    }
    public String getDateOfBirth()  {
        return dob;
    }
    public String getPhone() {
        return phone;
    }

}
