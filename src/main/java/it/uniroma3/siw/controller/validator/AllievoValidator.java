package it.uniroma3.siw.controller.validator;

import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Responsabile;

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
	        
	        
	        Allievo allievo= (Allievo) o;
			final String EMAIL_PATTERN = 
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

			//match nel caso in cui venga inserita una mail non valida
			if(!Pattern.matches(EMAIL_PATTERN, allievo.getEmail()))
				errors.rejectValue("email", "notemail");
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
