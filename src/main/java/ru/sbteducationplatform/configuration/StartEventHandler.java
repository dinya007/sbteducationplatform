package ru.sbteducationplatform.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.sbteducationplatform.dao.SubjectDao;
import ru.sbteducationplatform.entity.Post;
import ru.sbteducationplatform.entity.Subject;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by denis on 30/10/15.
 */

@Component
public class StartEventHandler implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        try {
            Runtime.getRuntime().exec("mongod --dbpath /Users/denis/Documents/Java/MongoDB/SbtEdu");
        } catch (IOException e) {
            e.printStackTrace();
        }

        subjectDao.deleteAll();

        Subject javaSubject = new Subject("Language of Programming Java");
        Subject patternSubject = new Subject("Design patterns in software development");

        Post postConcurrentHashMap = new Post("Sasha Matorin");
        Post postSolid = new Post("Ilya Agoshkov");
        Post postProxy = new Post("Ilya Agoshkov");

        postConcurrentHashMap.setMessage("It's awesome.");
        postSolid.setMessage("I'm not aware of it, sorry guys.");
        postProxy.setMessage("I've already told you about it.");

        javaSubject.addPost(postConcurrentHashMap);
        javaSubject.addPost(postProxy);
        patternSubject.addPost(postSolid);

        subjectDao.save(Arrays.asList(javaSubject, patternSubject));
    }
}
