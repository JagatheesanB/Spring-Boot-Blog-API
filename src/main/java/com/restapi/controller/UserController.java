package com.restapi.controller;

import com.restapi.model.AppUser;
import com.restapi.model.Role;
import com.restapi.response.common.APIResponse;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/users")
@RolesAllowed(Role.USER)
public class UserController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private UserService userService;

    @GetMapping("/{userid}")
    public ResponseEntity<APIResponse> getUserById(@PathVariable Long id) {
        apiResponse.setData(userService.findUserById(Long.valueOf(id)));
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
