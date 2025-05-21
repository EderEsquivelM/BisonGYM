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
 *Clase que representa la serie de un ejercicio hecho en un entrenamiento.
 * 
 * @author edere
 */
@Entity
@Table(name="series_entrenamiento")
public class SeriesEntrenamiento {
    
    /**
     * ID de la serie.
     * 
     * Se genera automaticamente.
     */
    @Id
    @Column(name="id_serie")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_serie;
    
    /**
     * Relaciona {@link DetallesEntrenamiento} con una serie.
     */
    @ManyToOne
    @JoinColumn(name="id_detalle_entrenamiento")
    private DetallesEntrenamiento detEntrenamiento;
    
    /**
     * Indica el numero de la seria.
     */
    private Integer numero_serie;
    
    /**
     * Repeticiones hechas.
     */
    private Integer repeticiones;
    
    /**
     * Peso usado en kg.
     */
    private double peso_usado;

    /**
     * Constructor que inicializa una serie y relaciona con un entrenamiento.
     * 
     * @param detEntrenamiento
     * @param numero_serie
     * @param repeticiones
     * @param peso_usado 
     */
    public SeriesEntrenamiento(DetallesEntrenamiento detEntrenamiento, Integer numero_serie,Integer repeticiones, double peso_usado) {
        this.detEntrenamiento = detEntrenamiento;
        this.numero_serie = numero_serie;
        this.repeticiones =repeticiones;
        this.peso_usado = peso_usado;
    }

    /**
     * Constructor que inicializa con la ID de la seria y la informacion con la 
     * que se ejecuto.
     * 
     * @param numero_serie
     * @param repeticiones
     * @param peso_usado 
     */
    public SeriesEntrenamiento(Integer numero_serie, Integer repeticiones, double peso_usado) {
        this.numero_serie = numero_serie;
        this.repeticiones = repeticiones;
        this.peso_usado = peso_usado;
    }
    
    
    /**
     * Constructor vacio
     */
    public SeriesEntrenamiento() {
    }

    public Long getId_serie() {
        return id_serie;
    }

    public void setId_serie(Long id_serie) {
        this.id_serie = id_serie;
    }

    public DetallesEntrenamiento getDetEntrenamiento() {
        return detEntrenamiento;
    }

    public void setDetEntrenamiento(DetallesEntrenamiento detEntrenamiento) {
        this.detEntrenamiento = detEntrenamiento;
    }

    public Integer getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(Integer num_serie) {
        this.numero_serie = numero_serie;
    }

    public double getPeso_usado() {
        return peso_usado;
    }

    public void setPeso_usado(double peso_usado) {
        this.peso_usado = peso_usado;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }
    
    

}
