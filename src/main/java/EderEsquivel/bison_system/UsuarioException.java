/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package EderEsquivel.bison_system;

/**
 *
 * Excepcion personalizada para verificar datos de usuario en todo el codigo
 * 
 * @author edere
 */
public class UsuarioException extends Exception {

    /**
     * Constructo para cuando no se quiera mandar un mensaje personalizado y
     * solo mandar la excepcion
     */
    public UsuarioException() {
    }

    /**
     * @param msg es el mensaje que enviara a un catch
     * 
     * Contructor que se utiliza para mandar un mensaje personalizado
     * 
     */
    public UsuarioException(String msg) {
        super(msg);
    }
}
