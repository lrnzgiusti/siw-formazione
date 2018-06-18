package it.uniroma3.siw.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Allievo;

@Component
public class ResponsabileValidator implements Validator
{
	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeResponsabile", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognomeResponsabile", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
	}
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Allievo.class.equals(aClass);
	}	
}
