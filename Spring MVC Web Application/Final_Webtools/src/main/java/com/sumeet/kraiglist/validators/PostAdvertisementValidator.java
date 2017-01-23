package com.sumeet.kraiglist.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.sumeet.kraiglist.pojo.Advertisements;

import org.springframework.validation.ValidationUtils;

@Component
public class PostAdvertisementValidator implements Validator {

	private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
	
    public boolean supports(Class aClass)
    {
        return aClass.equals(Advertisements.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Pattern pattern = Pattern.compile(IMAGE_PATTERN);
        Matcher matcher;
        MultipartFile imageFile;
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.advertisements", "Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.advertisements", "Price Required");
      //  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearOld", "error.invalid.advertisements", "Years Old Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imageFile", "error.invalid.advertisements", "Photos Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripition", "error.invalid.advertisements", "Description Required");
    
        Advertisements advertisements = (Advertisements) obj;
        imageFile = advertisements.getImageFile();
        matcher = pattern.matcher(imageFile.getOriginalFilename());
        
        if(0 == imageFile.getSize()) {
            errors.rejectValue("imageFile","error.invalid.advertisements","File is empty");
         }
               if(!matcher.matches()) {
              errors.rejectValue("imageFile","error.invalid.advertisements","Invalid Image Format");
         }
         
         if(8000000 < imageFile.getSize()) {
              errors.rejectValue("imageFile","error.invalid.advertisements","File size is over 8mb !");
         } 
    }
}
