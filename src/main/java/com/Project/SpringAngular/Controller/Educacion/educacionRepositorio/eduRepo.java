/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Project.SpringAngular.Controller.Educacion.educacionRepositorio;

import com.Project.SpringAngular.Controller.Educacion.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santi
 */
@Repository
public interface eduRepo extends JpaRepository<Educacion, Long>{
}
