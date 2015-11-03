package ru.sbteducationplatform.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sbteducationplatform.dao.PostDao;
import ru.sbteducationplatform.dao.SubjectDao;
import ru.sbteducationplatform.entity.Post;
import ru.sbteducationplatform.entity.Subject;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by denis on 24/10/15.
 */

@Controller
@RequestMapping("/rest")
public class RestSubjectController {

    @Autowired
    private SubjectDao subjectDao;

    @RequestMapping("/subjects")
    @ResponseBody
    public String getSubjects() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(subjectDao.findAll());
    }
}
