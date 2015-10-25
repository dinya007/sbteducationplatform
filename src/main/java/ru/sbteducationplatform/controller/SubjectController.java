package ru.sbteducationplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sbteducationplatform.dao.StudentDao;
import ru.sbteducationplatform.dao.SubjectDao;
import ru.sbteducationplatform.entity.Student;
import ru.sbteducationplatform.entity.Subject;

/**
 * Created by denis on 24/10/15.
 */

@Controller
public class SubjectController {

    @Autowired
    SubjectDao subjectDao;

    @Autowired
    StudentDao studentDao;

    @RequestMapping({"/", "/hello"})
    protected String handleRequestInternal() {
        subjectDao.deleteAll();
        studentDao.deleteAll();
        Student student1 = new Student("vadim", "123456");
        Student student2 = new Student("denis", "123456");
        studentDao.save(student1);
        studentDao.save(student2);

        Subject subject = new Subject("Language of Programming Java");
        subject.addStudent(student1);
        subject.addStudent(student2);

        subjectDao.save(subject);

        System.out.println(subjectDao.findAll());
        return "hello";
    }

    @RequestMapping("/subjects")
    @ResponseBody
    public String getSubjects(){
        return subjectDao.findAll().toString();
    }
}
