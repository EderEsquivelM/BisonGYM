/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EderEsquivel.bison_system.repository;

import EderEsquivel.bison_system.model.Entrenamientos;
import java.time.LocalDate;
import java.util.Date;

import java.util.HashMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *Repositorio JPA para la entidad {@link Entrenamientos}.
 * 
 * Se utiliza en {@link EntrenamientosServices.}.
 * 
 * @author edere
 */
public interface EntrenamientosRepository extends JpaRepository<Entrenamientos,Long>{
    
}
