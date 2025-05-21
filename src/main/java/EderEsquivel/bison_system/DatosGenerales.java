/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system;

import EderEsquivel.bison_system.model.Dificultades;
import EderEsquivel.bison_system.model.Ejercicios;
import EderEsquivel.bison_system.model.Musculos;
import EderEsquivel.bison_system.model.Usuarios;
import EderEsquivel.bison_system.model.ZonasAnatomicas;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * Clase utilizada para consultar datos generales y funciones rudimentales.
 * 
 * Contiene mapas estatico sobre datos de zonas anatomicas ,musculos,
 * dificultades y ejercicios.
 * 
 * @author edere
 */
public class DatosGenerales {
    
    /**
     * 
     * Guarda los datos del usuario que inicio sesion.
     * 
     */
    private static Usuarios infoUsuarios;
    
    /**
     *
     * Mapa estatico de zonas anatomicas con identificadores y nombres.
     * 
     * La clave es Integer, es la misma que la ID de la zona muscular y el 
     * valor es el objeto {@link ZonasAnatomicas}.
     * 
     * Se utiliza para cuando no haya conexion a internet y asi mostrar los 
     * datos sin esta misma.
     * 
     */
    public static final Map<Integer, ZonasAnatomicas> zonasAnatomicasMap = new HashMap<Integer, ZonasAnatomicas>() {{
        put(1, new ZonasAnatomicas(1, "Hombros"));
        put(2, new ZonasAnatomicas(2, "Brazos"));
        put(3, new ZonasAnatomicas(3, "Antebrazos"));
        put(4, new ZonasAnatomicas(4, "Pecho"));
        put(5, new ZonasAnatomicas(5, "Espalda"));
        put(6, new ZonasAnatomicas(6, "Abdomen"));
        put(7, new ZonasAnatomicas(7, "Glúteos"));
        put(8, new ZonasAnatomicas(8, "Piernas"));
        put(9, new ZonasAnatomicas(9, "Pantorrillas"));
        put(10, new ZonasAnatomicas(10, "Cuello"));
        put(11, new ZonasAnatomicas(11, "Manos"));
        put(12, new ZonasAnatomicas(12, "Pies"));
    }};

    /**
     *
     * Mapa estatico de musculos con propiedades anatomicas.
     * 
     * La clave es Integer, es la misma que la ID del musculo y el valor es el 
     * objeto {@link Musculos}.
     * 
     * Se utiliza para cuando no haya conexion a internet y asi mostrar los 
     * datos sin esta misma.
     * 
     */
    public static final Map<Integer, Musculos> musculosMap = new HashMap<Integer, Musculos>() {{
        put(1, new Musculos(1, "Deltoides", zonasAnatomicasMap.get(1), "Permite el movimiento del brazo en varias direcciones"));
        put(2, new Musculos(2, "Bíceps braquial", zonasAnatomicasMap.get(2), "Flexiona el codo y supina el antebrazo"));
        put(3, new Musculos(3, "Tríceps braquial", zonasAnatomicasMap.get(2), "Extiende el codo"));
        put(4, new Musculos(4, "Flexores del antebrazo", zonasAnatomicasMap.get(3), "Flexionan la muñeca y los dedos"));
        put(5, new Musculos(5, "Extensores del antebrazo", zonasAnatomicasMap.get(3), "Extienden la muñeca y los dedos"));
        put(6, new Musculos(6, "Pectoral mayor", zonasAnatomicasMap.get(4), "Flexiona, aduce y rota medialmente el brazo"));
        put(7, new Musculos(7, "Pectoral menor", zonasAnatomicasMap.get(4), "Desciende el hombro y eleva las costillas"));
        put(8, new Musculos(8, "Trapecio", zonasAnatomicasMap.get(5), "Mueve, rota y estabiliza la escápula"));
        put(9, new Musculos(9, "Dorsal ancho", zonasAnatomicasMap.get(5), "Extiende, aduce y rota el brazo"));
        put(10, new Musculos(10, "Romboides", zonasAnatomicasMap.get(5), "Retrae la escápula"));
        put(11, new Musculos(11, "Erectores espinales", zonasAnatomicasMap.get(5), "Extienden y estabilizan la columna"));
        put(12, new Musculos(12, "Recto abdominal", zonasAnatomicasMap.get(6), "Flexiona el tronco"));
        put(13, new Musculos(13, "Oblicuo externo", zonasAnatomicasMap.get(6), "Rotación y flexión lateral del tronco"));
        put(14, new Musculos(14, "Oblicuo interno", zonasAnatomicasMap.get(6), "Rotación y flexión lateral del tronco"));
        put(15, new Musculos(15, "Transverso abdominal", zonasAnatomicasMap.get(6), "Estabiliza el core"));
        put(16, new Musculos(16, "Glúteo mayor", zonasAnatomicasMap.get(7), "Extensión y rotación externa de la cadera"));
        put(17, new Musculos(17, "Glúteo medio", zonasAnatomicasMap.get(7), "Abducción y estabilización de la pelvis"));
        put(18, new Musculos(18, "Glúteo menor", zonasAnatomicasMap.get(7), "Abducción y rotación interna de la cadera"));
        put(19, new Musculos(19, "Cuádriceps", zonasAnatomicasMap.get(8), "Extensión de la rodilla"));
        put(20, new Musculos(20, "Isquiotibiales", zonasAnatomicasMap.get(8), "Flexión de la rodilla"));
        put(21, new Musculos(21, "Gastrocnemio", zonasAnatomicasMap.get(9), "Flexión plantar del pie y flexión de la rodilla"));
        put(22, new Musculos(22, "Sóleo", zonasAnatomicasMap.get(9), "Flexión plantar del pie"));
        put(23, new Musculos(23, "Esternocleidomastoideo", zonasAnatomicasMap.get(10), "Rotación e inclinación lateral de la cabeza"));
        put(24, new Musculos(24, "Músculos intrínsecos de la mano", zonasAnatomicasMap.get(11), "Movimientos finos de los dedos"));
        put(25, new Musculos(25, "Músculos intrínsecos del pie", zonasAnatomicasMap.get(12), "Estabilidad y movimiento de los dedos del pie"));
    }};
    
