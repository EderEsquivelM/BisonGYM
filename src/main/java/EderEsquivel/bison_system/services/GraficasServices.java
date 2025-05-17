/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.entidadesGraficas.DatosGraficaSL;
import EderEsquivel.bison_system.entidadesGraficas.DatosGraficaSD;
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
    
    public List<DatosGraficaSL> EntrenamientosPorMes(Long idUsuario, LocalDate fechaInicio, LocalDate fechaFin) {
        List<Object[]> results = entityManager.createNativeQuery("SELECT * FROM sp_entrenamientos_fechas(:id, :fi, :ff)")
                .setParameter("id", idUsuario)
                .setParameter("fi", fechaInicio)
                .setParameter("ff", fechaFin)
                .getResultList();

        List<DatosGraficaSL> lista = new ArrayList<>();
        for (Object[] row : results) {
            String mes = (String) row[0];
            Number totalNumber = (Number) row[1]; 
            long total = totalNumber.longValue();
            lista.add(new DatosGraficaSL(mes, total));
        }
        return lista;
    }
    
    public List<DatosGraficaSD> evolucionPesoCargado(Long idUsuario, Integer idEjercicio, LocalDate fechaInicio, LocalDate fechaFin) {
        List<Object[]> results = entityManager.createNativeQuery(
                "SELECT * FROM sp_evolucion_peso_cargado(:idUsuario, :idEjercicio, :fechaInicio, :fechaFin)")
                .setParameter("idUsuario", idUsuario)
                .setParameter("idEjercicio", idEjercicio)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

        List<DatosGraficaSD> lista = new ArrayList<>();
        for (Object[] row : results) {
            // Cast directo a Date y luego conversión a LocalDate
            String fecha = (String) row[0];
            Number pesoNumber = (Number) row[1];
            double pesoUsado = pesoNumber.doubleValue();
            lista.add(new DatosGraficaSD(fecha, pesoUsado));
        }
        return lista;
    }
    
    public List<DatosGraficaSD> evolucionPesoUsuario(Long idUsuario, LocalDate fechaInicio, LocalDate fechaFin){
        List<Object[]> results = entityManager.createNativeQuery(
                "SELECT * FROM sp_evolucion_peso(:idUsuario, :fechaInicio, :fechaFin)")
                .setParameter("idUsuario", idUsuario)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

        List<DatosGraficaSD> lista = new ArrayList<>();
        for (Object[] row : results) {
            String fecha = (String) row[0];
            Number pesoNumber = (Number) row[1];
            double pesoUsado = pesoNumber.doubleValue();
            lista.add(new DatosGraficaSD(fecha, pesoUsado));
        }
        return lista;
    }
    
    public List<DatosGraficaSL> evolucionPGC(Long idUsuario, LocalDate fechaInicio, LocalDate fechaFin){
        List<Object[]> results = entityManager.createNativeQuery(
                "SELECT * FROM sp_evolucion_grasa(:idUsuario, :fechaInicio, :fechaFin)")
                .setParameter("idUsuario", idUsuario)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

        List<DatosGraficaSL> lista = new ArrayList<>();
        for (Object[] row : results) {
            String fecha = (String) row[0];
            Number pesoNumber = (Number) row[1];
            long pesoUsado = pesoNumber.longValue();
            lista.add(new DatosGraficaSL(fecha, pesoUsado));
        }
        return lista;
    }
}
