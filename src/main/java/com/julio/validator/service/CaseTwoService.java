package com.julio.validator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.julio.validator.annotations.MyAnnotation;
import com.julio.validator.models.AnyClass;
import com.julio.validator.models.CaseOne;
import com.julio.validator.models.CaseTwo;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseTwoService {

	@MyAnnotation
	public List<CaseTwo> getMyPlaces() {
		List<CaseTwo> response = new ArrayList<CaseTwo>(); // call to DAO or other service returned information
		for (int i = 1; i < 3; i++) {
			CaseTwo two = new CaseTwo();
			two.setColor("red");
			two.setCar("audi");
			two.setTires(5);
			two.setYear(2020);
			response.add(two);
		}
		// on List object . The annotation will read a response and update with null
		// value or 0 if find a some properties
		// defined on application.properties
		return response;
	}

}
