/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.InicioSesion;
import EderEsquivel.bison_system.model.ZonasAnatomicas;
import EderEsquivel.bison_system.repository.ZonasAnatomicasRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/zonas_anatomicas")
public class ZonasAnatomicasController {
    private final ZonasAnatomicasRepository zaRepository ;
    
    public ZonasAnatomicasController(ZonasAnatomicasRepository zaRepository){
        this.zaRepository=zaRepository;
    }
    
     @GetMapping
    public List<ZonasAnatomicas> listar() {
        return zaRepository.findAll();
    }
}
