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
 *Clase que representa las medidas corporales de un usuario.
 * 
 * @author edere
 */

@Entity
@Table(name="medidas")
public class Medidas {
    
    /**
     * ID de la medida
     * 
     * Se genera automaticamente.
     */
    @Id
    @Column(name="id_medida")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_medida;
    
    /**
     * Relaciona {@link Usuarios} con una medida.
     */
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuarios usuario;
    
    /**
     * Fecha en la que se registro la medida.
     */
    private LocalDate fecha;
    
    /**
     * Peso del usuario.
     */
    private double peso;
    
    /**
     * Altura del usuario
     */
    private double altura;
    
    /**
     * Porcentaje de grasa corporal del usuario.
     */
    private Integer porcentaje_grasa;

    /**
     *Constructor que inicializa una nueva medida con un usuario.
     * 
     * @param usuario
     * @param fecha
     * @param peso
     * @param altura
     * @param porcentaje_grasa
     */
    public Medidas(Usuarios usuario, LocalDate fecha, double peso, double altura, Integer porcentaje_grasa) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.peso = peso;
        this.altura = altura;
        this.porcentaje_grasa = porcentaje_grasa;
    }

    /**
     *Constructor vacio.
     */
    public Medidas() {
    }

    public Long getId_medida() {
        return id_medida;
    }

    public void setId_medida(Long id_medida) {
        this.id_medida = id_medida;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Integer getPorcentaje_grasa() {
        return porcentaje_grasa;
    }

    public void setPorcentaje_grasa(Integer porcentaje_grasa) {
        this.porcentaje_grasa = porcentaje_grasa;
    }

}
