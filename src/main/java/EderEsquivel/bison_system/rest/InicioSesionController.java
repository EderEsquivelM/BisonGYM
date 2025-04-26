/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.rest;

import EderEsquivel.bison_system.model.TipoUsuario;
import EderEsquivel.bison_system.services.InicioSesionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edere
 */

@RestController
@RequestMapping("/api/vw_iniciosesion")
public class InicioSesionController {

    @Autowired
    private InicioSesionServices inicioSSerivices;

    @GetMapping("/{username}/{password}/{tipo}")
    public boolean verificarUsuario(
            @PathVariable String username,
            @PathVariable String password,
            @PathVariable Integer tipo) {

        return inicioSSerivices.verificarUsuario(username, password, tipo);
    }
}

