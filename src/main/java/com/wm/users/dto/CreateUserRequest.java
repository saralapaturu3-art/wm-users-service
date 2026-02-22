package com.wm.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {

    @NotBlank(message = "firstName is required")
    @Size(max=100, message = "firstName max length is 100")
    private String firstName;

    @NotBlank(message = "lastName is required")
    @Size(max=100, message = "lastName max length is 100")
    private String lastName;

    @Email(message = "email must be valid")
    @Size(max=150, message = "email max length is 150")
    private String email;

    @NotBlank(message = "phoneNumber is required")
    @Size(max=20, message = "phoneNumber max length is 20")
    private String phoneNumber;

    @NotBlank(message = "password is required")
    @Size(min=8, max=72, message = "password must be 8 to 72 chars")
    private String password;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
