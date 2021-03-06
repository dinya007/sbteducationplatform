package ru.sbteducationplatform.service;


import org.springframework.stereotype.Component;
import ru.sbteducationplatform.entity.Post;
import ru.sbteducationplatform.entity.Subject;

import java.util.List;

/**
 * Created by denis on 23/10/15.
 */

@Component
public interface SubjectService {

    List<Subject> getAllSubjets();

    Post addPost(String subjectsId, String author, String message);


}
