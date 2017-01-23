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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sumeet.kraiglist.DAO.UserDAO;
import com.sumeet.kraiglist.pojo.User;
import com.sumeet.kraiglist.validators.LoginValidator;

@Controller
@RequestMapping("/login.htm")
public class LoginController {
	@Autowired
	@Qualifier("loginValidator")
	LoginValidator loginValidator;
	
	@Autowired
	UserDAO userDao;
	
	
	@InitBinder("user")
    private void initBinder(WebDataBinder binder)
    {
		binder.setValidator(loginValidator);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request,HttpServletResponse response)
        throws Exception
    {
		loginValidator.validate(user, result);
        if(result.hasErrors())
            return "loginForm";
        try
        {
        	//UserDAO userDao = new UserDAO();
        	user = userDao.loginValidation(user.getUsername(), user.getPassword());
        	
        	//setting up the object in session scope
        	HttpSession session=request.getSession();
        	session.setAttribute("firstname",user.getFirstName());
        	session.setAttribute("userId",user.getUserId());
        	session.setAttribute("username",user.getUsername());
        	session.setAttribute("username",user.getPassword());
        	Cookie usernameCookie = new Cookie("userNAme", user.getUsername());
        	Cookie passwordCookie = new Cookie("userNAme", user.getPassword());
        	response.addCookie(usernameCookie);
        	response.addCookie(passwordCookie);
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("Exception: ")).append(e.getMessage()).toString());
        }
        if (user==null){
        	return "loginForm";
        }
        return "index";
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public String initializeForm(@ModelAttribute("user")User user)
    {
        return "loginForm";
    }

 
}
