/**
 * COPYRIGHT (C) 2021 Group 4: David Hernandez, Jennifer Lewis, Seung Jung, Daniel O'Donnell. All Rights Reserved.
 * Group Project M04-A03
 *
 * @author Seung Jung
 * @version 1.01 2021-11-27
 */
package com.example.financeapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
//Stores data for users
public class User implements Serializable {


    //attributes and encapsulation with reference to columns for the table
    @Id
    @Column(name="userId")
    private String userId;
    @Column(name="userName")
    private String userName;
    @Column(name="userPw")
    private String userPw;
    @Column(name="userType")
    private String userType;

    //Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
