/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.Musculos;
import EderEsquivel.bison_system.repository.MusculosRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/musculos")
public class MusculosController {
    private final MusculosRepository muscRepository;

    public MusculosController(MusculosRepository muscRepository) {
        this.muscRepository = muscRepository;
    }
    
    @GetMapping
    public List<Musculos> listar() {
        return muscRepository.findAll();
    }
}
