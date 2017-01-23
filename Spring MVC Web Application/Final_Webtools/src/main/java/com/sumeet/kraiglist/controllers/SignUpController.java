package com.sumeet.kraiglist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumeet.kraiglist.DAO.UserDAO;
import com.sumeet.kraiglist.pojo.User;
import com.sumeet.kraiglist.validators.SignUpValidator;

@Controller
@RequestMapping("/signUp.htm")
public class SignUpController {
	@Autowired
	@Qualifier("signUpValidator")
	SignUpValidator signUpValidator;
	@Autowired
	UserDAO userDao;
	@InitBinder
    private void initBinder(WebDataBinder binder)
    {
		binder.setValidator(signUpValidator);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result)
        throws Exception
    {
		signUpValidator.validate(user, result);
        if(result.hasErrors())
            return "SignUp";
        try
        {
        //	UserDAO userDao = new UserDAO();
            String firstName = user.getFirstName().replaceAll("[^\\dA-Za-z]*$", "").trim();
            String lastName = user.getLastName().replaceAll("[^\\dA-Za-z]*$", "").trim();
            String username = user.getUsername().replaceAll("[^\\dA-Za-z]*$", "").trim();
            String huskyId = user.getHuskyId().replaceAll("[^\\d ]*$", "").trim();

            userDao.create(firstName,lastName,huskyId,user.getEmail(),user.getPhone(),username,user.getPassword());
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("Exception: ")).append(e.getMessage()).toString());
        }
        return "addedUser";
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public String initializeForm(@ModelAttribute("user")User user)
    {
        return "SignUp";
    }

}