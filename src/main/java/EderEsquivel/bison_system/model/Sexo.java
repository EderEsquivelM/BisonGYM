/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *Clase que representa el sexo de un usuario.
 * 
 * @author edere
 */
@Entity
@Table(name="sexo")
public class Sexo {
    /**
     * ID del sexo.
     */
    @Id
    @Column(name="id_sexo")
    private Integer id_sexo;
    
    /**
     * Sexo:femenino o masculino.
     */
    private String descripcion;

    /**
     * Constructor que inicializa con la ID del sexo y cuales es.
     * 
     * @param id_sexo
     * @param descripcion 
     */
    public Sexo(Integer id_sexo, String descripcion) {
        this.id_sexo = id_sexo;
        this.descripcion = descripcion;
    }

    /**
     * Constructor vacio.
     */
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
