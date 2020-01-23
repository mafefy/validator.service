package com.julio.validator.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.julio.validator.models.CaseOne;
import com.julio.validator.service.CaseOneService;

@Component
public class TestingCase1 implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(TestingCase1.class);
	@Autowired
	private CaseOneService service;
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("before calling service method");
		CaseOne one = service.getMyPlace();
		logger.info("after ->> age:" + one.getAge() + " name:" + one.getName() + " last name:" + one.getLastName());
		
	}

}
