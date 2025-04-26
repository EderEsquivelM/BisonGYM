/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.Entrenamientos;
import EderEsquivel.bison_system.repository.EntrenamientosRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/entrenamientos")
public class EntrenamientosController {
    private final EntrenamientosRepository entrenamientosRep;

    public EntrenamientosController(EntrenamientosRepository entrenamientosRep) {
        this.entrenamientosRep = entrenamientosRep;
    }
    
    @GetMapping
    public List<Entrenamientos> listar() {
        return entrenamientosRep.findAll();
    }
}
