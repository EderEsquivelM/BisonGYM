/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.entidadesGraficas;

/**
 *Clase que guarda los datos de un tipo de grafico con datos Long.
 * 
 * @author edere
 */
public class DatosGraficaSL {
    
     /**
     * Guarda el campo se esta graficando(ejemplo: kg,nombre del mes).
     */
    private String campo;
    
     /**
     * Guarda el valor del campo graficado.
     */
    private Long dato;

    /**
     * Constructor que guarda el campo y su valor que se graficara.
     * 
     * @param campo Campo se esta graficando(ejemplo: kg,nombre del mes).
     * @param dato Valor del campo graficado.
     */
    public DatosGraficaSL(String campo, Long dato) {
        this.campo = campo;
        this.dato = dato;
    }

    /**
     *
     * @return el campo que se esta graficando.
     */
    public String getCampo() {
        return campo;
    }

    /**
     *
     * @return el valor de campo graficado.
     */
    public Long getDato() {
        return dato;
    }
    
}
