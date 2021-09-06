/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions.exceptions;

/**
 *
 * @author Luca
 */
public class NameOrSurnameIsNullException extends BadParameterException{

    public NameOrSurnameIsNullException(RegistrationParameter parameter) {
        super("Il parametro "+parameter+ " is null");
    }
}
