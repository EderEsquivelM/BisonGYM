/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package EderEsquivel.bison_system;

/**
 *
 * @author edere
 */
public class CamposVaciosException extends Exception {

    /**
     * Creates a new instance of <code>CamposVaciosException</code> without
     * detail message.
     */
    public CamposVaciosException() {
    }

    /**
     * Constructs an instance of <code>CamposVaciosException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CamposVaciosException(String msg) {
        super(msg);
    }
}
