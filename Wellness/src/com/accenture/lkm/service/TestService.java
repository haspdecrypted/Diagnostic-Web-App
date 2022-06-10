package com.accenture.lkm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.accenture.lkm.business.bean.BillBean;
import com.accenture.lkm.business.bean.TestBean;

public interface TestService {	
	Map<Integer,String> findAllTestDetails();
	BillBean addBillDetails(BillBean billBean);
	List<BillBean> getTestBillDetails(Date from,Date to);
	TestBean getTestById(Integer testId);
	
}