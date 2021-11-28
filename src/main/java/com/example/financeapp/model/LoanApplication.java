/**
 * COPYRIGHT (C) 2021 Group 4: David Hernandez, Jennifer Lewis, Seung Jung, Daniel O'Donnell. All Rights Reserved.
 * Group Project M04-A03
 *
 * @author Daniel O'Donnell
 * @version 1.01 2021-11-27
 */
package com.example.financeapp.model;


import javax.persistence.*;

@Entity
@Table(name="loanApplication")
//Employee class handles creating a table and columns to manage data for loan applications
public class LoanApplication {

    //attributes and encapsulation with reference to columns for the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="loanType")
    private String loanType;
    @Column(name="customerId")
    private String customerId;
    @Column(name="customerCredit")
    private String customerCredit;
    @Column(name="amount")
    private int loanAmount;
    @Column(name="status")
    private String status;

    //Getters and Setters
    public String getCustomerCredit() {
        return customerCredit;
    }

    public void setCustomerCredit(String customerCredit) {
        this.customerCredit = customerCredit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    //Get status of loan application
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status;}

    //Retrieves a loan application by type
    public void retrieveLoanAppTye()
    {
        if (loanType == "CarLoanApplication")
        {
            //debug
            System.out.println("CarLoanApplication was retrieved");
        }
        if (loanType == "PersonalLoanApplication")
        {
            //debug
            System.out.println("PersonalLoanApplication was retrieved");
        }
        if (loanType == "RenovationLoanApplication")
        {
            //debug
            System.out.println("RenovationLoanApplication was retrieved");
        }
        if (loanType == "ProjectLoanApplication")
        {
            //debug
            System.out.println("ProjectLoanApplication was retrieved");
        }
        if (loanType == "BusinessLoanApplication")
        {
            //debug
            System.out.println("BusinessLoanApplication was retrieved");
        }
    }
}
