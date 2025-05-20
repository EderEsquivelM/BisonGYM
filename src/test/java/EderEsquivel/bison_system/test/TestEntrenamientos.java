/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EderEsquivel.bison_system.test;

import EderEsquivel.bison_system.model.Entrenamientos;
import EderEsquivel.bison_system.model.Usuarios;
import EderEsquivel.bison_system.repository.EntrenamientosRepository;
import EderEsquivel.bison_system.services.EntrenamientosServices;
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
public class TestEntrenamientos {
    
    @Mock
    private EntrenamientosRepository eR;

    @InjectMocks
    private EntrenamientosServices eS;

    private Entrenamientos entrenamiento;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        entrenamiento = new Entrenamientos(new Usuarios(),LocalDate.now(),"Test","Descripcion test"
                ,60,"Observaciones test");
        
    }

    @Test
    public void testNuevoEntrenamiento() {
        when(eR.save(entrenamiento)).thenReturn(entrenamiento);

        Entrenamientos resultado = eS.nuevoEntrenamiento(entrenamiento);

        assertNotNull(resultado);
        assertEquals(entrenamiento, resultado);

        verify(eR, times(1)).save(entrenamiento);
    }
    
}
