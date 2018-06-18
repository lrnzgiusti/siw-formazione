package it.uniroma3.siw.controller.validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Attivita;

@Component
public class AttivitaValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz)
	{
		return Attivita.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeAttivita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataAttivita", "required");
		
		if(!errors.hasErrors())
		{
			Attivita a = (Attivita)target;
			if(a.getDataAttivita().before(new Date()))
				errors.rejectValue("dataAttivita", "before");
		}
	}

}
