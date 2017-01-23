package com.sumeet.kraiglist.controllers;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import com.sumeet.kraiglist.DAO.UserDAO;
import com.sumeet.kraiglist.DAO.AdvertisementDAO;
import com.sumeet.kraiglist.DAO.UserDAO;
import com.sumeet.kraiglist.pojo.Advertisements;
import com.sumeet.kraiglist.pojo.User;
import com.sumeet.kraiglist.validators.PostAdvertisementValidator;

@Controller
@RequestMapping("/postadd.htm")
public class PostAddController {
	@Autowired
	@Qualifier("postAdvertisementValidator")
	PostAdvertisementValidator postAdvertisementValidator;
	@Autowired
	ServletContext servletContext;
	@Autowired
	AdvertisementDAO advertisementDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@InitBinder("advertisements")
    private void initBinder(WebDataBinder binder)
    {
		binder.setValidator(postAdvertisementValidator);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("advertisements")Advertisements advertisements, BindingResult result, HttpServletRequest request,@RequestParam("imageFile") MultipartFile imageFile )
        throws Exception
    {
		postAdvertisementValidator.validate(advertisements, result);
        if(result.hasErrors())
            return "postAdvertisement";
        try
        {
        	File file;        	
        	  String check = File.separator;
              String path = null;
              if(check.equalsIgnoreCase("\\")) {             
               path = servletContext.getRealPath("").replace("build\\",""); 
               path+="resources\\images\\";
              }
                        if(check.equalsIgnoreCase("/")) {
              path = servletContext.getRealPath("").replace("build/","");
              path +=  "/resources/images/"; 
           }
                           if(advertisements.getImageFile() != null){
              String fileNameWithExt = System.currentTimeMillis() + imageFile.getOriginalFilename();
                   file = new File(path+fileNameWithExt);
                   String context = servletContext.getContextPath();
                   imageFile.transferTo(file);
                   String photoFileName= context + "/resources/images/" +fileNameWithExt;
                   advertisements.setPhotos(photoFileName);
   	
        	HttpSession session=request.getSession();
        	String username = (String) session.getAttribute("username");
        	User user = userDAO.get(username);
            String title = advertisements.getTitle().replaceAll("[^\\dA-Za-z_@\\s./#-]", "").trim();
            String desc = advertisements.getDescripition().replaceAll("[^\\dA-Za-z_@\\s./#-]", "").trim();

            advertisementDAO.create(advertisements.getCategory() ,title,advertisements.getPrice(),desc,advertisements.getYearOld(),advertisements.getPhotos(),user);
              }
        }
        catch(Exception e)
        {
            System.out.println((new StringBuilder("Exception: ")).append(e.getMessage()).toString());
        }
        return "addedAdvertisement";
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request) throws Exception {
		HttpSession session=request.getSession();
		ModelAndView mv = new ModelAndView();

		if(session.getAttribute("firstname") != null){
			Advertisements advertisements = new  Advertisements();
			mv.addObject("advertisements",advertisements);
			mv.setViewName("postAdvertisement");
		}else{
			User user = new  User();
			mv.addObject("user",user);
			mv.setViewName("loginForm");
		}
		return mv;
		
	}

}
