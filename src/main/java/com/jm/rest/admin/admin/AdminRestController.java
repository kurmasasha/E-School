package com.jm.rest.admin.admin;

import com.jm.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/user/admin")
public class AdminRestController {
    private UserService service;

    public AdminRestController(UserService service) {
        this.service = service;
    }


}
