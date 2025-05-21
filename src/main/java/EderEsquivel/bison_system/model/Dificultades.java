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
 *Clase que indica la dificultad de un {@link Ejercicios}
 * 
 * @author edere
 */
@Entity
@Table(name="dificultades")
public class Dificultades{
    /**
     * ID de la dificultad,entre mas grande sea mas dificil.
     */
    @Id
    @Column(name="id_dificultad")
    private Integer id_dificultad;
    
    /**
     * Solo indica el nivel de dificultad.
     */
    private String nombre;

    /**
     * 
     * @param id_dificultad ID y nivel de dificultad 
     * @param nombre Nivel de dificultad.
     */
    public Dificultades(Integer id_dificultad, String nombre) {
        this.id_dificultad = id_dificultad;
        this.nombre = nombre;
    }

    /**
     *Constructor vacio.
     */
    public Dificultades() {
    }

    public Integer getId_dificultad() {
        return id_dificultad;
    }
    
    public void setId_dificultad(Integer id_dificultad) {
        this.id_dificultad = id_dificultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
