package it.uniroma3.siw.controller.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Responsabile;

@Component
public class ResponsabileValidator implements Validator
{
	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeResponsabile", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognomeResponsabile", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		
		Responsabile responsabile = (Responsabile) o;
		final String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		//match nel caso in cui venga inserita una mail non valida
		if(!Pattern.matches(EMAIL_PATTERN, responsabile.getEmail()))
			errors.rejectValue("email", "notemail");
	}
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Responsabile.class.equals(aClass);
	}	
}
