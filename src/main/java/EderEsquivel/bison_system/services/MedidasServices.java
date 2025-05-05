/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.model.Medidas;
import EderEsquivel.bison_system.model.Usuarios;
import EderEsquivel.bison_system.repository.MedidasRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author edere
 */
@Service
public class MedidasServices {
    @Autowired
    private MedidasRepository mR;

    public MedidasServices(MedidasRepository mR) {
        this.mR = mR;
    }
    
    public Medidas buscarMedidaUsuario(Usuarios us){
        return mR.findTopByUsuarioOrderByFechaDesc(us);
    }
    
    public Medidas actualizarMedida(Medidas med){
        mR.save(med);
        return mR.findTopByUsuarioOrderByFechaDesc(med.getUsuario());
    }
    
    
}
