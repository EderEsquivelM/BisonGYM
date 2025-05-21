/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EderEsquivel.bison_system.repository;

import EderEsquivel.bison_system.model.Medidas;
import EderEsquivel.bison_system.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *Repositorio JPA para la entidad {@link Medidas}.
 * 
 * Se utiliza en {@link MedidasServices}.
 * @author edere
 */
public interface MedidasRepository extends JpaRepository<Medidas,Long>{
    
    /**
     * @implNote Busca la ultima medida ingresada por un usuario en especifico.
     * @param us Usuario
     * @return {@link Medidas} que fue ingresada
     */
    Medidas findTopByUsuarioOrderByFechaDesc(Usuarios us);
}
