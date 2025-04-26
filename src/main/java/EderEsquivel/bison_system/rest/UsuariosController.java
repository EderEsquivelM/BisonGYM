/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.Usuarios;
import EderEsquivel.bison_system.repository.UsuariosRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    private final UsuariosRepository usuariosRepository;
        
    public UsuariosController(UsuariosRepository usuariosRepository){
        this.usuariosRepository=usuariosRepository;
    }
    
    @GetMapping
    public List<Usuarios> listar() {
        return usuariosRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerPorId(@PathVariable Long id) {
    return usuariosRepository.findById(id)
            .map(usuario -> ResponseEntity.ok(usuario))
            .orElse(ResponseEntity.notFound().build());
    }

    

}
