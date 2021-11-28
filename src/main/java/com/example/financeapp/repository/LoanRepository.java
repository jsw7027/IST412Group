/**
 * COPYRIGHT (C) 2021 Group 4: David Hernandez, Jennifer Lewis, Seung Jung, Daniel O'Donnell. All Rights Reserved.
 * Group Project M04-A03
 *
 * @author David Hernandez
 * @version 1.01 2021-11-27
 */
package com.example.financeapp.repository;

import com.example.financeapp.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Interface that handles finding loan applications by id
public interface LoanRepository extends JpaRepository<LoanApplication, Long> {

    @Override
    Optional<LoanApplication> findById(Long id);

}
