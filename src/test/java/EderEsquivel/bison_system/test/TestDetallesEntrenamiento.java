/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EderEsquivel.bison_system.test;


import EderEsquivel.bison_system.model.DetallesEntrenamiento;
import EderEsquivel.bison_system.model.Ejercicios;
import EderEsquivel.bison_system.model.Entrenamientos;
import EderEsquivel.bison_system.repository.DetallesEntrenamientoRepository;
import EderEsquivel.bison_system.services.DetallesEntrenamientoServices;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author edere
 */
public class TestDetallesEntrenamiento {
    
    @Mock
    private DetallesEntrenamientoRepository deR;


    @InjectMocks
    private DetallesEntrenamientoServices deS;
    
    private DetallesEntrenamiento dE;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
        dE=new DetallesEntrenamiento(new Entrenamientos(),new Ejercicios());
    }
    
    @Test
    public void testNuevoDE() {
        when(deR.save(dE)).thenReturn(dE);

        DetallesEntrenamiento resultado = deS.nuevoDE(dE);

        assertNotNull(resultado);
        assertEquals(dE, resultado);

        verify(deR, times(1)).save(dE);
    }
}
