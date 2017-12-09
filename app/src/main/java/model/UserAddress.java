package model;

/**
 * Created by aruna on 11/29/17.
 */

public class UserAddress {

    private String country;

    private String city;

    private String StreetName;

    private  String houseNumber;

    private int zipCode;

    public UserAddress(String country, String city, String streetName, String houseNumber, int zipCode) {
        this.country = country;
        this.city = city;
        StreetName = streetName;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }
}
