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
 *Servicios para la gestion de medidas del usuario.
 * 
 * @author edere
 */
@Service
public class MedidasServices {
    @Autowired
    private MedidasRepository mR;
    
    /**
     * Constructor para inyección de dependencias.
     * 
     * @param mR Repositorio de medidas {@link MedidasRepository}.
     */
    public MedidasServices(MedidasRepository mR) {
        this.mR = mR;
    }
    
    /**
     * Obtiene la última medida registrada para un usuario específico.
     * 
     * Consulta la medida más reciente según fecha de registro,
     * retornando los datos actualizados del estado físico del usuario.
     * 
     * @param us Objeto {@link Usuarios} del cual se buscan las medidas.
     * @return {@link Medidas} más reciente del usuario, o null si no existen 
     * registros
     */
    public Medidas buscarMedidaUsuario(Usuarios us){
        return mR.findTopByUsuarioOrderByFechaDesc(us);
    }
    
    /**
     * Actualiza o crea un nuevo registro de medidas corporales.
     * 
     * 
     * Persiste las medidas proporcionadas y retorna la última medida actualizada
     * para el usuario, permitiendo una confirmación inmediata del registro.
     * 
     * @param med Objeto {@link Medidas} con los datos a actualizar o crear.
     * @return  La {@link Medidas} más reciente del usuario después de la 
     * actualización.
     */
    public Medidas actualizarMedida(Medidas med){
        mR.save(med);
        return mR.findTopByUsuarioOrderByFechaDesc(med.getUsuario());
    }
    
    
}
