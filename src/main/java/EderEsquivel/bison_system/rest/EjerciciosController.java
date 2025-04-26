/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.Ejercicios;
import EderEsquivel.bison_system.repository.EjerciciosRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/ejercicios")
public class EjerciciosController {
    private final EjerciciosRepository ejerciciosRep;

    public EjerciciosController(EjerciciosRepository ejerciciosRep) {
        this.ejerciciosRep = ejerciciosRep;
    }
    
    @GetMapping
    public List<Ejercicios> listar() {
        return ejerciciosRep.findAll();
    }
}
