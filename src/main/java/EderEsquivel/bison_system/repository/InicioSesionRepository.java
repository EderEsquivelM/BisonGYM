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
 *Repositorio JPA para la entidad {@link InicioSesion}.
 * 
 * Se utiliza en {@link InicioSesionServices}.
 * 
 * @author edere
 */
public interface InicioSesionRepository extends JpaRepository<InicioSesion, Long> {
    
    /**
     * @implNote Busca un usuario por username,contraseña y tipo de usuario.
     *
     * @param username Username del usuario.
     * @param passwordHash Contraseña del usuario.
     * @param idTipoUsuario Tipo de usuario esta iniciando sesion.
     * @return {@link Optional} con el usuario encontrado o vacío si las 
     * credencias son inválidas.
     */
    Optional<InicioSesion> findByUsernameAndPasswordHashAndIdTipoUsuario(
        String username, 
        String passwordHash, 
        TipoUsuario idTipoUsuario
    );
    
}