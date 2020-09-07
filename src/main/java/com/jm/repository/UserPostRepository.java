package com.jm.repository;

import com.jm.dto.UserPostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepository extends JpaRepository<UserPostDto, Long> {

}
