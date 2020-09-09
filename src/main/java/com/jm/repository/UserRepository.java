package com.jm.repository;

import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select count(u) from User u where u.email = ?1")
    Long isUserExist(String email);
    User findByEmail (String email);

}
