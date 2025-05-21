/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.entidadesGraficas;

/**
 * Clase que guarda los datos de un tipo de grafico con datos Double.
 * 
 * @author edere
 */
public class DatosGraficaSD {
    
    /**
     * Guarda el campo se esta graficando(ejemplo: kg,nombre del mes).
     */
    private String campo;
    
    /**
     * Guarda el valor del campo graficado.
     */
    private double dato;

    /**
     * Constructor que guarda el campo y su valor que se graficara.
     * 
     * @param campo Campo se esta graficando(ejemplo: kg,nombre del mes).
     * @param dato Valor del campo graficado.
     */
    public DatosGraficaSD(String campo, double dato) {
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
    public double getDato() {
        return dato;
    }

}
