/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.model.DetallesEntrenamiento;
import EderEsquivel.bison_system.repository.DetallesEntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edere
 */
@Service
public class DetallesEntrenamientoServices {
    @Autowired
    private DetallesEntrenamientoRepository deR;

    public DetallesEntrenamientoServices(DetallesEntrenamientoRepository deR) {
        this.deR = deR;
    }
    
    
    public DetallesEntrenamiento nuevoDE(DetallesEntrenamiento dE){
        return deR.save(dE);
    }
    
    
}
