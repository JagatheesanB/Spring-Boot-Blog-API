package com.restapi.controller;

import com.restapi.model.Role;
import com.restapi.request.PostRequest;
import com.restapi.response.PostResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.PostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/api/post")
@RolesAllowed(Role.USER)
public class PostController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private PostService postService;

//    @PostMapping
//    public ResponseEntity<APIResponse> createPost(@Valid @RequestBody PostRequest postRequest) {
//        apiResponse.setData(postService.createPost(postRequest));
//        apiResponse.setStatus(HttpStatus.OK.value());
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<APIResponse> createPost(@Valid @RequestBody PostRequest postRequest) {
//        System.out.println("Received PostRequest: " + postRequest);
        apiResponse.setData(postService.createPost(postRequest));
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getPostById() {
        PostResponse response = postService.findAllPosts();
        APIResponse apiResponse = new APIResponse();
        apiResponse.setData(response.getPosts());
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updatePost(@Valid @PathVariable Long id,
                                                  @RequestBody PostRequest postRequest) {
        apiResponse.setData(postService.updatePost(postRequest));
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deletePost(@PathVariable Long id) {
        apiResponse.setData(postService.deletePost(id));
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
