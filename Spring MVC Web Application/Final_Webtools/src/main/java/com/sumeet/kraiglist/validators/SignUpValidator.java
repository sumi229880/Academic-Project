package com.sumeet.kraiglist.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sumeet.kraiglist.pojo.User;

import org.springframework.validation.ValidationUtils;

@Component
public class SignUpValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "huskyId", "error.invalid.user", "Husky Id Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.user", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.invalid.user", "Phone Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "Username Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
    
        if(user.getPhone().length() > 10 || user.getPhone().length() < 10 ) {
        	errors.rejectValue("phone", "error.invalid.user", "Phone number should be of length 10 digit");	
        }
        
        if(user.getHuskyId().length() > 9 || user.getHuskyId().length() < 9 ) {
        	errors.rejectValue("huskyId", "error.invalid.user", "HuskyID should be of length 9");	
        }
    
    }
}
