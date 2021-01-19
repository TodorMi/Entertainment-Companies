/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Games.service;

import com.example.Games.model.Company;
import com.example.Games.repository.CompanyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Totko
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;
     public List<Company> getAllCompanies(String keyword){
        if (keyword != null) {
            return companyRepository.search(keyword);
        }
        return companyRepository.findAll();
    }

    @Override
    public void saveCompany(Company company) {
        this.companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(long id) {
       Optional<Company> optional = companyRepository.findById(id);
       Company company = null;
       if (optional.isPresent()) {
			company = optional.get();
		} else {
			throw new RuntimeException(" Company not found for id :: " + id);
		}
		return company;
    }

    @Override
    public void deleteCompanyById(long id) {
        this.companyRepository.deleteById(id);
    }

  

   
} 

