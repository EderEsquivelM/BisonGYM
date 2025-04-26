/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.DetallesEntrenamiento;
import EderEsquivel.bison_system.repository.DetallesEntrenamientoRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/detalles_entrenamiento")
public class DetallesEntrenamientoController {
    private final DetallesEntrenamientoRepository deRep;

    public DetallesEntrenamientoController(DetallesEntrenamientoRepository deRep) {
        this.deRep = deRep;
    }
    
    @GetMapping
    public List<DetallesEntrenamiento> listar() {
        return deRep.findAll();
    }
    
    
}
