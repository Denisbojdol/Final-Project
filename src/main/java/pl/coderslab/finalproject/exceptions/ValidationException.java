package pl.coderslab.finalproject.exceptions;

import pl.coderslab.finalproject.securityEntity.securityService.UserData;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationException extends Exception {

    List<ObjectError> errors = new ArrayList<>();

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    public void addError(ObjectError error){
        this.errors.add(error);
    }

    public boolean hasErrors(){
        return errors.size() > 0;
    }
}
