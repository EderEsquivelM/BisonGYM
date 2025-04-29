/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.model.Usuarios;
import EderEsquivel.bison_system.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author edere
 */
@Service
public class UsuariosServices {
    @Autowired
    private UsuariosRepository usuariosRep;

    
    public UsuariosServices(UsuariosRepository usuariosRep) {
        this.usuariosRep = usuariosRep;
    }
    
    public boolean nuevoUsuario(Usuarios us) {
        try {
            usuariosRep.save(us); 
            return true;  
        } catch (Exception e) {
            return false;
        }
    }

}
