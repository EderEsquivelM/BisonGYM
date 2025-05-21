/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *Clase que representa el inicio de sesion de un usuario.
 * 
 * @author edere
 */
@Entity
@Table(name="vw_iniciosesion")
public class InicioSesion {
    
    /**
     * ID del usuario.
     */
    @Id
    @Column(name="id_usuario")
    private Long id_usuarios;
    
    /**
     * Username del usuario.
     */
     @Column(name = "username")
    private String username;
    
     /**
      * Contraseña del usuario.
      */
    @Column(name = "password_hash")
    private String passwordHash; 
    
    /**
     * Relaciona un {@link TipoUsuario} con el usuario que inicia sesion.
     */
    @ManyToOne
    @JoinColumn(name="id_t_usuario")
    private TipoUsuario idTipoUsuario;

    /**
     *Constructor que inicializa con todos sus atributos menos con el id del
     * usuario.
     * 
     * @param username
     * @param passwordHash
     * @param idTipoUsuario
     */
    public InicioSesion(String username, String passwordHash, TipoUsuario idTipoUsuario) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.idTipoUsuario = idTipoUsuario;
    }

    /**
     *Constructor vacio.
     */
    public InicioSesion() {
    }
   
    public Long getId() {
        return id_usuarios;
    }

    public void setId(Long id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public TipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
}
