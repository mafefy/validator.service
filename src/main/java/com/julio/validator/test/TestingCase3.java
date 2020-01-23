package com.julio.validator.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.julio.validator.models.AnyClass;
import com.julio.validator.models.CaseOne;
import com.julio.validator.models.CaseTwo;
import com.julio.validator.service.CaseOneService;
import com.julio.validator.service.CaseThreeService;
import com.julio.validator.service.CaseTwoService;

@Component
public class TestingCase3 implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(TestingCase3.class);
	@Autowired
	private CaseThreeService service;
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("case 3 before calling service method");
		List<? extends Object> cases = service.getMyPlaceHere().getMyList();
		logger.info("after 3 calling service method");
		
		for ( Object obj : cases ) {
			AnyClass c = (AnyClass) obj;
			logger.info("box:" + c.getBox() + " circles:" + c.getCircle() 
			+ " squre:" + c.getSquare() + " number:" + c.getNumber() );
		}
	}

}
