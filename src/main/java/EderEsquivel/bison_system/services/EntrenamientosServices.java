/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.model.Entrenamientos;
import EderEsquivel.bison_system.repository.EntrenamientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edere
 */
@Service
public class EntrenamientosServices {
    @Autowired
    private EntrenamientosRepository eR;

    public EntrenamientosServices(EntrenamientosRepository eR) {
        this.eR = eR;
    }
    
    public Entrenamientos nuevoEntrenamiento(Entrenamientos entr){
        return eR.save(entr);
    }
    
}
