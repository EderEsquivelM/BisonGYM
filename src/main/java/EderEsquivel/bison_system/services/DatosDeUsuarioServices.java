/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.services;

import EderEsquivel.bison_system.DatosGenerales;
import EderEsquivel.bison_system.entidadesGraficas.DatosGraficaSL;
import EderEsquivel.bison_system.entidadesGraficas.DatosGraficaSD;
import EderEsquivel.bison_system.model.DetallesEntrenamiento;
import EderEsquivel.bison_system.model.Entrenamientos;
import EderEsquivel.bison_system.model.SeriesEntrenamiento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *Servicio para gestionar y consultar datos estadisticos y de los entrenamientos
 * del usuario.
 * 
 * @author edere
 */
@Service
public class DatosDeUsuarioServices {
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     *Obtiene estadísticas de entrenamientos por mes para un usuario específico.
     * 
     * Consulta el número total de entrenamientos agrupados por mes dentro del
     * rango de fechas especificado.
     * 
     * @param idUsuario ID del usuario a consultar.
     * @param fechaInicio Fecha de inicio del periodo.
     * @param fechaFin Fecha de fin del periodo.
     * @return Lista de{@link DatosGraficaSL} con campo = Mes y Dato = Total de entrenamientos.
     */
    public List<DatosGraficaSL> EntrenamientosPorMes(Long idUsuario, LocalDate fechaInicio, LocalDate fechaFin) {
        //Guarda la consulta en una Lista<Object> 
        List<Object[]> results = entityManager.createNativeQuery("SELECT * FROM sp_entrenamientos_fechas(:id, :fi, :ff)")
                .setParameter("id", idUsuario)
                .setParameter("fi", fechaInicio)
                .setParameter("ff", fechaFin)
                .getResultList();
        
        List<DatosGraficaSL> lista = new ArrayList<>();
        
        //Recorre la lista de Object y castea cada campo
        for (Object[] row : results) {
            String mes = (String) row[0];
            Number totalNumber = (Number) row[1]; 
            long total = totalNumber.longValue();
            lista.add(new DatosGraficaSL(mes, total));
        }
        return lista;
    }
    
    /**
     *Obtiene la evolucion del peso utilizado en un ejercicio específico.
     * 
     * Muestra el progreso en el levantamiento de pesos para un ejercicio 
     * particular durante el período solicitado.
     * 
     * @param idUsuario ID del usuario a consultar.
     * @param idEjercicio ID del ejercicio específico.
     * @param fechaInicio Fecha de inicio del periodo.
     * @param fechaFin Fecha de fin del periodo.
     * @return Lista de{@link DatosGraficaSD} con campo = Fecha del 
     * entrenemiento y Dato = Peso maximo utilizado
     */
    public List<DatosGraficaSD> evolucionPesoCargado(Long idUsuario, Integer idEjercicio, LocalDate fechaInicio, LocalDate fechaFin) {
        //Guarda la consulta en una Lista<Object>
        List<Object[]> results = entityManager.createNativeQuery(
                "SELECT * FROM sp_evolucion_peso_cargado(:idUsuario, :idEjercicio, :fechaInicio, :fechaFin)")
                .setParameter("idUsuario", idUsuario)
                .setParameter("idEjercicio", idEjercicio)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

        List<DatosGraficaSD> lista = new ArrayList<>();
        
        //Recorre la lista de Object y castea cada campo
        for (Object[] row : results) {
            // Cast directo a Date y luego conversión a LocalDate
            String fecha = (String) row[0];
            Number pesoNumber = (Number) row[1];
            double pesoUsado = pesoNumber.doubleValue();
            lista.add(new DatosGraficaSD(fecha, pesoUsado));
        }
        return lista;
    }
    
