package ru.sbteducationplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sbteducationplatform.dao.SubjectDao;
import ru.sbteducationplatform.entity.Subject;
import ru.sbteducationplatform.service.SubjectService;

import java.util.List;

/**
 * Created by denis on 23/10/15.
 */

public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectDao subjectDao;

    @Override
    public List<Subject> getAllSubjets() {
        return subjectDao.findAll();
    }
}
