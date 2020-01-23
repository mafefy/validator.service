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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.julio.validator.models.CaseOne;
import com.julio.validator.test.TestingCase1;

@Service
public class ValidatorService {

	private static final String MARKER = "@annotation(com.julio.validator.annotations.MyAnnotation)";

	@Value("${findProperties}")
	private String[] findProperties;

	/*
	 * search for matched fields in the return value and return list of all matched
	 * values
	 */

	public List<Field> findFields(Object obj) {

		List<Field> fields = new ArrayList<Field>();
		Class<?> type = obj.getClass();
		for (String name : findProperties) {
			try {
				Field field = type.getDeclaredField(name);
				fields.add(field);
			} catch (NoSuchFieldException | SecurityException e) {
			}
		}
		return fields;

	}

	/*
	 * here update your fields as you wish
	 */
	public void updateFileds(List<Field> fields, Object obj) {

		for (Field field : fields) {
			field.setAccessible(true);
			try {
				field.set(obj, null);
			} catch (IllegalArgumentException | IllegalAccessException e) {
			}
		}
	}

}
