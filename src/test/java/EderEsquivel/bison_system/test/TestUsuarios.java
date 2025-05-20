/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EderEsquivel.bison_system.test;

import EderEsquivel.bison_system.model.Sexo;
import EderEsquivel.bison_system.model.TipoUsuario;
import EderEsquivel.bison_system.model.Usuarios;
import EderEsquivel.bison_system.repository.UsuariosRepository;
import EderEsquivel.bison_system.services.UsuariosServices;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestUsuarios {
    @Mock
    private UsuariosRepository usRep;

    @InjectMocks
    private UsuariosServices usuarioService;

    private Usuarios us;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
        us = new Usuarios(
            "prueba", "1", "usuario1", "usuario1@gmail.com", "12345", 
                LocalDate.now(), true,new Sexo(1, "Femenino"), 
                new TipoUsuario(1, "usuario"), LocalDate.now()
        );
    }

    @Test
    public void testNuevoUsuario() {
       
        when(usRep.save(us)).thenReturn(us);
        boolean resultado = usuarioService.nuevoUsuario(us);
        
        assertTrue(resultado);
        verify(usRep, times(1)).save(us); // Verifica que se llamó al repositorio
    }
    
    @Test
    public void testInfoUsuarioExiste() {
        when(usRep.findByUsername("usuario1")).thenReturn(us);

        Usuarios resultado = usuarioService.infoUsuario("usuario1");
       
        assertEquals("usuario1", resultado.getUsername());
        assertEquals("usuario1@gmail.com", resultado.getCorreo());
        verify(usRep, times(1)).findByUsername("usuario1");
    }

    @Test
    public void testInfoUsuarioNoExiste() {
        when(usRep.findByUsername("inexistente")).thenReturn(null);

        Usuarios resultado = usuarioService.infoUsuario("inexistente");

        assertNull(resultado);
        verify(usRep, times(1)).findByUsername("inexistente");
    }
    
    @Test
    public void testActualizarUsuarioExiste() {
        when(usRep.findById(us.getId())).thenReturn(Optional.of(us));
        when(usRep.save(any(Usuarios.class))).thenReturn(us);

        boolean resultado = usuarioService.actualizarUsuario(us);

        assertTrue(resultado);
        verify(usRep).findById(us.getId());
        verify(usRep).save(any(Usuarios.class));
    }

    @Test
    public void testActualizarUsuarioNoExiste() {
        when(usRep.findById(999L)).thenReturn(Optional.empty());

        Usuarios usuarioInexistente = new Usuarios();
        usuarioInexistente.setId(999L);

        boolean resultado = usuarioService.actualizarUsuario(usuarioInexistente);

        assertFalse(resultado);
        verify(usRep).findById(999L);
        verify(usRep, never()).save(any(Usuarios.class));
    }
        
    @Test
    public void testUsernameVerificarExiste() {
        when(usRep.existsByUsername("usuario1")).thenReturn(true);

        boolean resultado = usuarioService.usernameVerificar("usuario1");

        assertTrue(resultado);
        verify(usRep).existsByUsername("usuario1");
    }

    @Test
    public void testUsernameVerificarNoExiste() {
        when(usRep.existsByUsername("desconocido")).thenReturn(false);

        boolean resultado = usuarioService.usernameVerificar("desconocido");

        assertFalse(resultado);
        verify(usRep).existsByUsername("desconocido");
    }
    
    @Test
    public void testCorreoVerificarExiste() {
        when(usRep.existsByCorreo("usuario1@gmail.com")).thenReturn(true);

        boolean resultado = usuarioService.correoVerificar("usuario1@gmail.com");

        assertTrue(resultado);
        verify(usRep).existsByCorreo("usuario1@gmail.com");
    }

    @Test
    public void testCorreoVerificarNoExiste() {
        when(usRep.existsByCorreo("otro@gmail.com")).thenReturn(false);

        boolean resultado = usuarioService.correoVerificar("otro@gmail.com");

        assertFalse(resultado);
        verify(usRep).existsByCorreo("otro@gmail.com");
    }
    
    @Test
    public void testObtenerTodosUsuarios() {
        List<Usuarios> lista = Arrays.asList(us, new Usuarios(/* otro usuario */));
        when(usRep.findAll()).thenReturn(lista);

        List<Usuarios> resultado = usuarioService.obtenerTodosUsuarios();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(usRep).findAll();
    }
    
    @Test
    public void testActualizarUsuarioAdminExiste() {
        when(usRep.findById(us.getId())).thenReturn(Optional.of(us));
        when(usRep.save(any(Usuarios.class))).thenReturn(us);

        boolean resultado = usuarioService.actualizarUsuarioAdmin(us);

        assertTrue(resultado);
        verify(usRep).findById(us.getId());
        verify(usRep).save(any(Usuarios.class));
    }

    @Test
    public void testActualizarUsuarioAdminNoExiste() {
        when(usRep.findById(999L)).thenReturn(Optional.empty());

        Usuarios usuarioInexistente = new Usuarios();
        usuarioInexistente.setId(999L);

        boolean resultado = usuarioService.actualizarUsuarioAdmin(usuarioInexistente);

        assertFalse(resultado);
        verify(usRep).findById(999L);
        verify(usRep, never()).save(any(Usuarios.class));
    }


    @Test
    public void testBuscarUsuarioIDExiste() {
        when(usRep.findById(us.getId())).thenReturn(Optional.of(us));

        Usuarios resultado = usuarioService.buscarUsuarioID(us.getId());

        assertNotNull(resultado);
        assertEquals(us.getId(), resultado.getId());
        verify(usRep).findById(us.getId());
    }

    @Test
    public void testBuscarUsuarioIDNoExiste() {
        when(usRep.findById(999L)).thenReturn(Optional.empty());

        Usuarios resultado = usuarioService.buscarUsuarioID(999L);

        assertNull(resultado);
        verify(usRep).findById(999L);
    }

}
