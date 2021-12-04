package com.example.financeapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="investment")
//Stores data for investor's money
public class Investment implements Serializable {

    //attributes and encapsulation with reference to columns for the table
    @Id
    @Column(name = "investorId")
    private String investorId;
    @Column(name = "amount")
    private String amount;

    //Getters and Setters
    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
