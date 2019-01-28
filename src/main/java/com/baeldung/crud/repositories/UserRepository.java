package com.baeldung.crud.repositories;

import com.baeldung.crud.entities.User;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
    @Query("FROM User u WHERE (?1 is null or u.name like ?1 or ?1 like '') and (?2 is null or u.passportId like ?2 or ?2 like '')")
    List<User> findAllByNameAndPassportId(String name, String passportId);
}
