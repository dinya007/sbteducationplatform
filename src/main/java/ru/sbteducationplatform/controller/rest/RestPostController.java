package ru.sbteducationplatform.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sbteducationplatform.entity.Post;
import ru.sbteducationplatform.service.SubjectService;

import java.io.IOException;

/**
 * Created by denis on 05/11/15.
 */

@Controller
@RequestMapping("/rest/posts")
public class RestPostController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/{subjectId}/{author}/{message}", method = RequestMethod.POST)
    @ResponseBody
    public Post postPost(@PathVariable String subjectId, @PathVariable String author, @PathVariable String message) throws IOException {
        return subjectService.addPost(subjectId, author, message);
    }

}
