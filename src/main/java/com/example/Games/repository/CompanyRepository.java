/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Games.model.Company;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Totko
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
    
   @Query("SELECT c FROM Company c  WHERE c.name LIKE %?1%"
            + " OR c.founder LIKE %?1%"
            + " OR c.founded LIKE %?1%" 
            + " OR c.headquarters LIKE %?1%")
     public List<Company> search(String keyword);
}
