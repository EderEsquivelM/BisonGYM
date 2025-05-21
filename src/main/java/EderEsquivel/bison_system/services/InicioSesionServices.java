/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.model.TipoUsuario;
import EderEsquivel.bison_system.repository.InicioSesionRepository;
import EderEsquivel.bison_system.repository.TipoUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *Servicio para verificar los inicio de sesion del programa.
 * 
 * @author edere
 */
@Service
public class InicioSesionServices {

    @Autowired
    private InicioSesionRepository isRep;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    /**
     * Constructor para inyección de dependencias
     * 
     * @param isRep Repositorio de credenciales de usuario 
     * {@link InicioSesionRepository}.
     * 
     * @param tipoUsuarioRepository  Repositorio de tipos de usuario 
     * {@link TipoUsuarioRepository}.
     */
    public InicioSesionServices(InicioSesionRepository isRep, TipoUsuarioRepository tipoUsuarioRepository) {
        this.isRep = isRep;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }
    
    /**
     * Verifica las credenciales de un usuario contra los registros del sistema.
     * 
     * 
     * @param username Nombre de usuario.
     * @param password Contraseña.
     * @param tipoId ID del tipo de usuario esperado.
     * @return true si las credenciales son válidas y el usuario tiene el tipo 
     * especificado, false en cualquier otro caso
     */
   public boolean verificarUsuario(String username, String password, Integer tipoId) {
       
       //Verifica si el tipo de usuario existe
        Optional<TipoUsuario> tipoOpt = tipoUsuarioRepository.findById(tipoId);
        if (tipoOpt.isEmpty()) return false;

        TipoUsuario tipoUsuario = tipoOpt.get();
        
        //Realiza la busqueda a la base de datos
        return isRep.findByUsernameAndPasswordHashAndIdTipoUsuario(
                username,
                password,
                tipoUsuario
        ).isPresent();
    }

}
