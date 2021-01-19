package com.example.Games.service;
import com.example.Games.model.Company;
import java.util.List;
/**
 *
 * @author Totko
 */
public interface CompanyService {
   
    List<Company> getAllCompanies(String keyword);
    
    void saveCompany(Company company);
    Company getCompanyById(long id);
    void deleteCompanyById(long id);
    
}
