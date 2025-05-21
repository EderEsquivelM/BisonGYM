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
 *Clase que representa una zona anatomica del cuerpo.
 * 
 * @author edere
 */
@Entity
@Table(name="zonas_anatomicas")
public class ZonasAnatomicas {
    /**
     * ID de la zona.
     */
    @Id
    @Column(name="id_zona")
    private Integer id_zona;
 
    /**
     * Nombre de la zona.
     */
    private String nombre_zona;
    
    /**
     * Constructor que inicializa toda la informacion de la zona.
     * 
     * @param id_zona
     * @param nombre_zona 
     */
    public ZonasAnatomicas(Integer id_zona, String nombre_zona) {
        this.id_zona = id_zona;
        this.nombre_zona = nombre_zona;
    }
    
    /**
     * Constructor vacio.
     */
    public ZonasAnatomicas() {
    }
    
    public int getId_zona() {
        return id_zona;
    }

    public void setId_zona(int id_zona) {
        this.id_zona = id_zona;
    }

    public String getNombre_zona() {
        return nombre_zona;
    }

    public void setNombre_zona(String nombre_zona) {
        this.nombre_zona = nombre_zona;
    }
    
    
}