    /**
     *
     * Mapa estatico de dificulates de los ejercicios.
     * 
     * La clave es Integer,es la misma que la ID de la dificultad y el valor es
     * {@link Dificultades}.
     * 
     * Se utiliza para cuando no haya conexion a internet y asi mostrar los 
     * datos sin esta misma.
     * 
     */
    public static final Map<Integer, Dificultades> dificultadesMap = new HashMap<Integer, Dificultades>() {{
        put(1, new Dificultades(1, "Principiante"));
        put(2, new Dificultades(2, "Intermedio"));
        put(3, new Dificultades(3, "Avanzado"));
    }};
    
    /**
     *
     * Mapa estatico de Ejercicios.
     * 
     * La clave es Integer,es la misma que la ID del ejercicio y el valor es 
     * {@link Ejercicios}.
     * 
     * Se utiliza para cuando no haya conexion a internet y asi mostrar los 
     * datos sin esta misma.
     * 
     */
    public static final Map<Integer, Ejercicios> ejerciciosMap = new HashMap<Integer, Ejercicios>() {{
        put(1, new Ejercicios(1, "Abdominales con Peso", 
            "Sentado en el suelo, piernas elevadas o flexionadas, gira el torso de lado a lado sosteniendo un disco, mancuerna o balón medicinal.", 
            musculosMap.get(12), musculosMap.get(13), dificultadesMap.get(2)));
        
        put(2, new Ejercicios(2, "Abdominal Inclinado con Mancuerna", 
            "Ejercicio realizado en un banco inclinado (ajustado entre 30°-45°), sujetando una mancuerna en el pecho o detrás de la cabeza.", 
            musculosMap.get(12), musculosMap.get(11), dificultadesMap.get(1)));
            
        put(3, new Ejercicios(3, "Abductores en Maquina", 
            "Ejercicio realizado en una máquina de abducción de cadera, sentado o de pie (según el diseño).", 
            musculosMap.get(17), null, dificultadesMap.get(1)));
            
        put(4, new Ejercicios(4, "Aperturas con Mancuernas", 
            "Ejercicio de aislamiento para el pecho, realizado en un banco plano o inclinado.", 
            musculosMap.get(7), musculosMap.get(3), dificultadesMap.get(2)));
            
        put(5, new Ejercicios(5, "Curl de Biceps", 
            "Ejercicio clásico de aislamiento para bíceps, realizado de pie o sentado.", 
            musculosMap.get(3), musculosMap.get(1), dificultadesMap.get(1)));
            
        put(6, new Ejercicios(6, "Curl de Biceps con Barra", 
            "Ejercicio básico para bíceps donde, de pie, se levanta una barra recta o Z agarrada con las palmas hacia arriba.", 
            musculosMap.get(2), musculosMap.get(1), dificultadesMap.get(1)));
            
        put(7, new Ejercicios(7, "Curl de Biceps Inclinado", 
            "Ejercicio de aislamiento para bíceps realizado en un banco ajustado a 45-60° de inclinación.", 
            musculosMap.get(2), musculosMap.get(1), dificultadesMap.get(2)));
            
        put(8, new Ejercicios(8, "Curl Martillo con Mancuernas", 
            "Ejercicio de aislamiento para brazos donde se flexionan los codos manteniendo un agarre neutro.", 
            musculosMap.get(2), null, dificultadesMap.get(1)));
            
        put(9, new Ejercicios(9, "Curl de Muñeca con Barra", 
            "Ejercicio de aislamiento para antebrazos donde, sentado en un banco con los antebrazos apoyados sobre los muslos.", 
            musculosMap.get(4), null, dificultadesMap.get(1)));
            
        put(10, new Ejercicios(10, "Curl de Muñeca con Mancuerna", 
            "Ejercicio de aislamiento para fortalecer los antebrazos.", 
            musculosMap.get(4), null, dificultadesMap.get(1)));
            
        put(11, new Ejercicios(11, "Curl de Pierna Acostado", 
            "Ejercicio de aislamiento realizado en una máquina de curl femoral.", 
            musculosMap.get(20), musculosMap.get(18), dificultadesMap.get(1)));
            
        put(12, new Ejercicios(12, "Curl de Pierna Sentado", 
            "Ejercicio de aislamiento para isquiosurales realizado en una máquina específica.", 
            musculosMap.get(20), null, dificultadesMap.get(1)));
            
        put(13, new Ejercicios(13, "Desplante con Mancuernas", 
            "Ejercicio unilateral donde, de pie sosteniendo mancuernas en cada mano.", 
            musculosMap.get(19), musculosMap.get(20), dificultadesMap.get(2)));
            
        put(14, new Ejercicios(14, "Dominadas Asistidas", 
            "Ejercicio de fuerza de tracción vertical donde se utiliza una máquina de asistencia.", 
            musculosMap.get(9), musculosMap.get(2), dificultadesMap.get(2)));
            
        put(15, new Ejercicios(15, "Elevaciones Horizontales", 
            "Ejercicio de aislamiento para hombros (deltoides anteriores).", 
            musculosMap.get(1), musculosMap.get(8), dificultadesMap.get(1)));
            
        put(16, new Ejercicios(16, "Elevaciones Laterales con Mancuernas", 
            "Ejercicio de aislamiento para hombros donde, de pie o sentado.", 
            musculosMap.get(1), musculosMap.get(8), dificultadesMap.get(2)));
            
        put(17, new Ejercicios(17, "Elevaciones Laterales con Polea", 
            "Ejercicio de aislamiento para deltoides medios realizado con una polea baja.", 
            musculosMap.get(1), musculosMap.get(8), dificultadesMap.get(2)));
            
        put(18, new Ejercicios(18, "Elevaciones Laterales en Máquina", 
            "Ejercicio de aislamiento para deltoides medios realizado en una máquina específica.", 
            musculosMap.get(1), null, dificultadesMap.get(1)));
            
        put(19, new Ejercicios(19, "Extensión de Pierna en Máquina", 
            "Ejercicio de aislamiento para cuádriceps realizado en una máquina específica.", 
            musculosMap.get(19), null, dificultadesMap.get(1)));
            
        put(20, new Ejercicios(20, "Extensión de Tríceps con Mancuerna", 
            "Ejercicio de aislamiento para tríceps donde, acostado en un banco plano o sentado.", 
            musculosMap.get(3), musculosMap.get(1), dificultadesMap.get(2)));
            
        put(21, new Ejercicios(21, "Extensión de Tríceps Sentado con Mancuerna", 
            "Ejercicio de aislamiento para tríceps donde, sentado en un banco.", 
            musculosMap.get(3), musculosMap.get(1), dificultadesMap.get(2)));
            
        put(22, new Ejercicios(22, "Fondos Asistidos", 
            "Ejercicio de fuerza de empuje para trabajar tríceps, pectorales inferiores y hombros delanteros.", 
            musculosMap.get(3), null, dificultadesMap.get(2)));
            
        put(23, new Ejercicios(23, "Hip Thrust con Barra", 
            "Ejercicio de fuerza para glúteos y cadena posterior.", 
            musculosMap.get(16), null, dificultadesMap.get(2)));
            
        put(24, new Ejercicios(24, "Jalón al Pecho con Agarre Cerrado", 
            "Ejercicio de fuerza de tracción vertical en polea alta.", 
            musculosMap.get(9), musculosMap.get(2), dificultadesMap.get(2)));
            
        put(25, new Ejercicios(25, "Levantamiento de Gemelos con Barra", 
            "Ejercicio de aislamiento para gemelos (músculos gastrocnemio y sóleo).", 
            musculosMap.get(21), null, dificultadesMap.get(2)));
            
        put(26, new Ejercicios(26, "Levantamiento de Gemelos de Pie", 
            "Ejercicio de aislamiento para desarrollar los músculos gemelos.", 
            musculosMap.get(21), musculosMap.get(22), dificultadesMap.get(2)));
            
        put(27, new Ejercicios(27, "Levantamiento de Gemelos Sentado", 
            "Ejercicio de aislamiento para pantorrillas que enfoca principalmente el músculo sóleo.", 
            musculosMap.get(22), musculosMap.get(21), dificultadesMap.get(2)));
            
        put(28, new Ejercicios(28, "Preacher Curl con Barra", 
            "Ejercicio de aislamiento para bíceps que utiliza un banco predicador.", 
            musculosMap.get(2), null, dificultadesMap.get(2)));
            
        put(29, new Ejercicios(29, "Press de Banca con Barra", 
            "Ejercicio compuesto para desarrollar fuerza y masa muscular en el pecho, hombros y tríceps.", 
            musculosMap.get(6), musculosMap.get(3), dificultadesMap.get(3)));
            
        put(30, new Ejercicios(30, "Press de Pecho Inclinado con Mancuernas", 
            "Ejercicio compuesto para desarrollar la parte superior del pecho.", 
            musculosMap.get(6), null, dificultadesMap.get(3)));
            
        put(31, new Ejercicios(31, "Press de Pierna en Prensa", 
            "Ejercicio compuesto para trabajar piernas y glúteos en una máquina de prensa.", 
            musculosMap.get(19), null, dificultadesMap.get(2)));
            
        put(32, new Ejercicios(32, "Press Militar con Barra", 
            "Ejercicio compuesto de empuje vertical para desarrollar hombros.", 
            musculosMap.get(1), null, dificultadesMap.get(3)));
            
        put(33, new Ejercicios(33, "Press Militar con Mancuernas", 
            "Ejercicio compuesto de empuje vertical para desarrollar hombros.", 
            musculosMap.get(1), null, dificultadesMap.get(3)));
            
        put(34, new Ejercicios(34, "Remo con Barra", 
            "Ejercicio compuesto de tracción horizontal para desarrollar espalda.", 
            musculosMap.get(9), musculosMap.get(2), dificultadesMap.get(3)));
            
        put(35, new Ejercicios(35, "Remo con Mancuerna", 
            "Ejercicio unilateral de tracción horizontal para desarrollar espalda.", 
            musculosMap.get(9), musculosMap.get(1), dificultadesMap.get(2)));
            
        put(36, new Ejercicios(36, "Remo con Mancuernas", 
            "Ejercicio unilateral o bilateral de tracción horizontal para desarrollar espalda.", 
            musculosMap.get(9), musculosMap.get(2), dificultadesMap.get(3)));
            
        put(37, new Ejercicios(37, "Remo Inclinado en Máquina", 
            "Ejercicio de tracción horizontal en máquina con asiento inclinado.", 
            musculosMap.get(8), musculosMap.get(1), dificultadesMap.get(1)));
            
        put(38, new Ejercicios(38, "Remo Sentado con Cable", 
            "Ejercicio de tracción horizontal en máquina de polea baja.", 
            musculosMap.get(9), musculosMap.get(2), dificultadesMap.get(2)));
            
        put(39, new Ejercicios(39, "Sentadilla con Barra Libre", 
            "Ejercicio compuesto rey para desarrollar fuerza y masa muscular en piernas y core.", 
            musculosMap.get(19), null, dificultadesMap.get(3)));
            
        put(40, new Ejercicios(40, "Sentadilla con Mancuernas", 
            "Ejercicio compuesto para desarrollar fuerza y músculo en piernas y core.", 
            musculosMap.get(19), null, dificultadesMap.get(2)));
            
        put(41, new Ejercicios(41, "Sentadilla Hack", 
            "Ejercicio compuesto para piernas y glúteos, realizado en máquina específica o con barra libre.", 
            musculosMap.get(19), musculosMap.get(16), dificultadesMap.get(2)));
    }};
    
