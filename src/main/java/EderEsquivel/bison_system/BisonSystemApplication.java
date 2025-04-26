package EderEsquivel.bison_system;


import EderEsquivel.bison_system.swing.InicioSesion;
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BisonSystemApplication {

	public static void main(String[] args) {
                 SpringApplication.run(BisonSystemApplication.class, args);
                 
                 System.setProperty("java.awt.headless", "false");

                 
                 java.awt.EventQueue.invokeLater(() -> {
                 new InicioSesion().setVisible(true);
        });
                 
        }
       
}
