package com.example.bterdem;
import java.util.ArrayList;
public class Person {
    private String userNname;
    private String password;


    public Person(String userNname, String password){
        this.userNname = userNname;
        this.password = password;

    }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public  String getUserNname(){ return userNname;}

    public void  getUserNname(String userNname) {
        this.userNname = userNname;
    }

    public static ArrayList<Person> getPersonsList(){
        ArrayList persons = new ArrayList();
        persons.add(new Person("erdem1", "erdem123"));
        persons.add(new Person("erdem2", "erdem123"));
        persons.add(new Person("erdem3", "erdem123"));
        persons.add(new Person("erdem4", "erdem123"));
        return persons;
    }
}
