/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.model.Usuarios;
import EderEsquivel.bison_system.repository.UsuariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *Servicio para  gestionar a los usuarios.
 * 
 * @author edere
 */
@Service
public class UsuariosServices {
    @Autowired
    private UsuariosRepository usuariosRep;

    /**
     * Constructor para la inyeccion de dependencias.
     * @param usuariosRep 
     */
    public UsuariosServices(UsuariosRepository usuariosRep) {
        this.usuariosRep = usuariosRep;
    }
    
    /**
     * Registra un nuevo usuario en el sistema.
     * 
     * @param us Objeto {@link Usuarios} con los datos del nuevo usuario.
     * @return true si el usuario se registró correctamente.
     */
    public boolean nuevoUsuario(Usuarios us) {
            usuariosRep.save(us);
            return true;
            
    }
    
    /**
     * Obtiene la información de un usuario por su nombre de usuario.
     * 
     * @param username Nombre de usuario a buscar.
     * @return Objeto {@link Usuarios} o null si no se encuentra.
     */
    public Usuarios infoUsuario(String username){
        return usuariosRep.findByUsername(username);
       
    }
    
    /**
     * Actualiza la información básica de un usuario.
     * 
     * @param us Objeto {@link Usuarios} con los datos actualizados.
     * @return true si la actualización fue exitosa, false si el usuario no existe
     */
    public boolean actualizarUsuario(Usuarios us) {
        return usuariosRep.findById(us.getId())
            .map(usuarioExistente -> {
                usuarioExistente.setNombre(us.getNombre());
                usuarioExistente.setApellido(us.getApellido());
                usuarioExistente.setFecha_nacimiento(us.getFecha_nacimiento());
                usuarioExistente.setUsername(us.getUsername());
                usuarioExistente.setCorreo(us.getCorreo());
                usuarioExistente.setPassword_hash(us.getPasswordHash());
                usuariosRep.save(usuarioExistente);
                return true;
            })
            .orElse(false);
   }

    /**
     * Verifica si un nombre de usuario ya está registrado
     * 
     * @param username Nombre de usuario a verificar.
     * @return true si el usuario existe, false si no.
     */
    public boolean usernameVerificar(String username){
        return usuariosRep.existsByUsername(username);
           
    }
    
    /**
     * Verifica si un correo electrónico ya está registrado.
     * 
     * @param correo Correo electrónico a verificar.
     * @return true si el correo existe, false si no.
     */
    public boolean correoVerificar(String correo){
        return usuariosRep.existsByCorreo(correo);
    }
    
   
    /**
     * Obtiene una lista de todos los usuarios registrados.
     * 
     * @return Lista de {@link Usuarios}.
     */
    public List<Usuarios> obtenerTodosUsuarios() {
        return usuariosRep.findAll();
    }
    
    /**
     * Actualiza la información de un usuario con privilegios de administrador.
     * 
     * @param us Objeto {@link Usuarios} con los datos actualizados .
     * @return true si la actualización fue exitosa, false si el usuario no existe.
     */
    public boolean actualizarUsuarioAdmin(Usuarios us) {
        return usuariosRep.findById(us.getId())
            .map(usuarioExistente -> {
                usuarioExistente.setNombre(us.getNombre());
                usuarioExistente.setApellido(us.getApellido());
                usuarioExistente.setActivo(us.isActivo());
                usuarioExistente.setUsername(us.getUsername());
                usuarioExistente.setCorreo(us.getCorreo());
                usuarioExistente.setPassword_hash(us.getPasswordHash());
                usuariosRep.save(usuarioExistente);
                return true;
            })
            .orElse(false);
   }
    
    
    /**
     * Busca un usuario por su ID.
     * 
     * @param id ID del usuario a buscar.
     * @return Objeto {@link Usuarios} o null si no se encuentra
     */
    public Usuarios buscarUsuarioID(Long id) {
        return usuariosRep.findById(id).orElse(null);
    }
}
