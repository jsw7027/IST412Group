package com.example.financeapp.repository;

import com.example.financeapp.model.Investment;
import com.example.financeapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvestmentRepository extends JpaRepository<Investment, String> {

    @Override
    Optional<Investment> findById(String id);
}
