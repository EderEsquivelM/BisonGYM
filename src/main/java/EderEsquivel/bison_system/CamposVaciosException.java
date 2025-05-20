/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package EderEsquivel.bison_system;

/**
 * Excepcion personalizada para verificar campos vacios en el resto del codigo
 *
 * @author edere
 */
public class CamposVaciosException extends Exception {

    /**
     *
     * Constructo para cuando no se quiera mandar un mensaje personalizado y
     * solo mandar la excepcion
     * 
     */
    public CamposVaciosException() {
    }

    /**
     * @param msg es el mensaje que enviara a un catch
     * 
     * Contructor que se utiliza para mandar un mensaje personalizado
     * 
     */
    public CamposVaciosException(String msg) {
        super(msg);
    }
}
