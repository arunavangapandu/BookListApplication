package model;

/**
 * Created by aruna on 11/29/17.
 */

public class NestedUserAddress {

    private String name;

    private int age;

    private String email;

    private boolean isDeveloper;

    private UserAddress userAddress;


    public NestedUserAddress(String name, int age, String email, boolean isDeveloper, UserAddress userAddress) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isDeveloper = isDeveloper;
        this.userAddress = userAddress;
    }
}