    /**
     *
     * @param idZona Es la Zona Muscular.
     * @return una lista de {@link Musculos} de cierta zona anatomica.
     * 
     * @implNote Este metodo se utiliza para obtener los musculos de una zona.
     */
    public static List<Musculos> obtenerMusculosDeZona(int idZona) {
        List<Musculos> musculosDeZona = new ArrayList<>();

        for (Musculos m : musculosMap.values()) {
            if (m.getId_zona() != null && m.getId_zona().getId_zona() == idZona) {
                musculosDeZona.add(m);
            }
        }

        return musculosDeZona;
    }

    /**
     *
     * @param idZona Es la Zona Muscular.
     * @return una lista de {@link Ejericios}.
     * 
     * @implNote Este metodo se utiliza para obtener los ejercicios de una zona
     * muscular, utiliza el metodo obtenerMusculosDeZona para hacer mas eficiente
     * la busqueda de los ejercicios.
     */
    public static List<Ejercicios> obtenerEjerciciosPorZona(int idZona) {
        //Obtiene los musculos de una zona
        List<Musculos> musculosDeZona = obtenerMusculosDeZona(idZona);
        
        //Guarda en el Set para que no haya repeticion de musculos por zona
        Set<Musculos> musculosSet = new HashSet<>(musculosDeZona);
        List<Ejercicios> ejerciciosFiltrados = new ArrayList<>();

        for (Ejercicios e : ejerciciosMap.values()) {
            Musculos principal = e.getMusculoPrincipal();
            if (principal != null && musculosSet.contains(principal)) {
                ejerciciosFiltrados.add(e);
            }
        }

        // Ordenar alfabéticamente por nombre
        ejerciciosFiltrados.sort(Comparator.comparing(Ejercicios::getNombre));

        return ejerciciosFiltrados;
    }

