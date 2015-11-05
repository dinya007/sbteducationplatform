package ru.sbteducationplatform.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sbteducationplatform.entity.Post;

/**
 * Created by denis on 23/10/15.
 */
public interface PostDao extends MongoRepository<Post, String> {

}
