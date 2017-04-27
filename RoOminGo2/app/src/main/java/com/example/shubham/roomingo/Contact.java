package com.example.shubham.roomingo;

/**
 * Created by Shubham on 16-04-2017.
 */
public class Contact {

    int id;
    String name, pass, mob;

    public void setId(int id) {
        this.id = id;

    }

    public int getId() {
        return this.id;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getMob() {
        return mob;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }



}