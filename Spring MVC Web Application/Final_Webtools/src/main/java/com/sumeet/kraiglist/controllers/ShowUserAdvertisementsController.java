package com.sumeet.kraiglist.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sumeet.kraiglist.DAO.AdvertisementDAO;
import com.sumeet.kraiglist.exception.AdException;
import com.sumeet.kraiglist.pojo.Advertisements;
import com.sumeet.kraiglist.pojo.User;

import java.util.List;

import java.util.ArrayList;

@Controller
@RequestMapping("/delete*.htm")
public class ShowUserAdvertisementsController{
	@Autowired
	AdvertisementDAO advertisementDAO ;

	@RequestMapping(method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
        ArrayList<Advertisements> advList = new ArrayList<Advertisements>();
        try {
        List<Advertisements> advertisementList = advertisementDAO.userList(session.getAttribute("userId"));
            for (Advertisements advertisements : advertisementList) { 
                    advList.add(advertisements);
            }
        }
        catch (AdException e) {
            System.out.println(e.getMessage());
        }
        ModelAndView mv = new ModelAndView("particularUserAdvertisement", "advertisements", advList);
        return mv;
    }
	
	@RequestMapping(value="/delete.htm" , method=RequestMethod.POST)
    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
		long action = Long.parseLong(request.getParameter("action"));		
		advertisementDAO.delete(action);
        }
        catch (AdException be) {
            System.out.println(be.getMessage());
        }
		HttpSession session=request.getSession();
        ArrayList<Advertisements> advList = new ArrayList<Advertisements>();
        try {
        List<Advertisements> advertisementList = advertisementDAO.userList(session.getAttribute("userId"));
            for (Advertisements advertisements : advertisementList) { 
                    advList.add(advertisements);
            }
        }
        catch (AdException e) {
            System.out.println(e.getMessage());
        }
        ModelAndView mv = new ModelAndView("particularUserAdvertisement", "advertisements", advList);
        return mv;
    }
	
	@RequestMapping(value="/deleteUpdate.htm" , method=RequestMethod.GET)
    protected ModelAndView handleRequestSelectForUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        long action = Long.parseLong(request.getParameter("action"));		
        Advertisements advertisementList = advertisementDAO.update(action);

        ModelAndView mv = new ModelAndView("updateAdvertisement", "advertisements", advertisementList);
        return mv;
    }
	
	@RequestMapping(value="/deleteUpdate.htm" , method=RequestMethod.POST)
    protected String handleRequestUpdate(@ModelAttribute("advertisements") Advertisements advertisement, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			long action = advertisement.getAdvertId();
			String titl = advertisement.getTitle();
			double prce = advertisement.getPrice();
			String desc = advertisement.getDescripition();
			advertisementDAO.aftSelectUpdate(action,titl,prce,desc);
        }
        catch (AdException be) {
            System.out.println(be.getMessage());
        }

        return "updateSuccess";
    }
}