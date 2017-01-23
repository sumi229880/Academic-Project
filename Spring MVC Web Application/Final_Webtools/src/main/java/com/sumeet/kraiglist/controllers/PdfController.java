package com.sumeet.kraiglist.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.sumeet.kraiglist.pdfview.PdfReportView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/report.htm")
public class PdfController {
	@RequestMapping(method = RequestMethod.GET)
public ModelAndView createReport()
	
	{
		View view = new PdfReportView();
		
		return new ModelAndView(view);
	}
}
