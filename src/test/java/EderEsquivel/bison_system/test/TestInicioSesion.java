/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EderEsquivel.bison_system.test;

import EderEsquivel.bison_system.model.InicioSesion;
import EderEsquivel.bison_system.model.TipoUsuario;
import EderEsquivel.bison_system.repository.InicioSesionRepository;
import EderEsquivel.bison_system.repository.TipoUsuarioRepository;
import EderEsquivel.bison_system.services.InicioSesionServices;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author edere
 */
public class TestInicioSesion {
    
    @Mock
    private InicioSesionRepository isRep;

    @Mock
    private TipoUsuarioRepository tipoUsuarioRepository;

    @InjectMocks
    private InicioSesionServices inicioSesionServices;

    private InicioSesion isTest;
    private TipoUsuario tipoUsuario;
    private String username;
    private String password;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tipoUsuario = new TipoUsuario(1, "Usuario");
        username = "Prueba";
        password = "contrasenoa";
        isTest = new InicioSesion(username, password, tipoUsuario);
    }

    @Test
    public void testVerificarUsuario_UsuarioValido() {
        when(tipoUsuarioRepository.findById(tipoUsuario.getId_t_usuario()))
            .thenReturn(Optional.of(tipoUsuario));

        when(isRep.findByUsernameAndPasswordHashAndIdTipoUsuario(username, password, 
                tipoUsuario)).thenReturn(Optional.of(isTest)); // Corregido: se retorna Optional<InicioSesion>

        boolean resultado = inicioSesionServices.verificarUsuario(username, password, tipoUsuario.getId_t_usuario());

        assertTrue(resultado);
        verify(tipoUsuarioRepository, times(1)).findById(tipoUsuario.getId_t_usuario());
        verify(isRep, times(1)).findByUsernameAndPasswordHashAndIdTipoUsuario(username,
                password, tipoUsuario);
    }

    @Test
    public void testVerificarUsuario_UsuarioNoExiste() {
        when(tipoUsuarioRepository.findById(tipoUsuario.getId_t_usuario()))
            .thenReturn(Optional.of(tipoUsuario));

        when(isRep.findByUsernameAndPasswordHashAndIdTipoUsuario(username, password, 
                tipoUsuario))
            .thenReturn(Optional.empty());

        boolean resultado = inicioSesionServices.verificarUsuario(username, password, tipoUsuario.getId_t_usuario());

        assertFalse(resultado);
        verify(tipoUsuarioRepository, times(1)).findById(tipoUsuario.getId_t_usuario());
        verify(isRep, times(1)).findByUsernameAndPasswordHashAndIdTipoUsuario(username, 
                password, tipoUsuario);
    }
    
}
