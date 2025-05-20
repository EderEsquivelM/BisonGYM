package EderEsquivel.bison_system;

import EderEsquivel.bison_system.services.DetallesEntrenamientoServices;
import EderEsquivel.bison_system.services.EntrenamientosServices;
import EderEsquivel.bison_system.services.DatosDeUsuarioServices;
import EderEsquivel.bison_system.services.InicioSesionServices;
import EderEsquivel.bison_system.services.MedidasServices;
import EderEsquivel.bison_system.services.SeriesEntrenamientoServices;
import EderEsquivel.bison_system.services.UsuariosServices;
import EderEsquivel.bison_system.swing.InicioSesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Clase principal que inicializa la aplicacion SpringBoot y ejecuta la interfaz
 * grafica.
 * 
 * Configura los servicios necesarios y muestra la ventana de inicio de sesión.
 * 
 * Utiliza inyección de dependencias ({@code @Autowired}) para gestionar 
 * automáticamente las instancias
 * 
 * @author edere
 */
@SpringBootApplication
public class BisonSystemApplication implements CommandLineRunner {
    
    @Autowired
    private UsuariosServices usS;

    @Autowired
    private InicioSesionServices isS;

    @Autowired
    private MedidasServices mS;

    @Autowired
    private EntrenamientosServices eS;

    @Autowired
    private DetallesEntrenamientoServices deS;

    @Autowired
    private SeriesEntrenamientoServices seS;

    @Autowired
    private DatosDeUsuarioServices gS;

    /**
     *
     *Punto de entrada principal para la aplicación Spring Boot.
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");

        SpringApplication.run(BisonSystemApplication.class, args);

    }

    /**
     *
     * Ejecuta la interfaz gráfica después de que Spring Boot haya inicializado 
     * el contexto.Crea y muestra la ventana de inicio de sesión con los servicios 
     * inyectados. 
     *  
     *
     * @param args 
     */
    @Override
    public void run(String... args) {
        java.awt.EventQueue.invokeLater(() -> {
            new InicioSesion(usS, isS, mS, eS, deS, seS, gS).setVisible(true);
        });
    }
}
