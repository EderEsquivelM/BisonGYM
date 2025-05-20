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
import java.time.LocalDate;

/**
 *
 * @author edere
 */
@Entity
@Table(name="entrenamientos")
public class Entrenamientos {
    @Id
    @Column(name="id_entrenamiento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entrenamiento;
    
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuarios usuario;
    
    private LocalDate fecha;
    private String nombre;
    private String descripcion;
    private Integer duracion_minutos;
    private String observaciones;

    public Entrenamientos(Usuarios usuario, LocalDate fecha, String nombre, String descripcion, Integer duracion_minutos, String observaciones) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion_minutos = duracion_minutos;
        this.observaciones = observaciones;
    }

    public Entrenamientos(Long id_entrenamiento, LocalDate fecha, String nombre, String descripcion, Integer duracion_minutos, String observaciones) {
        this.id_entrenamiento = id_entrenamiento;
        this.fecha = fecha;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion_minutos = duracion_minutos;
        this.observaciones = observaciones;
    }
    
    

    

    public Entrenamientos() {
    }
    
    
    
    public Long getId_entrenamiento() {
        return id_entrenamiento;
    }

    public void setId_entrenamiento(Long id_entrenamiento) {
        this.id_entrenamiento = id_entrenamiento;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public Integer getDuracion_minutos() {
        return duracion_minutos;
    }

    public void setDuracion_minutos(Integer duracion_minutos) {
        this.duracion_minutos = duracion_minutos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
}