    /**
     *
     * @return Un valor booleano
     * 
     * @implNote Este metodo verifica que haya conexion a internet ,ayuda a 
     * verificar si se pueden hacer consultas al a base de datos.
     */
    public static boolean hayConexion() {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("HEAD");
            conexion.setConnectTimeout(3000);
            conexion.connect();
            return (conexion.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (IOException e) {
            return false;
        }
    }
    
    /**
     *
     * @param fechaSinFormato Es una fecha de tipo Date .
     * @return Una fecha de tipo LocalDate.
     * 
     * @implNote Este metodo cambia el tipo de dato de Date a LocalDate y sea
     * mas facil de identificar en la base de datos.
     */
    public static LocalDate cambioFecha(Date fechaSinFormato){
        if(fechaSinFormato!=null){
            return fechaSinFormato.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        else{
            return null;
        }
    }
    
    

    /**
     *
     * @return Los datos del usuario que inicio sesion.
     */
    public static Usuarios getInfoUsuarios() {
        return infoUsuarios;
    }

    /**
     *
     * @param infoUsuarios Datos del usuario en objeto {@link Usuarios}.
     * 
     * @implNote Ayuda a sincronizar los cambios de informacion del usuario en
     * la base de datos y en le programa.
     */
    public static void setInfoUsuarios(Usuarios infoUsuarios) {
        DatosGenerales.infoUsuarios = infoUsuarios;
    }

    /**
     *
     * @param correo Correo de un usuario.
     * @return Un valor bool
     * 
     * @implNote Este metodo ayuda a verificar si la extencio de correo es 
     * correcta.
     */
    public static boolean correoValido(String correo) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+(com|org|net|edu|gob|mx)$";
        return correo.matches(regex);
    }
   

    
    
}
