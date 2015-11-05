package ru.sbteducationplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbteducationplatform.dao.SubjectDao;
import ru.sbteducationplatform.entity.Post;
import ru.sbteducationplatform.entity.Subject;
import ru.sbteducationplatform.service.SubjectService;

import java.util.List;

/**
 * Created by denis on 23/10/15.
 */

@Component
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectDao subjectDao;

    @Override
    public List<Subject> getAllSubjets() {
        return subjectDao.findAll();
    }

    @Override
    public Post addPost(String subjectsId, String author, String message) {
        Subject subject = subjectDao.findOne(subjectsId);
        Post post = subject.addPost(new Post(author, message));
        subjectDao.save(subject);
        return post;
    }
}