    /**
     *Obtiene la evolución del peso corporal del usuario.
     * 
     * Consulta el registro historico de medidas corporales para mostrar el progreso
     * en el cambio de peso.
     * 
     * @param idUsuario ID del usuario a consultar.
     * @param fechaInicio Fecha de inicio del periodo.
     * @param fechaFin Fecha de fin del periodo.
     * @return Lista de{@link DatosGraficaSD} con campo = Fecha de medicion
     * y Dato = Peso registrado
     */
    public List<DatosGraficaSD> evolucionPesoUsuario(Long idUsuario, LocalDate fechaInicio, LocalDate fechaFin){
        //Guarda la consulta en una Lista<Object>
        List<Object[]> results = entityManager.createNativeQuery(
                "SELECT * FROM sp_evolucion_peso(:idUsuario, :fechaInicio, :fechaFin)")
                .setParameter("idUsuario", idUsuario)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

        List<DatosGraficaSD> lista = new ArrayList<>();
        
        //Recorre la lista de Object y castea cada campo
        for (Object[] row : results) {
            String fecha = (String) row[0];
            Number pesoNumber = (Number) row[1];
            double peso= pesoNumber.doubleValue();
            lista.add(new DatosGraficaSD(fecha, peso));
        }
        return lista;
    }
    
    /**
     * Obtiene la evolución del porcentaje de grasa corporal del usuario.
     * 
     * Consulta el registro historico de medidas corporales para mostrar el progreso
     * en el cambio del porcentaje de grasa corporal
     * 
     * @param idUsuario ID del usuario a consultar.
     * @param fechaInicio Fecha de inicio del periodo.
     * @param fechaFin Fecha de fin del periodo.
     * @return Lista de{@link DatosGraficaSL} con campo = Fecha de medicion
     * y Dato = Porcentaje grasa corporal.
     */
    public List<DatosGraficaSL> evolucionPGC(Long idUsuario, LocalDate fechaInicio, LocalDate fechaFin){
        //Guarda la consulta en una Lista<Object>
        List<Object[]> results = entityManager.createNativeQuery(
                "SELECT * FROM sp_evolucion_grasa(:idUsuario, :fechaInicio, :fechaFin)")
                .setParameter("idUsuario", idUsuario)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();

        List<DatosGraficaSL> lista = new ArrayList<>();
        
        //Recorre la lista de Object y castea cada campo
        for (Object[] row : results) {
            String fecha = (String) row[0];
            Number pesoNumber = (Number) row[1];
            long pgc = pesoNumber.longValue();
            lista.add(new DatosGraficaSL(fecha, pgc));
        }
        return lista;
    }
    
    /**
     *
     * @param idUsuario ID del usuario a consultar.
     * @param fechaInicio Fecha de inicio del periodo.
     * @param fechaFin Fecha de fin del periodo.
     * @return Lista de{@link DatosGraficaSL} con Campo = Nivel de dificultad
     * y Dato = Numero de ejercicios hechos con esa dificultad.
     */
    public List<DatosGraficaSL> ejerciciosHechosDificultad(Long idUsuario,LocalDate fechaInicio,LocalDate fechaFin){
        //Guarda la consulta en una Lista<Object>
        List<Object[]> results = entityManager.createNativeQuery(
                    "SELECT * FROM sp_dificultad_por_usuario(:idUsuario, :fechaInicio, :fechaFin)")
                    .setParameter("idUsuario", idUsuario)
                    .setParameter("fechaInicio", fechaInicio)
                    .setParameter("fechaFin", fechaFin)
                    .getResultList();
        
        List<DatosGraficaSL> lista = new ArrayList<>();
        
        //Recorre la lista de Object y castea cada campo
        for (Object[] row : results) {
            String dificultad = (String) row[0];
            Number pesoNumber = (Number) row[1];
            long cantEjercicio = pesoNumber.longValue();
            lista.add(new DatosGraficaSL(dificultad, cantEjercicio));
        }
        return lista;
    }
    
