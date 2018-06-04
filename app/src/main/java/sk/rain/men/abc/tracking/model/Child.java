package sk.rain.men.abc.tracking.model;

import com.orm.SugarRecord;



/**
 * Created by mhorvath on 14.02.2018.
 */

public class Child extends SugarRecord {

    private String name;
    private String surname;
    private int age;

    public Child() {

    }

    public Child(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
