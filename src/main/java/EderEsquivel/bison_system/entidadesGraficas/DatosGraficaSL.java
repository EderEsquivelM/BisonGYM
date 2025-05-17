/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.entidadesGraficas;

/**
 *
 * @author edere
 */
public class DatosGraficaSL {
    private String campo;
    private Long dato;

    public DatosGraficaSL(String campo, Long dato) {
        this.campo = campo;
        this.dato = dato;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Long getDato() {
        return dato;
    }

    public void setDato(Long dato) {
        this.dato = dato;
    }

    
    
    
}
