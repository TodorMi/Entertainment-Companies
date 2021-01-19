/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Games.service;

import com.example.Games.model.User;
import com.example.Games.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Totko
 */
public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
