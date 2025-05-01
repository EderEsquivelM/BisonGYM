/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EderEsquivel.bison_system.repository;

import EderEsquivel.bison_system.model.InicioSesion;
import EderEsquivel.bison_system.model.TipoUsuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author edere
 */
public interface InicioSesionRepository extends JpaRepository<InicioSesion, Long> {
    Optional<InicioSesion> findByUsernameAndPasswordHashAndIdTipoUsuario(
        String username, 
        String passwordHash, 
        TipoUsuario idTipoUsuario
    );
    
}