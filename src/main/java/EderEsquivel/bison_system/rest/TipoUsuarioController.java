/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.TipoUsuario;
import EderEsquivel.bison_system.repository.TipoUsuarioRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */
@RestController
@RequestMapping("/api/tipo_usuarios")
public class TipoUsuarioController {
    private final TipoUsuarioRepository tuRepositoryT;

    public TipoUsuarioController(TipoUsuarioRepository tuRepositoryT) {
        this.tuRepositoryT = tuRepositoryT;
    }
    
    @GetMapping
    public List<TipoUsuario> listar() {
        return tuRepositoryT.findAll();
    }
    
    
   
    
}
