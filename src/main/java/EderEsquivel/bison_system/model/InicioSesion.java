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
 *
 * @author edere
 */
@Entity
@Table(name="vw_iniciosesion")
public class InicioSesion {
    
    @Id
    @Column(name="id_usuario")
    private Long id_usuarios;
    
     @Column(name = "username")
    private String username;
    
    @Column(name = "password_hash")
    private String passwordHash; 
    
    @ManyToOne
    @JoinColumn(name="id_t_usuario")
    private TipoUsuario idTipoUsuario;

    public InicioSesion(String username, String passwordHash, TipoUsuario idTipoUsuario) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.idTipoUsuario = idTipoUsuario;
    }

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
