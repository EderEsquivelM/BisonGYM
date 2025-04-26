/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.Dificultades;
import EderEsquivel.bison_system.model.InicioSesion;
import EderEsquivel.bison_system.repository.DificultadesRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/dificultades")
public class DificultadesController {
    private final DificultadesRepository dfRepository;

    public DificultadesController(DificultadesRepository dfRepository) {
        this.dfRepository = dfRepository;
    }
    
    @GetMapping
    public List<Dificultades> listar() {
        return dfRepository.findAll();
    }
}
