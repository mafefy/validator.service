package com.julio.validator.service;

import org.springframework.beans.factory.annotation.Value;

import com.julio.validator.models.AnyClass;
import com.julio.validator.models.CaseOne;
import com.julio.validator.models.CaseTwo;

import java.util.ArrayList;
import java.util.List;

public class CaseTwoService {



    @Value( "${findProperties}" )
    private String findProperties;


    //@MyAnnotation()
    public List<CaseTwo> getMyPlace(){
        List<CaseTwo> response = new ArrayList<CaseTwo>(); // call to DAO or other service returned information
        // on List object . The annotation will read a response and update with null value or 0 if find a some properties
        // defined on application.properties
        return response;
    }


    //@MyAnnotation()
    public List<AnyClass> getMyPlaceHere(){
        List<AnyClass> response = new ArrayList<AnyClass>(); // call to DAO or other service returned information
        // on List object . The annotation will read a response and update with null value or 0 if find a some properties
        // defined on application.properties
        return response;
    }

}
