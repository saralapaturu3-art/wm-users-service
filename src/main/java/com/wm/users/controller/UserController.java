package com.wm.users.controller;

import com.wm.users.dto.CreateUserRequest;
import com.wm.users.dto.UserResponse;
import com.wm.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody CreateUserRequest request) {
        return service.createUser(request);
    }

//    @GetMapping("/{id}")
//    public UserResponse get(@PathVariable Long id) {
//        return service.getUser(id);
//    }
//
//    @GetMapping
//    public List<UserResponse> list() {
//        return service.listUsers();
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id) {
//        service.deleteUser(id);
//    }
}
