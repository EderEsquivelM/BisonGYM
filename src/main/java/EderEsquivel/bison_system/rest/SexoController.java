/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.Sexo;
import EderEsquivel.bison_system.repository.SexoRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/sexo")
public class SexoController {
    private final SexoRepository sxRepository;

    public SexoController(SexoRepository sxRepository) {
        this.sxRepository = sxRepository;
    }
    
    @GetMapping
    public List<Sexo> listar() {
        return sxRepository.findAll();
    }
    
    
}
