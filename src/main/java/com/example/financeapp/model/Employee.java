/**
 * COPYRIGHT (C) 2021 Group 4: David Hernandez, Jennifer Lewis, Seung Jung, Daniel O'Donnell. All Rights Reserved.
 * Group Project M04-A03
 *
 * @author Daniel O'Donnell
 * @version 1.01 2021-11-27
 */
package com.example.financeapp.model;

//Employee class handles data for employees
public class Employee {

    //Attributes and Encapsulation
private String firstName;
private String lastName;
private String streetAddress;
private String city;
private String state;
private int zipCode;
private int phoneNumber;

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
