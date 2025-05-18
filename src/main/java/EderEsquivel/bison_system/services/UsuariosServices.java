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
            usuariosRep.save(us);
            return true;
            
    }
    
    public Usuarios infoUsuario(String username){
        return usuariosRep.findByUsername(username);
       
    }
   public Usuarios actualizarUsuario(Usuarios us) {
        try {
            return usuariosRep.findById(us.getId())
                .map(usuarioExistente -> {
                    usuarioExistente.setNombre(us.getNombre());
                    usuarioExistente.setApellido(us.getApellido());
                    usuarioExistente.setFecha_nacimiento(us.getFecha_nacimiento());
                    usuarioExistente.setUsername(us.getUsername());
                    usuarioExistente.setCorreo(us.getCorreo());
                    usuarioExistente.setPassword_hash(us.getPasswordHash());
                    return usuariosRep.save(usuarioExistente); 
                })
                .orElse(null);
        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
            return null;
        }
    }

    public boolean usernameVerificar(String username){
        return usuariosRep.existsByUsername(username);
           
    }
    
    public boolean correoVerificar(String correo){
        return usuariosRep.existsByCorreo(correo);
    }

}
