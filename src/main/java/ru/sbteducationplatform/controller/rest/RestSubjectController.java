package ru.sbteducationplatform.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sbteducationplatform.entity.Subject;
import ru.sbteducationplatform.service.SubjectService;

import java.io.IOException;
import java.util.List;

/**
 * Created by denis on 24/10/15.
 */

@Controller
@RequestMapping("/rest/subjects")
public class RestSubjectController {

    @Autowired
    private SubjectService subjectService;


    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    @ResponseBody
    public List<Subject> getSubjects() throws IOException {
        return subjectService.getAllSubjets();
    }

}
