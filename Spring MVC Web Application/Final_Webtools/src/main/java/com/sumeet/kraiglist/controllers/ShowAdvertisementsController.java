package com.sumeet.kraiglist.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sumeet.kraiglist.DAO.AdvertisementDAO;
import com.sumeet.kraiglist.exception.AdException;
import com.sumeet.kraiglist.pojo.Advertisements;

import java.util.List;

import java.util.ArrayList;

@Controller
@RequestMapping("/show*.htm")
public class ShowAdvertisementsController{
	@Autowired
	AdvertisementDAO advertisementDAO ;

	@RequestMapping(method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String differentiator = request.getParameter("action");
        ArrayList<Advertisements> advList = new ArrayList<Advertisements>();
        try {
        List<Advertisements> advertisementList = advertisementDAO.list(differentiator);
            for (Advertisements advertisements : advertisementList) { 
                    advList.add(advertisements);
            }
        }
        catch (AdException e) {
            System.out.println(e.getMessage());
        }
        ModelAndView mv = new ModelAndView("viewAdverts", "advertisements", advList);
        return mv;
    }
}