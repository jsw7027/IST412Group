package com.example.financeapp.service;

import com.example.financeapp.model.Investment;
import com.example.financeapp.model.User;
import com.example.financeapp.repository.InvestmentRepository;
import com.example.financeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentImpt implements InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Override
    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    @Override
    public void saveInvestment(Investment investment) {
        this.investmentRepository.save(investment);
    }



    @Override
    public Optional<Investment> getInvestmentById(String id) {
        Optional<Investment> optional = investmentRepository.findById(id);
        return optional;
    }



    @Override
    public void deleteInvestmentById(String id) {
        this.investmentRepository.deleteById(id);
    }

    @Override
    public Page<Investment> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
        return this.investmentRepository.findAll(pageable);
    }
}
