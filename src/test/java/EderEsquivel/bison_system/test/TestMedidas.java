    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EderEsquivel.bison_system.test;

import EderEsquivel.bison_system.model.Medidas;
import EderEsquivel.bison_system.model.Usuarios;
import EderEsquivel.bison_system.repository.MedidasRepository;
import EderEsquivel.bison_system.services.MedidasServices;
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
public class TestMedidas {
    
    @Mock
    private MedidasRepository mR;

    @InjectMocks
    private MedidasServices medidasServices;

    private Medidas medidatest;
    private Usuarios usuariotest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        usuariotest = new Usuarios();

        medidatest = new Medidas();
        medidatest.setUsuario(usuariotest);
    }

    @Test
    public void testBuscarMedidaUsuario() {
        when(mR.findTopByUsuarioOrderByFechaDesc(usuariotest)).thenReturn(medidatest);

        Medidas resultado = medidasServices.buscarMedidaUsuario(usuariotest);

        assertNotNull(resultado);
        assertEquals(usuariotest, resultado.getUsuario());
        verify(mR, times(1)).findTopByUsuarioOrderByFechaDesc(usuariotest);
    }

    @Test
    public void testActualizarMedida() {
        when(mR.save(medidatest)).thenReturn(medidatest);
        when(mR.findTopByUsuarioOrderByFechaDesc(usuariotest)).thenReturn(medidatest);

        Medidas resultado = medidasServices.actualizarMedida(medidatest);

        assertNotNull(resultado);
        assertEquals(usuariotest, resultado.getUsuario());
        verify(mR, times(1)).save(medidatest);
        verify(mR, times(1)).findTopByUsuarioOrderByFechaDesc(usuariotest);
    }
    
}
