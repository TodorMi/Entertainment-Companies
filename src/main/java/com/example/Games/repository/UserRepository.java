/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Games.repository;

import com.example.Games.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Totko
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByName(String name);
}
