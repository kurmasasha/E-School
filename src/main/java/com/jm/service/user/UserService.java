package com.jm.service.user;

import com.jm.model.User;
import org.springframework.data.jpa.repository.Query;

public interface UserService {

    /**
     * Проверяет наличие юзера в базе по email
     * @param email
     * @return
     */

    boolean isUserExist(String email);
}
