/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EderEsquivel.bison_system.repository;

import EderEsquivel.bison_system.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author edere
 */
public interface UsuariosRepository extends  JpaRepository<Usuarios,Long> {
    
    Usuarios findByUsername(String username);
    boolean existsByCorreo(String correo);
    boolean existsByUsername(String username);
    
}
