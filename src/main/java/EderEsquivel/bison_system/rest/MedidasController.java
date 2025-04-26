/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.Medidas;
import EderEsquivel.bison_system.repository.MedidasRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/medidas")
public class MedidasController {
    private final MedidasRepository medidasRep;

    public MedidasController(MedidasRepository medidasRep) {
        this.medidasRep = medidasRep;
    }
    
    @GetMapping
    public List<Medidas> listar() {
        return medidasRep.findAll();
    }
}
