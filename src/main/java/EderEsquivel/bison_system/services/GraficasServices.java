/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.entidadesGraficas.EntrenamientoPorMes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author edere
 */
@Service
public class GraficasServices {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<EntrenamientoPorMes> EntrenamientosPorMes(Long idUsuario, LocalDate fechaInicio, LocalDate fechaFin) {
        List<Object[]> results = entityManager.createNativeQuery("SELECT * FROM sp_entrenamientos_fechas(:id, :fi, :ff)")
                .setParameter("id", idUsuario)
                .setParameter("fi", fechaInicio)
                .setParameter("ff", fechaFin)
                .getResultList();

        List<EntrenamientoPorMes> lista = new ArrayList<>();
        for (Object[] row : results) {
            String mes = (String) row[0];
            Number totalNumber = (Number) row[1]; 
            long total = totalNumber.longValue();
            lista.add(new EntrenamientoPorMes(mes, total));
        }
        return lista;
    }
}
