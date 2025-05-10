package EderEsquivel.bison_system;


import EderEsquivel.bison_system.model.SeriesEntrenamiento;
import EderEsquivel.bison_system.services.DetallesEntrenamientoServices;
import EderEsquivel.bison_system.services.EntrenamientosServices;
import EderEsquivel.bison_system.services.InicioSesionServices;
import EderEsquivel.bison_system.services.MedidasServices;
import EderEsquivel.bison_system.services.SeriesEntrenamientoServices;
import EderEsquivel.bison_system.services.UsuariosServices;
import EderEsquivel.bison_system.swing.InicioSesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");

        SpringApplication.run(BisonSystemApplication.class, args);


    }
    
    @Override
    public void run(String... args) {
        java.awt.EventQueue.invokeLater(() -> {
            new InicioSesion(usS,isS,mS,eS,deS,seS).setVisible(true);
            });
    }
}
