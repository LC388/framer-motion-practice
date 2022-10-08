package com.pizza.main.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pizza.main.controller.exceptions.UserAlreadyExistsException;
import com.pizza.main.model.Employee;
import com.pizza.main.model.LoginDTO;
import com.pizza.main.model.RegisterUserDTO;
import com.pizza.main.model.User;
import com.pizza.main.security.jwt.JWTFilter;
import com.pizza.main.security.jwt.TokenProvider;
import com.pizza.main.service.EmployeeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

public class EmployeeAuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private EmployeeService employeeService;

    public EmployeeAuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, EmployeeService employeeService) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employee/login", method = RequestMethod.POST)
    public ResponseEntity<EmployeeAuthenticationController.LoginResponse> login(@Valid @RequestBody LoginDTO loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);

        Employee employee = employeeService.findByUsername(loginDto.getUsername());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new EmployeeAuthenticationController.LoginResponse(jwt, employee), httpHeaders, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "employee/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegisterUserDTO newEmployee) {
        try {
            Employee employee = employeeService.findByUsername(newEmployee.getUsername());
            throw new UserAlreadyExistsException();
            //TODO check email exists
        } catch (UsernameNotFoundException e) {
            employeeService.create(newEmployee.getUsername(),newEmployee.getPassword(), newEmployee.getEmail(), newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getBirthday(), newEmployee.getStreetAddress(), newEmployee.getCity(), newEmployee.getState(), newEmployee.getZipcode(), newEmployee.getPhoneNumber());

        }
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class LoginResponse {

        private String token;
        private User user;

        LoginResponse(String token, User user) {
            this.token = token;
            this.user = user;
        }

        @JsonProperty("token")
        String getToken() {
            return token;
        }

        void setToken(String token) {
            this.token = token;
        }

        @JsonProperty("user")
        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}



