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
 *Clase que representa un usuario.
 * 
 * @author edere
 */
@Entity
@Table(name="usuarios")
public class Usuarios {
    /**
     * ID del usuario.
     * 
     * Se genera automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long id;
    
    /**
     * Nombre del usuario.
     */
    private String nombre;
    
    /**
     * Apellido del usuario.
     */
    private String apellido;
    
    /**
     * Username o sobrenombre.
     */
    private String username;
    
    /**
     * Correo con el que se registra el usuario.
     */
    private String correo;
    
    /**
     * Contraseña.
     */
    @Column(name = "password_hash")
    private String passwordHash; 
    
    /**
     * Fecha de nacimiento.
     */
    private LocalDate fecha_nacimiento;
    
    /**
     * Indica si el usuario esta habilitado.
     */
    private boolean activo;
    @ManyToOne
    
    /**
     * Relaciona {@link Sexo} con el usuario.
     */
    @JoinColumn(name="id_sexo")
    private Sexo sexo;  
    
    /**
     * Relaciona {@link TipoUsuario} con el usuario.
     */
    @ManyToOne
    @JoinColumn(name="id_t_usuario")
    private TipoUsuario tipoUsuario;
    
   /**
    * Fecha de cracion del usuario.
    */
    private LocalDate fecha_creacion;

    /**
     * Constructor que inicializa un nuevo usuario.
     * 
     * @param nombre
     * @param apellido
     * @param username
     * @param correo
     * @param passwordHash
     * @param fecha_nacimiento
     * @param activo
     * @param sexo
     * @param tipoUsuario
     * @param fecha_creacion 
     */
    public Usuarios(String nombre, String apellido, String username,String correo , String passwordHash, LocalDate fecha_nacimiento, boolean activo,Sexo sexo, TipoUsuario tipoUsuario, LocalDate fecha_creacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.correo = correo;
        this.passwordHash = passwordHash; 
        this.fecha_nacimiento = fecha_nacimiento;
        this.activo=activo; 
        this.sexo = sexo;
        this.tipoUsuario = tipoUsuario;
        this.fecha_creacion = fecha_creacion;
       
    }
    
   
    /**
     * Constructor vacio.
     */
    public Usuarios() {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPassword_hash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
