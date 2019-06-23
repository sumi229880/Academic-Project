package com.sumeet.kraiglist.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sumeet.kraiglist.DAO.UserDAO;
import com.sumeet.kraiglist.pojo.User;

@Controller
@RequestMapping("/search*.htm")
public class AjaxController {

	@Autowired
	UserDAO userDao;
	
	@RequestMapping(value="/searchuser.htm" , method = RequestMethod.POST)
    protected String doSubmitActionUser(HttpServletRequest request,HttpServletResponse response)
        throws Exception
    {
		try
		{
			String username = request.getParameter("user");
			System.out.println("username" + username);
			User usersearch;
        	usersearch = userDao.get(username);
        	 JSONObject obj = new JSONObject();
             obj.put("users",usersearch.getUsername());
             PrintWriter out = response.getWriter();
             out.println(obj);
        	
    }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("Exception: ")).append(e.getMessage()).toString());
        }
        return null;
    }
	@RequestMapping(value="/searchmail.htm" , method = RequestMethod.POST)
    protected String doSubmitActionMail(HttpServletRequest request,HttpServletResponse response)
        throws Exception
    {
		try
		{
			String username = request.getParameter("user");
			System.out.println("username" + username);
			User usersearch;
        	usersearch = userDao.getmail(username);
        	 JSONObject obj = new JSONObject();
             obj.put("users",usersearch.getUsername());
             PrintWriter out = response.getWriter();
             out.println(obj);
        	
    }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("Exception: ")).append(e.getMessage()).toString());
        }
        return null;
    }
	
	@RequestMapping(value="/searchhusky.htm" , method = RequestMethod.POST)
    protected String doSubmitActionHusky(HttpServletRequest request,HttpServletResponse response)
        throws Exception
    {
		try
		{
			String username = request.getParameter("user");
			System.out.println("usernameisisisisis" + username);
			User usersearch;
        	usersearch = userDao.gethusky(username);
        	 JSONObject obj = new JSONObject();
             obj.put("users",usersearch.getUsername());
             PrintWriter out = response.getWriter();
             out.println(obj);
        	
    }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("Exception: ")).append(e.getMessage()).toString());
        }
        return null;
    }
	
	@RequestMapping(value="/searchLogin.htm" , method = RequestMethod.POST)
    protected String doSubmitActionLogin(HttpServletRequest request,HttpServletResponse response)
        throws Exception
    {
		try
		{
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			System.out.println("username" + username);
			System.out.println("pass" + password);
			User usersearch;
        	usersearch = userDao.loginValidation(username,password);
        	 JSONObject obj = new JSONObject();
             obj.put("users",usersearch);
             PrintWriter out = response.getWriter();
             out.println(obj);
        	
    }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("Exception: ")).append(e.getMessage()).toString());
        }
        return null;
    }
 
}
