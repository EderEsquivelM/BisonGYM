/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author edere
 */
@Entity
@Table(name="detalles_entrenamiento")
public class DetallesEntrenamiento {
    @Id
    @Column(name="id_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle;
    
    @ManyToOne
    @JoinColumn(name="id_entrenamiento")
    private Entrenamientos id_entren;
    
    @ManyToOne
    @JoinColumn(name="id_ejercicio")
    private Ejercicios id_ejer;
    
    private Integer ordenEjercicio;
    private String notas;

    public DetallesEntrenamiento(Entrenamientos id_entren, Ejercicios id_ejer, Integer ordenEjercicio, String notas) {
        this.id_entren = id_entren;
        this.id_ejer = id_ejer;
        this.ordenEjercicio = ordenEjercicio;
        this.notas = notas;
    }

    public DetallesEntrenamiento() {
    }

    public Long getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(Long id_detalle) {
        this.id_detalle = id_detalle;
    }

    public Entrenamientos getId_entren() {
        return id_entren;
    }

    public void setId_entren(Entrenamientos id_entren) {
        this.id_entren = id_entren;
    }

    public Ejercicios getId_ejer() {
        return id_ejer;
    }

    public void setId_ejer(Ejercicios id_ejer) {
        this.id_ejer = id_ejer;
    }

    public Integer getOrdenEjercicio() {
        return ordenEjercicio;
    }

    public void setOrdenEjercicio(Integer ordenEjercicio) {
        this.ordenEjercicio = ordenEjercicio;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
    
}
