package it.uniroma3.siw.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Centro;

@Component
public class CentroValidator implements Validator
{
	 @Override
	    public void validate(Object o, Errors errors) {

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeCentro", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailCentro", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefonoCentro", "required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capienzaMaxCentro", "required");
	       // ValidationUtils.rejectIfEmpty(errors, "capienzaMaxCentro", "required");
	        
	        Centro c = (Centro) o;
	        if(c.getCapienzaMaxCentro() < 0)
	        {
	        	System.out.println(c.getCapienzaMaxCentro());
	        	errors.rejectValue("capienzaMaxCentro", "negative");
	        }
	    }

	    @Override
	    public boolean supports(Class<?> aClass) {
	        return Centro.class.equals(aClass);
	    }	
}
