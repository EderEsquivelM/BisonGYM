/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EderEsquivel.bison_system.test;

import EderEsquivel.bison_system.DatosGenerales;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author edere
 */
public class TestDatosGenerales {
    
    
    @Test
    public void testHayConexion() {
        assertTrue(DatosGenerales.hayConexion(), "Debe tener conexión a internet");
    }

    @Test
    public void testCambioFecha() {
        
        Date fecha = new Date();
        LocalDate esperado = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate resultado = DatosGenerales.cambioFecha(fecha);
        
        assertEquals(esperado, resultado);

        assertNull(DatosGenerales.cambioFecha(null));
    }

    @Test
    public void testCorreoValido() {
        assertTrue(DatosGenerales.correoValido("usuario@dominio.com"));
        assertTrue(DatosGenerales.correoValido("usuario.nombre@dominio.mx"));
        assertFalse(DatosGenerales.correoValido("usuario@dominio.invalid"));
        assertFalse(DatosGenerales.correoValido("usuario@dominio"));
        assertFalse(DatosGenerales.correoValido("usuario.com"));
        assertFalse(DatosGenerales.correoValido(""));
    }
    
}
