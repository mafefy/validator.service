package com.julio.validator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.julio.validator.annotations.MyAnnotation;
import com.julio.validator.models.AnyClass;
import com.julio.validator.models.CaseTwo;
import com.julio.validator.models.WrapperList;

@Service
public class CaseThreeService {

	@MyAnnotation
	public WrapperList getMyPlaceHere() {

		List<AnyClass> anyClassList = new ArrayList<AnyClass>();

		for (int i = 1; i < 3; i++) {
			AnyClass any = new AnyClass();
			any.setBox("red box");
			any.setCircle("cmall circle");
			any.setNumber(343);
			any.setSquare("nice square");
			anyClassList.add(any);
		}

		WrapperList wrapper = new WrapperList();
		wrapper.setMyList(anyClassList);

		return wrapper;
	}
}
