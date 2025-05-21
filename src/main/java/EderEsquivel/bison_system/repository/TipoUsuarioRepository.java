/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EderEsquivel.bison_system.repository;

import EderEsquivel.bison_system.model.TipoUsuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *Repositorio JPA para la entidad {@link TipoUsuario}.
 * 
 * Se utiliza en {@link InicioSesionServices}.
 * 
 * @author edere
 */
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Integer> {

    /**
     * @implNote Busca por el tipo de usuario que este en la base de datos
     * @param tipoId ID del tipo de usuario.
     * @return  {@link Optional} con el tipo de usuario encontrado o vacío 
     */
    public Optional<TipoUsuario> findById(Long tipoId);
    
}
