package com.example.financeapp.service;

import com.example.financeapp.model.Investment;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface InvestmentService {
    List<Investment> getAllInvestments();
    void saveInvestment(Investment investment);
    Optional<Investment> getInvestmentById(String id);
    void deleteInvestmentById(String id);
    Page<Investment> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
