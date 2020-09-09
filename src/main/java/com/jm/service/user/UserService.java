package com.jm.service.user;

import com.jm.model.User;
import org.springframework.data.jpa.repository.Query;

public interface UserService {
    boolean isUserExist(String email);
}
