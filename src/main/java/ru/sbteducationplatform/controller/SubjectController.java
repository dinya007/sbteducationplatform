package ru.sbteducationplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sbteducationplatform.dao.PostDao;
import ru.sbteducationplatform.dao.SubjectDao;
import ru.sbteducationplatform.entity.Post;
import ru.sbteducationplatform.entity.Subject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by denis on 24/10/15.
 */

@Controller
@RequestMapping("/rest")
public class SubjectController {

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private PostDao postDao;

    @RequestMapping({"/", "/hello"})
    protected String handleRequestInternal() {
        return "hello";
    }

    @RequestMapping("/subjects")
    @ResponseBody
    public List<Subject> getSubjects() {
        subjectDao.deleteAll();
        postDao.deleteAll();

        Subject javaSubject = new Subject("Language of Programming Java");
        Subject patternSubject = new Subject("Design patterns in software development");

        Post postConcurrentHashMap = new Post("Sasha Matorin");
        Post postSolid = new Post("Alexey Agoshkov");
        Post postProxy = new Post("Alexey Agoshkov");

        postConcurrentHashMap.setMessage("It's awesome.");
        postSolid.setMessage("I'm not aware of it, sorry guys.");
        postProxy.setMessage("I've already told you about it.");

        javaSubject.addPost(postConcurrentHashMap);
        javaSubject.addPost(postProxy);
        patternSubject.addPost(postSolid);

        subjectDao.save(Arrays.asList(javaSubject, patternSubject));

        System.out.println(subjectDao.findAll());
        return subjectDao.findAll();
    }
}
