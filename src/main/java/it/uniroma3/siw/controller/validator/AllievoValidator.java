package it.uniroma3.siw.controller.validator;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Allievo;

@Component
public class AllievoValidator implements Validator
{
	 @Override
	    public void validate(Object o, Errors errors) {

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataNascita", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoNascita", "required");
	    }

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return Allievo.class.equals(aClass);
	    }

		public void validateToPrenotazione(@Valid Object o, Errors errors)
		{
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		}	
}
