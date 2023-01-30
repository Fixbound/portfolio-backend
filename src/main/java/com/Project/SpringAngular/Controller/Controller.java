/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Project.SpringAngular.Controller;

import com.Project.SpringAngular.Controller.Auth.Auth;
import com.Project.SpringAngular.Controller.Auth.AuthExeptions;
import com.Project.SpringAngular.Controller.Auth.AuthRepo;
import com.Project.SpringAngular.Controller.Educacion.EduExepciones.ResourceNotFoundException;
import com.Project.SpringAngular.Controller.Educacion.Educacion;
import com.Project.SpringAngular.Controller.Educacion.educacionRepositorio.eduRepo;
import com.Project.SpringAngular.Controller.Proyectos.Proyecto;
import com.Project.SpringAngular.Controller.Proyectos.proyectoRepositorio.ProyectoRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://hosting-angular-d2d74.firebaseapp.com")
public class Controller {

    @Autowired
    private eduRepo edu;

    @GetMapping("/educacion")
    public List<Educacion> listarEducacion() {
        return edu.findAll();
    }

    @Autowired
    private ProyectoRepo proy;

    @GetMapping("/proyectos")
    public List<Proyecto> listarProyectos() {
        return proy.findAll();
    }

    @GetMapping("/")
    public String main() {
        return "the api is in /api/";
    }

    @PostMapping("/educacion")
    public Educacion guardarEmpleado(@RequestBody Educacion input) {
        return edu.save(input);
    }

    @GetMapping("/educacion/{id}")
    public ResponseEntity<Educacion> getPortId(@PathVariable long id) {
        Educacion educacion = edu.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Existe"));
        return ResponseEntity.ok(educacion);
    }

    @DeleteMapping("/educacion/{id}")
    public ResponseEntity<Map<String, Boolean>> borrarEdu(@PathVariable long id) {
        Educacion educacion = edu.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Existe"));
        edu.delete(educacion);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

     @PutMapping("/educacion/{id}")
    public ResponseEntity<Educacion> actualizaEducacion(@PathVariable long id, @RequestBody Educacion detallesEducacion) {
        Educacion educacion = edu.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Existe"));

        educacion.setName(detallesEducacion.getName());
        educacion.setImg(detallesEducacion.getImg());
        educacion.setYear(detallesEducacion.getYear());
        educacion.setDescription(detallesEducacion.getDescription());

        Educacion eduActualizado = edu.save(educacion);
        return ResponseEntity.ok(eduActualizado);

    }
    
    @PostMapping("/proyectos")
    public Proyecto guardarProyecto(@RequestBody Proyecto input) {
        return proy.save(input);
    }

    @GetMapping("/proyectos/{id}")
    public ResponseEntity<Proyecto> getProyId(@PathVariable long id) {
        Proyecto proyecto = proy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Existe"));
        return ResponseEntity.ok(proyecto);
    }

    @DeleteMapping("/proyectos/{id}")
    public ResponseEntity<Map<String, Boolean>> borrarProy(@PathVariable long id) {
        Proyecto proyecto = proy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Existe"));
        proy.delete(proyecto);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/proyectos/{id}")
    public ResponseEntity<Proyecto> actualizadProyectyo(@PathVariable long id, @RequestBody Proyecto detallesProyecto) {
        Proyecto proyecto = proy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Existe"));

        proyecto.setName(detallesProyecto.getName());
        proyecto.setLink(detallesProyecto.getLink());
        proyecto.setDescription(detallesProyecto.getDescription());

        Proyecto proyectoActualizado = proy.save(proyecto);
        return ResponseEntity.ok(proyectoActualizado);

    }

    @Autowired
    private AuthRepo authRepo;

    @GetMapping("/login/{id}")
    public ResponseEntity<Auth> getUser(@PathVariable String id) {
        Auth auth = authRepo.findById(id)
                .orElseThrow(() -> new AuthExeptions("No Existe"));
        return ResponseEntity.ok(auth);
    }

}
