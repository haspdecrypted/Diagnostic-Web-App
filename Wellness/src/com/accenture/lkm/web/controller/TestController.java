package com.accenture.lkm.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.BillBean;

import com.accenture.lkm.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/loadTestForm", method=RequestMethod.GET)
	public ModelAndView loadTestForm() {
		return new ModelAndView("testForm","billBean",new BillBean());
	}
	
	@RequestMapping(value="/addBillDetails",method=RequestMethod.POST)
	public ModelAndView saveBillDetails(@ModelAttribute("billBean")@Valid BillBean billBean,
			BindingResult bindingResult) throws Exception{
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mv.setViewName("testForm");
		}
		else {
		BillBean bean = testService.addBillDetails(billBean);
		billBean.setBalanceAmount(testService.getTestById(billBean.getTestId()).getCharges()-billBean.getPaidAmount());
		if(billBean.getBalanceAmount()>=0)
		{
		mv.setViewName("testForm");
		mv.addObject("message","Hi "+billBean.getPatientName()+", Lab-Test Bill Details are saved");
		mv.addObject("m1"," Bill Number: "+bean.getBillNo());
		mv.addObject("m2"," Balance Amount.: "+billBean.getBalanceAmount());
		}
		else
		{
			throw new Exception("Paid amount must be a positive value less than or equal to test charges");
		}
		}
		return mv;
	}

	
	@ModelAttribute("testMap")
	public Map<Integer,String> populateTestNames(){
		Map<Integer,String> testMap = testService.findAllTestDetails();
		return testMap;
	}
	
	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){	
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
	
}
