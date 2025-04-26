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
@Table(name="tipo_usuarios")
public class TipoUsuario {
    @Id
    @Column(name="id_t_usuario")
    private Integer id;
    
    private String n_usuario;

    public TipoUsuario(Integer id, String n_usuario) {
        this.id = id;
        this.n_usuario = n_usuario;
    }

    public TipoUsuario() {
    }
    
    
    public Integer getId_t_usuario() {
        return id;
    }

    public void setId_t_usuario(Integer id) {
        this.id = id;
    }

    public String getN_usuario() {
        return n_usuario;
    }

    public void setN_usuario(String n_usuario) {
        this.n_usuario = n_usuario;
    }
    
    
    
}
