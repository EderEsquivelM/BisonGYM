/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.model.SeriesEntrenamiento;
import EderEsquivel.bison_system.repository.SeriesEntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edere
 * 
 */

@Service
public class SeriesEntrenamientoServices {
    @Autowired
    private SeriesEntrenamientoRepository seR;

    public SeriesEntrenamientoServices(SeriesEntrenamientoRepository seR) {
        this.seR = seR;
    }
    
    public void nuevaSerie(SeriesEntrenamiento se){
            seR.save(se); 
    }
    
    
}
