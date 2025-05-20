/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.DatosGenerales;
import EderEsquivel.bison_system.entidadesGraficas.DatosGraficaSL;
import EderEsquivel.bison_system.entidadesGraficas.DatosGraficaSD;
import EderEsquivel.bison_system.model.DetallesEntrenamiento;
import EderEsquivel.bison_system.model.Ejercicios;
import EderEsquivel.bison_system.model.Entrenamientos;
import EderEsquivel.bison_system.model.SeriesEntrenamiento;
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
public class DatosDeUsuarioServices {
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
            double peso= pesoNumber.doubleValue();
            lista.add(new DatosGraficaSD(fecha, peso));
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
            long pgc = pesoNumber.longValue();
            lista.add(new DatosGraficaSL(fecha, pgc));
        }
        return lista;
    }
    
    public List<DatosGraficaSL> ejerciciosHechosDificultad(Long idUsuario,LocalDate fechaInicio,LocalDate fechaFin){
        List<Object[]> results = entityManager.createNativeQuery(
                    "SELECT * FROM sp_dificultad_por_usuario(:idUsuario, :fechaInicio, :fechaFin)")
                    .setParameter("idUsuario", idUsuario)
                    .setParameter("fechaInicio", fechaInicio)
                    .setParameter("fechaFin", fechaFin)
                    .getResultList();
        
        List<DatosGraficaSL> lista = new ArrayList<>();
        for (Object[] row : results) {
            String dificultad = (String) row[0];
            Number pesoNumber = (Number) row[1];
            long cantEjercicio = pesoNumber.longValue();
            lista.add(new DatosGraficaSL(dificultad, cantEjercicio));
        }
        return lista;
    }
    
    public List<DatosGraficaSL> zonasMEntrenadas(Long idUsuario,LocalDate fechaInicio,LocalDate fechaFin){
        List<Object[]> results = entityManager.createNativeQuery(
                    "SELECT * FROM sp_zonas_entrenadas_usuario(:idUsuario, :fechaInicio, :fechaFin)")
                    .setParameter("idUsuario", idUsuario)
                    .setParameter("fechaInicio", fechaInicio)
                    .setParameter("fechaFin", fechaFin)
                    .getResultList();
        
        List<DatosGraficaSL> lista = new ArrayList<>();
        for (Object[] row : results) {
            String zona = (String) row[0];
            Number numZonasEntre = (Number) row[1];
            long cantZonaEntre = numZonasEntre.longValue();
            lista.add(new DatosGraficaSL(zona, cantZonaEntre));
        }
        return lista;
    }
    
    public List<Entrenamientos> entrenamientosUsuario(Long idUsuario){
        List<Object[]> result=entityManager.createNativeQuery(
                "SELECT * FROM obtener_entrenamientos_usuario(:idUsuario)")
                .setParameter("idUsuario", idUsuario).getResultList();
        
        List<Entrenamientos> listaE=new ArrayList<>();
        for(Object[] row:result){
            Long idEntre=(Long) row[0];
            LocalDate fecha = row[1] != null
                ? ((java.sql.Date) row[1]).toLocalDate()
                : null;
            String nombEntre=(String) row[2];
            String descripcion=(String) row[3];
            Integer duracion=(Integer) row[4];
            String obs=(String) row[5];
            listaE.add(new Entrenamientos(idEntre,fecha,nombEntre,descripcion,duracion,obs));
        }
        return listaE;   
       
    }
    
    public List<DetallesEntrenamiento> detallesEntreUsuario(Long idEntrenamiento){
        List<Object[]> result=entityManager.createNativeQuery(
                "SELECT * FROM obtener_detalles_entrenamiento(:idEntrenamieto)")
                .setParameter("idEntrenamieto", idEntrenamiento).getResultList();
        
        List<DetallesEntrenamiento> listaDE=new ArrayList<>();
        for(Object[] row: result){
            Long idDetalle=(Long) row[0];
            Integer idEjercicio=(Integer) row[1];
            listaDE.add(new DetallesEntrenamiento(idDetalle,DatosGenerales.ejerciciosMap.get(idEjercicio)));
        }
        return listaDE;
    }
    
    public List<SeriesEntrenamiento> SeriesEntreUsuario(Long idDetalleS){
        List<Object[]> result=entityManager.createNativeQuery(
                "SELECT * FROM obtener_series_detalle(:idDetalleS)")
                .setParameter("idDetalleS", idDetalleS).getResultList();
        
        List<SeriesEntrenamiento> listaSE=new ArrayList<>();
        for(Object[] row: result){
            Integer numSerie=(Integer) row[0];
            Integer rep=(Integer) row[1];
            Double pesoUsado=(Double) row[2];
            listaSE.add(new SeriesEntrenamiento(numSerie,rep,pesoUsado));
        }
        return listaSE;
    }
    
}
