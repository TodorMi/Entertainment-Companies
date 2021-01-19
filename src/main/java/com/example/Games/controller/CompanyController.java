/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Games.controller;

import com.example.Games.model.Company;
import com.example.Games.service.CompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Totko
 */
@Controller
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;
    
    @GetMapping("/login")
	public String login() {
		return "login";
	}
		        
    @GetMapping("/")
   public String viewHomePage(Model model, @Param("keyword") String keyword) {
       List<Company> listCompanies = companyService.getAllCompanies(keyword);
       model.addAttribute("listCompanies", listCompanies );
       model.addAttribute("keyword", keyword);
       
       return "index";
	}
   
   @GetMapping("/showNewCompany")
    public String showNewCompany(Model model){
        Company company = new Company();
        model.addAttribute("company", company);
        return "new_company";
    }
    
    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company){
        companyService.saveCompany(company);
        return "redirect:/";
    }
    
    @GetMapping("/formEdit/{id}")
	public String formEdit(@PathVariable ( value = "id") long id, Model model) {
		
		Company company = companyService.getCompanyById(id);
		model.addAttribute("company", company);
		return "edit_company";
	}
        
        @GetMapping("/deleteCompany/{id}")
	public String deleteCompany(@PathVariable ( value = "id") long id, Model model) {
		
		this.companyService.deleteCompanyById(id);
		return "redirect:/";
	}
    
}
