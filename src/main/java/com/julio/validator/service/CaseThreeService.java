package com.julio.validator.service;

import java.util.ArrayList;
import java.util.List;

import com.julio.validator.models.AnyClass;
import com.julio.validator.models.WrapperList;

public class CaseThreeService {


    //@MyAnnotation()
    public WrapperList getMyPlaceHere(){

        List<AnyClass> anyClassList = new ArrayList<AnyClass>();
        // call to DAO or other service returned information
        // on List object . The annotation will read a response and update with null value or 0 if find a some properties
        // defined on application.properties

        WrapperList wrapper = new WrapperList();
        wrapper.setMyList(anyClassList);

        //The annotation will be read a wrapper, get a list, iterate a list value for any object and update the values if
        // found on application properties
        return wrapper;
    }
}
