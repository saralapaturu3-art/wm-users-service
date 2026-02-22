package com.wm.users.service;

import com.wm.users.dto.CreateUserRequest;
import com.wm.users.dto.UserResponse;
import com.wm.users.entity.WmUser;
import com.wm.users.exception.ResourceNotFoundException;
import com.wm.users.repository.WmUserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final WmUserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserService(WmUserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(CreateUserRequest req) {
        WmUser u = new WmUser();
        u.setFirstName(req.getFirstName());
        u.setLastName(req.getLastName());
        u.setEmail(req.getEmail());
        u.setPhoneNumber(req.getPhoneNumber());
        u.setPassword(passwordEncoder.encode(req.getPassword()));

        try {
            WmUser saved = repo.save(u);
            return toResponse(saved);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Email already exists.");
        }
    }

    public UserResponse getUser(Long id) {
        WmUser u = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        return toResponse(u);
    }

    public List<UserResponse> listUsers() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public void deleteUser(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("User not found: " + id);
        repo.deleteById(id);
    }

    private UserResponse toResponse(WmUser u) {
        return new UserResponse(u.getId(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPhoneNumber());
    }
}
