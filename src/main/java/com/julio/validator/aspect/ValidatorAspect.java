package com.julio.validator.aspect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.julio.validator.models.CaseOne;
import com.julio.validator.test.TestingCase1;

@Aspect
@Component
public class ValidatorAspect {

	private static final String MARKER = "@annotation(com.julio.validator.annotations.MyAnnotation)";

	@Autowired
	private ValidatorService validatorService;

	/*
	 * here catch case one
	 */
	@AfterReturning(pointcut = MARKER, returning = "returnObject")
	public void processCaseOne(Object returnObject) {
		List<Field> fields = validatorService.findFields(returnObject);
		validatorService.updateFileds(fields, returnObject);
	}

}
