/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.SeriesEntrenamiento;
import EderEsquivel.bison_system.repository.SeriesEntrenamientoRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/series_entrenamiento")
public class SeriesEntrenamientoContoller {
    private final SeriesEntrenamientoRepository seRepo;

    public SeriesEntrenamientoContoller(SeriesEntrenamientoRepository seRepo) {
        this.seRepo = seRepo;
    }
    
    @GetMapping
    public List<SeriesEntrenamiento> listar() {
        return seRepo.findAll();
    }
}
