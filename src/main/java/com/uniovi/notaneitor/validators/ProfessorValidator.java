package com.uniovi.notaneitor.validators;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.entities.User;
import com.uniovi.notaneitor.services.ProfessorService;
import com.uniovi.notaneitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfessorValidator implements Validator {
    @Autowired
    private ProfessorService professorService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Professor.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
        if (professor.getDni().length() != 9) {
            errors.rejectValue("dni", "Error.professor.dni.length");

        } else if (!Character.isLetter(professor.getDni().charAt(8))) {
            errors.rejectValue("dni", "Error.professor.dni.letter");
        } else if (professorService.getProfessorByDni(professor.getDni()) != null) {
            errors.rejectValue("dni", "Error.professor.dni.duplicate");
        }

        if (professor.getNombre().length() < 2) {
            errors.rejectValue("nombre", "Error.professor.nombre.length");
        }

        for (int i = 0; i < professor.getCategoria().length(); i++) {
            if (!Character.isLetter(professor.getCategoria().charAt(i))){
                errors.rejectValue("categoria", "Error.professor.categoria.letter");
                break;
            }
        }
    }
}
