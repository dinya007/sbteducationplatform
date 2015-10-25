package ru.sbteducationplatform.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sbteducationplatform.entity.Student;

/**
 * Created by denis on 23/10/15.
 */
public interface StudentDao extends MongoRepository<Student, String> {

    @Override
    Student save(Student entity);

}
