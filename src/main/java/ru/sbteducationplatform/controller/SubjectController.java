package ru.sbteducationplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sbteducationplatform.dao.SubjectDao;
import ru.sbteducationplatform.service.SubjectService;

/**
 * Created by denis on 01/11/15.
 */

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping({"/","/subjects"})
    public ModelAndView getSubjectTemplate(){
        return new ModelAndView("subjects","subjects",subjectService.getAllSubjets());
    }

}
