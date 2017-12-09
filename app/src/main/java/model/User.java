package model;

/**
 * Created by aruna on 11/23/17.
 */

public class User {

    String name;

    int age;

    String email;

    boolean isDeveloper;

    public User(String name, int age, String email, boolean isDeveloper) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isDeveloper = isDeveloper;
    }
}
