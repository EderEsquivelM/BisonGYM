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
 *Servicio para la gestion de entrenamientos.
 * 
 * @author edere
 */
@Service
public class EntrenamientosServices {
    @Autowired
    private EntrenamientosRepository eR;

    
    /**
     * Constructor para inyección de dependencias.
     *
     * @param eR Repositorio de entrenamientos{@link EntrenamientosRepository}.
     */
    public EntrenamientosServices(EntrenamientosRepository eR) {
        this.eR = eR;
    }
    
    /**
     * Registra un nuevo entrenamiento en el sistema.
     * 
     * @param entr Objeto {@link Entrenamientos} con los datos a registrar.
     * @return El entrenamiento persistido con su ID generado.
     */
    public Entrenamientos nuevoEntrenamiento(Entrenamientos entr){
        return eR.save(entr);
    }
    
}
