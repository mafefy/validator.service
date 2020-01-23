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
	public void caseOneAdvice(Object returnObject) {

		if (returnObject instanceof List) {
			processCaseTwo( (List<? extends Object>) returnObject);
		} else if (returnObject instanceof Object) {
			processCaseOne(returnObject);
		}

	}

	private void processCaseOne(Object returnObject) {
		System.out.println(" object only");
		List<Field> fields = validatorService.findFields(returnObject);
		validatorService.updateFileds(fields, returnObject);
	}

	/*
	@AfterReturning(pointcut = MARKER, returning = "returnList")
	public void caseTwoAdvice(List<? extends Object> returnList) {
		processCaseTwo(returnList);
	}
	*/

	private void processCaseTwo(List<? extends Object> returnList) {
		System.out.println(" list of objectgs");
		for (Object obj : returnList) {
			List<Field> fields = validatorService.findFields(obj);
			validatorService.updateFileds(fields, obj);
		}
	}

}
