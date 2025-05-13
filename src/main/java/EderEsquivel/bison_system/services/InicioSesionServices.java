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
 *
 * @author edere
 */
@Service
public class InicioSesionServices {

    @Autowired
    private InicioSesionRepository isRep;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public InicioSesionServices(InicioSesionRepository isRep, TipoUsuarioRepository tipoUsuarioRepository) {
        this.isRep = isRep;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }
    
    
   public boolean verificarUsuario(String username, String password, Integer tipoId) {
        Optional<TipoUsuario> tipoOpt = tipoUsuarioRepository.findById(tipoId);
        if (tipoOpt.isEmpty()) return false;

        TipoUsuario tipoUsuario = tipoOpt.get();

        return isRep.findByUsernameAndPasswordHashAndIdTipoUsuario(
                username,
                password,
                tipoUsuario
        ).isPresent();
    }

}
