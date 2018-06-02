package it.uniroma3.siw.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.CategoriaAttivita;

@Component
public class CategoriaAttivitaValidator implements Validator
{
	 @Override
	    public void validate(Object o, Errors errors) {

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeCategoriaAttivita", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizioneAttivita", "required");
	    }

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return CategoriaAttivita.class.equals(aClass);
	    }	
}
