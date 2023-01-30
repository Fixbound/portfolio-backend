/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Project.SpringAngular.Controller.Proyectos.proyectoExepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author santi
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProyResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProyResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
