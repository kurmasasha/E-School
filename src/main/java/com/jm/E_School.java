package com.jm;

import com.jm.dto.UserDto;
import com.jm.model.User;
import com.jm.repository.UserRepository;
import com.jm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class E_School {
    public static void main(String[] args) {
        SpringApplication.run(E_School.class,args);
    }
}
