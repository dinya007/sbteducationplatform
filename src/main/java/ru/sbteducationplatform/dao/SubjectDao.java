package ru.sbteducationplatform.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sbteducationplatform.entity.Subject;

/**
 * Created by denis on 23/10/15.
 */

public interface SubjectDao extends MongoRepository<Subject, String> {
}
