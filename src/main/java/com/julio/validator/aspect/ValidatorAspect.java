package com.julio.validator.aspect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.weaver.ast.Instanceof;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.julio.validator.models.CaseOne;

@Aspect
@Component
@Configurable(preConstruction = true)
public class ValidatorAspect {

	private static final String MARKER = "@annotation(com.julio.validator.annotations.MyAnnotation)";

	private Logger logger = LoggerFactory.getLogger(ValidatorAspect.class);
	@Autowired
	private ValidatorService validatorService;

	/*
	 * here catch case one
	 */
	@AfterReturning(pointcut = MARKER, returning = "returnObject")
	public void caseOneAdvice(Object returnObject) {

		if (returnObject instanceof List<?>) {
			processCaseTwo((List<?>) returnObject);
		} else if (returnObject instanceof Object) {
			Field list = null;
			if ((list = hasListField(returnObject)) != null) {
				processCaseThree(list, returnObject);
			} else {
				processCaseOne(returnObject);
			}
		}

	}

	private void processCaseOne(Object returnObject) {
		logger.info("aspect -> Handling case 1");
		List<Field> fields = validatorService.findFields(returnObject);
		validatorService.updateFileds(fields, returnObject);
	}

	private void processCaseTwo(List<? extends Object> returnList) {
		logger.info("aspect -> Handling case 2");
		for (Object obj : returnList) {
			List<Field> fields = validatorService.findFields(obj);
			validatorService.updateFileds(fields, obj);
		}
	}

	private void processCaseThree(Field listField, Object returnObject) {
		logger.info("aspect -> Handling case 3");
		try {
			listField.setAccessible(true);
			List<?> list = (List<?>) listField.get(returnObject);
			processCaseTwo(list);
		} catch (IllegalArgumentException e) {

		} catch (IllegalAccessException e) {

		}
	}

	private Field hasListField(Object returnObject) {
		Class<?> type = returnObject.getClass();
		for (Field field : type.getDeclaredFields()) {
			if (field.getType() == List.class) {
				return field;
			}
		}
		return null;
	}

}
