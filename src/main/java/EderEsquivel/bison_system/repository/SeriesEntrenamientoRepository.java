/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EderEsquivel.bison_system.repository;

import EderEsquivel.bison_system.model.SeriesEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *Repositorio JPA para la entidad {@link SeriesEntrenamiento}.
 * 
 * Se utiliza en {@link SeriesEntrenamientoServices}.
 * 
 * @author edere
 */
public interface SeriesEntrenamientoRepository extends JpaRepository<SeriesEntrenamiento,Long> {
    
}
