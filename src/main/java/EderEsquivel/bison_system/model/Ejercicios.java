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
 *Clase que representa un Ejercicio.
 * 
 * @author edere
 */

@Entity
@Table(name="ejercicios")
public class Ejercicios {
    /**
     * ID del ejercicio.
     */
    @Id
    @Column(name="id_ejercicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ejericio;
    
    /**
     * Nombre del ejericicio.
     */
    private String nombre;
    
    /**
     * Descripcion del ejericio.
     */
    private String descripcion;
    
    /**
     * Relaciona el {@link Musculos} principal con que trabaja.
     */
    @ManyToOne
    @JoinColumn(name="id_musculo_principal")
    private Musculos musculoPrincipal;
    
    /**
     * Relaciona el {@link Musculos} secundario con que trabaja.
     */
    @ManyToOne
    @JoinColumn(name="id_musculo_secundario")
    private Musculos musculoSecundario;
            
    /**
     * Relaciona el {@link Dificultades} con que es el ejercicio.
     */
    @ManyToOne
    @JoinColumn(name="id_dificultad")
    private Dificultades id_dificultad;

    /**
     *Constructor inicializa un ejercicio completo, incluyendo sus relaciones con músculos y dificultad.
     * 
     * @param id_ejericio
     * @param nombre
     * @param descripcion
     * @param musculoPrincipal
     * @param musculoSecundario
     * @param id_dificultad
     */
    public Ejercicios(Integer id_ejericio, String nombre, String descripcion, Musculos musculoPrincipal, Musculos musculoSecundario, Dificultades id_dificultad) {
        this.id_ejericio = id_ejericio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.musculoPrincipal = musculoPrincipal;
        this.musculoSecundario = musculoSecundario;
        this.id_dificultad = id_dificultad;
    }

    /**
     *Constrcutor que inicializa un ejercicio sin id.
     * 
     * @param nombre
     * @param descripcion
     * @param id_musculo_principal
     * @param id_musculo_secundario
     * @param id_dificultad
     */
    public Ejercicios(String nombre, String descripcion, Musculos id_musculo_principal, Musculos id_musculo_secundario, Dificultades id_dificultad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.musculoPrincipal = musculoPrincipal;
        this.musculoSecundario = musculoSecundario;
        this.id_dificultad = id_dificultad;
    }

    /**
     *Constructor que solo inicializa con una id.
     * @param id_ejericio
     */
    public Ejercicios(Integer id_ejericio) {
        this.id_ejericio = id_ejericio;
    }
    
    /**
     *Constructor vacio.
     */
    public Ejercicios() {
    }


    public Integer getId_ejericio() {
        return id_ejericio;
    }

    public void setId_ejericio(Integer id_ejericio) {
        this.id_ejericio = id_ejericio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Musculos getMusculoPrincipal() {
        return musculoPrincipal;
    }


    public void setMusculoPrincipal(Musculos musculoPrincipal) {
        this.musculoPrincipal = musculoPrincipal;
    }

    public Musculos getMusculoSecundario() {
        return musculoSecundario;
    }

    public void setMusculoSecundario(Musculos musculoSecundario) {
        this.musculoSecundario = musculoSecundario;
    }

    public Dificultades getId_dificultad() {
        return id_dificultad;
    }

    public void setId_dificultad(Dificultades id_dificultad) {
        this.id_dificultad = id_dificultad;
    }
    
    
}
