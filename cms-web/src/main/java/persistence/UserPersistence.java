package persistence;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.UserEntity;

@Repository
public interface UserPersistence extends CrudRepository<UserEntity, Serializable> {

}
