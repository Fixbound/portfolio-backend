/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Project.SpringAngular.Controller.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author santi
 */
public interface AuthRepo extends JpaRepository<Auth, String>{
    
}
