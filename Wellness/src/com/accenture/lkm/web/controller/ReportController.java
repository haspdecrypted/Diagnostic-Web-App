package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.BillBean;
import com.accenture.lkm.business.bean.DateRangeBean;
import com.accenture.lkm.service.TestService;

@Controller
public class ReportController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/loadDateRangeReportPage")
	public ModelAndView loadDateRangeReportPage() {
		return new ModelAndView("billReport","dateRangeBean",new DateRangeBean());
	}

	@RequestMapping("/getBillDetails")
	public ModelAndView getBillDetails(@ModelAttribute ("dateRangeBean")DateRangeBean dateRangeBean) {
		List<BillBean> billList = testService.getTestBillDetails(dateRangeBean.getFrom(), dateRangeBean.getTo());
		for(BillBean billBean:billList) {
		
		billBean.setTestName(testService.getTestById(billBean.getTestId()).getTestName());
		billBean.setBalanceAmount(testService.getTestById(billBean.getTestId()).getCharges()-billBean.getPaidAmount());
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("billReport");
		mv.addObject("billList",billList);
		return mv;
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