    /**
     *
     * @param idUsuario ID del usuario a consultar.
     * @param fechaInicio Fecha de inicio del periodo.
     * @param fechaFin Fecha de fin del periodo.
     * @return Lista de{@link DatosGraficaSL} con campo = zona entrenada
     * y Dato = numero de veces que se entreno la zona.
     */
    public List<DatosGraficaSL> zonasMEntrenadas(Long idUsuario,LocalDate fechaInicio,LocalDate fechaFin){
        //Guarda la consulta en una Lista<Object>
        List<Object[]> results = entityManager.createNativeQuery(
                    "SELECT * FROM sp_zonas_entrenadas_usuario(:idUsuario, :fechaInicio, :fechaFin)")
                    .setParameter("idUsuario", idUsuario)
                    .setParameter("fechaInicio", fechaInicio)
                    .setParameter("fechaFin", fechaFin)
                    .getResultList();
        
        List<DatosGraficaSL> lista = new ArrayList<>();
        
        //Recorre la lista de Object y castea cada campo
        for (Object[] row : results) {
            String zona = (String) row[0];
            Number numZonasEntre = (Number) row[1];
            long cantZonaEntre = numZonasEntre.longValue();
            lista.add(new DatosGraficaSL(zona, cantZonaEntre));
        }
        return lista;
    }
    
    /**
     * Obtiene todos los entrenamientos registrados por un usuario específico.
     * 
     * Consulta en la base de datos los entrenamientos realizados por el usuario,
     * incluyendo todos los datos relevantes de cada sesión. 
     * 
     * @param idUsuario ID del usuario a consultar.
     * @return Lista de objetos {@link Entrenamientos}.
     */
    public List<Entrenamientos> entrenamientosUsuario(Long idUsuario){
        //Guarda la consulta en una Lista<Object>
        List<Object[]> result=entityManager.createNativeQuery(
                "SELECT * FROM obtener_entrenamientos_usuario(:idUsuario)")
                .setParameter("idUsuario", idUsuario).getResultList();
        
        List<Entrenamientos> listaE=new ArrayList<>();
        
        //Recorre la lista de Object y castea cada campo
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
    
    /**
     * Obtiene los detalles específicos de un entrenamiento particular.
     * 
     *Consulta los ejercicios que componen un entrenamiento específico,
     *mostrando la relación entre el entrenamiento y cada ejercicio realizado
     * 
     * @param idEntrenamiento ID del entrenamiento a consultar.
     * @return Lista de objetos {@link DetallesEntrenamiento}.
     */
    public List<DetallesEntrenamiento> detallesEntreUsuario(Long idEntrenamiento){
        //Guarda la consulta en una Lista<Object>
        List<Object[]> result=entityManager.createNativeQuery(
                "SELECT * FROM obtener_detalles_entrenamiento(:idEntrenamieto)")
                .setParameter("idEntrenamieto", idEntrenamiento).getResultList();
        
        List<DetallesEntrenamiento> listaDE=new ArrayList<>();
        
        //Recorre la lista de Object y castea cada campo
        for(Object[] row: result){
            Long idDetalle=(Long) row[0];
            Integer idEjercicio=(Integer) row[1];
            listaDE.add(new DetallesEntrenamiento(idDetalle,DatosGenerales.ejerciciosMap.get(idEjercicio)));
        }
        return listaDE;
    }
    
    /**
     *Obtiene las series realizadas para un detalle de entrenamiento específico
     * 
     *Consulta el historial de series, repeticiones y pesos utilizados
     *para un ejercicio particular dentro de un entrenamiento.
     * 
     * @param idDetalleS ID del detalle del entrenamiento a consultar
     * @return Lista de objetos {@link SeriesEntrenamiento}.
     */
    public List<SeriesEntrenamiento> SeriesEntreUsuario(Long idDetalleS){
        //Guarda la consulta en una Lista<Object>
        List<Object[]> result=entityManager.createNativeQuery(
                "SELECT * FROM obtener_series_detalle(:idDetalleS)")
                .setParameter("idDetalleS", idDetalleS).getResultList();
        
        List<SeriesEntrenamiento> listaSE=new ArrayList<>();
        
        //Recorre la lista de Object y castea cada campo
        for(Object[] row: result){
            Integer numSerie=(Integer) row[0];
            Integer rep=(Integer) row[1];
            Double pesoUsado=(Double) row[2];
            listaSE.add(new SeriesEntrenamiento(numSerie,rep,pesoUsado));
        }
        return listaSE;
    }
    
}
