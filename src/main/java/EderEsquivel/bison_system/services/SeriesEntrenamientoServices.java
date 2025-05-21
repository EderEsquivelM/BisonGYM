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
 *Servicios para la gestion de las series de cada ejercicio en un entrenamiento.
 * 
 * @author edere
 * 
 */

@Service
public class SeriesEntrenamientoServices {
    @Autowired
    private SeriesEntrenamientoRepository seR;
    
    /**
     * Constructor para inyección de dependencias.
     * 
     * @param seR Repositorio de SeriesEntrenamiento 
     * {@link SeriesEntrenamientoRepository} .
     */
    public SeriesEntrenamientoServices(SeriesEntrenamientoRepository seR) {
        this.seR = seR;
    }
    
    /**
     * Guarda una nueva serie de entrenamiento. 
     * 
     * @param se Obeto{@link SeriesEntrenamiento} del cual se va a guardar.
     */
    public void nuevaSerie(SeriesEntrenamiento se){
            seR.save(se); 
    }
}
