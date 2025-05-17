/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EderEsquivel.bison_system.entidadesGraficas;

/**
 *
 * @author edere
 */
public class EntrenamientoPorMes {
    private String mes;
    private Long total;

    public EntrenamientoPorMes(String mes, Long total) {
        this.mes = mes;
        this.total = total;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
    
    
}
