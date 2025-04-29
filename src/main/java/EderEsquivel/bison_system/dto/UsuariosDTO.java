/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.dto;

/**
 *
 * @author edere
 */
import java.time.LocalDate;

public class UsuariosDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String username;
    private String correo;
    private String password_hash;
    private LocalDate fecha_nacimiento;
    private boolean activo;
    private Integer sexoId;
    private Integer tipoUsuarioId;
    private LocalDate fecha_creacion;

    // Constructor, getters y setters
    public UsuariosDTO() {}

    public UsuariosDTO(String nombre, String apellido, String username, String correo, String password_hash, LocalDate fecha_nacimiento, boolean activo, Integer sexoId, Integer tipoUsuarioId, LocalDate fecha_creacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.correo = correo;
        this.password_hash = password_hash;
        this.fecha_nacimiento = fecha_nacimiento;
        this.activo = activo;
        this.sexoId = sexoId;
        this.tipoUsuarioId = tipoUsuarioId;
        this.fecha_creacion = fecha_creacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Integer getSexoId() {
        return sexoId;
    }

    public void setSexoId(Integer sexoId) {
        this.sexoId = sexoId;
    }

    public Integer getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    
}