package ru.sbteducationplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/{subjectId}/{author}/{message}", method = RequestMethod.POST)
    @ResponseBody
    public Subject postSubject(@PathVariable String subjectId, @PathVariable String author, @PathVariable String message) throws IOException {
        return subjectService.addPost(subjectId, author, message);
    }
}
