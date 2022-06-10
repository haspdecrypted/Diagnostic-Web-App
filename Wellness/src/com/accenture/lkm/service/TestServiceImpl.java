package com.accenture.lkm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.BillBean;
import com.accenture.lkm.business.bean.TestBean;
import com.accenture.lkm.dao.TestDAOWrapper;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDAOWrapper test;
	@Override
	public Map<Integer, String> findAllTestDetails() {
		
		List<TestBean> testList = test.findAllTests();
		Map<Integer,String> testMap = new HashMap<Integer,String>();
		for(TestBean bean:testList) {
			testMap.put(bean.getTestId(), bean.getTestName());
		}
		return testMap;
	}

	@Override
	public TestBean getTestById(Integer testId) {
		return test.getTestById(testId);
	}
	@Override
	public BillBean addBillDetails(BillBean billBean) {
		
		return test.addBillDetails(billBean);
	}

	@Override
	public List<BillBean> getTestBillDetails(Date from, Date to) {
		
		
		return test.getTestBillDetails(from, to);
	}

}
