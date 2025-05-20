/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EderEsquivel.bison_system.test;

import EderEsquivel.bison_system.model.SeriesEntrenamiento;
import EderEsquivel.bison_system.repository.SeriesEntrenamientoRepository;
import EderEsquivel.bison_system.services.SeriesEntrenamientoServices;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author edere
 */
public class TestSeriesEntrenamiento {
    
    @Mock
    private SeriesEntrenamientoRepository seR;

    @InjectMocks
    private SeriesEntrenamientoServices seriesEntrenamientoServices;

    private SeriesEntrenamiento serie;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        serie = new SeriesEntrenamiento();
    }

    @Test
    public void testNuevaSerie() {
        seriesEntrenamientoServices.nuevaSerie(serie);

        verify(seR, times(1)).save(serie); 
    }
    
}
