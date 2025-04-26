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
@Table(name="ejercicios")
public class Ejercicios {
    @Id
    @Column(name="id_ejercicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ejericio;
    
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name="id_musculo_principal")
    private Musculos musculoPrincipal;
    
    @ManyToOne
    @JoinColumn(name="id_musculo_secundario")
    private Musculos musculoSecundario;
            
    @ManyToOne
    @JoinColumn(name="id_dificultad")
    private Dificultades id_dificultad;

    public Ejercicios(Long id_ejericio, String nombre, String descripcion, Musculos musculoPrincipal, Musculos musculoSecundario, Dificultades id_dificultad) {
        this.id_ejericio = id_ejericio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.musculoPrincipal = musculoPrincipal;
        this.musculoSecundario = musculoSecundario;
        this.id_dificultad = id_dificultad;
    }

    public Ejercicios(String nombre, String descripcion, Musculos id_musculo_principal, Musculos id_musculo_secundario, Dificultades id_dificultad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.musculoPrincipal = musculoPrincipal;
        this.musculoSecundario = musculoSecundario;
        this.id_dificultad = id_dificultad;
    }

    public Ejercicios() {
    }

    public Long getId_ejericio() {
        return id_ejericio;
    }

    public void setId_ejericio(Long id_ejericio) {
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
