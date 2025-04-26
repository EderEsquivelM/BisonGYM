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
@Table(name="sexo")
public class Sexo {
    @Id
    @Column(name="id_sexo")
    private Integer id_sexo;
    
    private String descripcion;

    public Sexo(Integer id_sexo, String descripcion) {
        this.id_sexo = id_sexo;
        this.descripcion = descripcion;
    }

    public Sexo() {
    }
    
    public Integer getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(Integer id_sexo) {
        this.id_sexo = id_sexo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
