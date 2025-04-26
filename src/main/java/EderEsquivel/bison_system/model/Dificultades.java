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
 *
 * @author edere
 */
@Entity
@Table(name="dificultades")
public class Dificultades{
    @Id
    @Column(name="id_dificultad")
    private Integer id_dificultad;
    
    private String nombre;

    public Dificultades(Integer id_dificultad, String nombre) {
        this.id_dificultad = id_dificultad;
        this.nombre = nombre;
    }

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
