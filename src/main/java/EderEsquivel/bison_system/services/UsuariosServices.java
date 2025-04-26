/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.model.Usuarios;
import EderEsquivel.bison_system.repository.UsuariosRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author edere
 */
@Service
public class UsuariosServices {
    private UsuariosRepository usuariosRep;

    public UsuariosServices(UsuariosRepository usuariosRep) {
        this.usuariosRep = usuariosRep;
    }
    
    public void nuevoUsuario(Usuarios us){
        usuariosRep.save(us);
    }

}
