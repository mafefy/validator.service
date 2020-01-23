package com.julio.validator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.julio.validator.annotations.MyAnnotation;
import com.julio.validator.models.CaseOne;

//@ConfigurationProperties("service")
@Service
public class CaseOneService {

    
	private Logger logger = LoggerFactory.getLogger(CaseOneService.class);
    @MyAnnotation
    public CaseOne getMyPlace(){
    	logger.info("inside service getMyPlace()");
        CaseOne response = new CaseOne(); 
        response.setAge(3);
        response.setLastName("afefy");
        response.setName("mohamed");
        return response;
    }
    
    /*
    @MyAnnotation
    public String getMyPlaceString(){
    	logger.info("inside service getMyPlaceString()");
        return "welcome";
    }
    
    @MyAnnotation
    public Integer getMyPlaceInteger(){
    	logger.info("inside service getMyPlaceInteger()");
        return 23;
    }
    */
}
