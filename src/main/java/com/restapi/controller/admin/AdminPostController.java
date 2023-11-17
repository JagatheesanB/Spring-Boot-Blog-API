package com.restapi.controller.admin;

import com.restapi.model.Role;

import com.restapi.response.PostResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.PostService;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/admin/posts")
@RolesAllowed(Role.ADMIN)
public class AdminPostController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllPost() {
        PostResponse postResponse = postService.findAll();
        apiResponse.setData(postResponse.getPosts());
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deletePost(@PathVariable Long id) {
        PostResponse postResponse = postService.deleteById(id);
        apiResponse.setData(postResponse.getPosts());
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
