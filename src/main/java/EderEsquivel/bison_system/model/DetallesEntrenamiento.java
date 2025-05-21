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
 *Clase que relaciona con un entrenamiento con un ejercicio.
 * 
 * @author edere
 */
@Entity
@Table(name="detalles_entrenamiento")
public class DetallesEntrenamiento {
    
    /**
     * Id del detalle de un entrenamiento.
     * 
     * Se genera automaticamente.
     */
    @Id
    @Column(name="id_detalle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle;
    
    /**
     * Relaciona {@link DetallesEntrenamiento} con {@link Entrenamientos}.
     */
    @ManyToOne
    @JoinColumn(name="id_entrenamiento")
    private Entrenamientos id_entren;
    
    /**
     * Relaciona {@link DetallesEntrenamiento} con {@link Ejercicios}.
     */
    @ManyToOne
    @JoinColumn(name="id_ejercicio")
    private Ejercicios id_ejer;
    
    /**
     *Constructor para asociar un ejercicio específico con un entrenamiento.
     * 
     * @param id_entren Representa el entrenamiento.
     * @param id_ejer Representa el ejercicio.
     */
    public DetallesEntrenamiento(Entrenamientos id_entren, Ejercicios id_ejer) {
        this.id_entren = id_entren;
        this.id_ejer = id_ejer;
    }

    /**
     *Constructor utilizado para crear una relación entre un identificador 
     * único y un ejercicio específico,
     * 
     * @param id_detalle ID del detalle.
     * @param id_ejer Ejercicio asociado.
     */
    public DetallesEntrenamiento(Long id_detalle, Ejercicios id_ejer) {
        this.id_detalle = id_detalle;
        this.id_ejer = id_ejer;
    }
    
    /**
     *Constructor vacio.
     */
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

   
    
}
