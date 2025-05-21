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
 *Servicio para gestionar los detalles del entrenamiento.   
 * 
 * @author edere
 */
@Service
public class DetallesEntrenamientoServices {
    
    @Autowired
    private DetallesEntrenamientoRepository deR;

    /**
     * Constructor para inyección de dependencias.
     * 
     * @param deR  Repositorio de detalles de entrenamiento 
     * {@link DetallesEntrenamientoRepository}
     */
    public DetallesEntrenamientoServices(DetallesEntrenamientoRepository deR) {
        this.deR = deR;
    }
    
    /**
     * Crea un nuevo detalle de entrenamiento
     * 
     * Registra la relación entre un entrenamiento y un ejercicio específico,
     * incluyendo toda la información relevante para el seguimiento del progreso.
     * 
     * @param dE Objeto {@link DetallesEntrenamiento} con los datos a guardar
     * @return El detalle de entrenamiento persistido con su ID generado
     */
    public DetallesEntrenamiento nuevoDE(DetallesEntrenamiento dE){
        return deR.save(dE);
    }
}
