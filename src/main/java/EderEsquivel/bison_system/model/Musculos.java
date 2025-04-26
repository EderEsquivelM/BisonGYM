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
@Table(name="musculos")
public class Musculos {
    @Id
    @Column(name="id_musculo")
    private Integer id;
    
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name="id_zona")
    private ZonasAnatomicas id_zona;
    
    private String funcion;

    public Musculos(Integer id, String nombre, ZonasAnatomicas id_zona, String funcion) {
        this.id = id;
        this.nombre = nombre;
        this.id_zona = id_zona;
        this.funcion = funcion;
    }

    public Musculos() {
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ZonasAnatomicas getId_zona() {
        return id_zona;
    }

    public void setId_zona(ZonasAnatomicas id_zona) {
        this.id_zona = id_zona;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    
    
    
}
