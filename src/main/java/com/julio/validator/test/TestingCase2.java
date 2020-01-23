package com.julio.validator.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.julio.validator.models.CaseOne;
import com.julio.validator.models.CaseTwo;
import com.julio.validator.service.CaseOneService;
import com.julio.validator.service.CaseTwoService;

@Component
public class TestingCase2 implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(TestingCase2.class);
	@Autowired
	private CaseTwoService service;
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("case 2 before calling service method");
		List<CaseTwo> cases = service.getMyPlaces();
		//logger.info("case 2 after ->> age:" + one.getAge() + " name:" + one.getName() + " last name:" + one.getLastName());
		
		for ( CaseTwo c : cases ) {
			logger.info("car:" + c.getCar() + " tires:" + c.getTires() + " color:" + c.getColor() + " year:" + c.getYear() );
		}
	}

}
