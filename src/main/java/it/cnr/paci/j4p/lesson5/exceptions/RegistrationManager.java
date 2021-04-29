/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import exceptions.exceptions.BadParameterException;
import exceptions.exceptions.NameOrSurnameIsEmptyException;
import exceptions.exceptions.NameOrSurnameIsNullException;
import exceptions.exceptions.RegistrationParameter;

/**
 *
 * @author Luca
 */
public class RegistrationManager {
    
    private static RegistrationManager _instance = null;
    
    public static RegistrationManager getInstance() {
        if (_instance == null) {
            _instance = new RegistrationManager();
            return _instance;
        } else {
            return _instance;
        }
    }
    
    private RegistrationManager() {
        super();
    }
    
    public void register(String name, String surname)
            throws BadParameterException {
        
        if(name == null){
            throw new NameOrSurnameIsNullException(RegistrationParameter.NAME);
        }
        if(surname == null){
            throw new NameOrSurnameIsNullException(RegistrationParameter.SURNAME);
        }
        if(name.isEmpty()){
            throw new NameOrSurnameIsEmptyException(RegistrationParameter.NAME);
        }
        if(surname.isEmpty()){
            throw new NameOrSurnameIsEmptyException(RegistrationParameter.SURNAME);
        }
        
        
        
        
        
    }
    
    
    
}
