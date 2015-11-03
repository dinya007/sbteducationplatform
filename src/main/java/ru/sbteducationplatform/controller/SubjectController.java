package ru.sbteducationplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by denis on 01/11/15.
 */

@Controller
public class SubjectController {

    @RequestMapping({"/","/subjects"})
    public String getSubjectTemplate(){
        return "subjects";
    }

}
