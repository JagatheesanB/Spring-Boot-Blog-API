package com.restapi.controller;

import com.restapi.model.Role;
import com.restapi.request.PostRequest;
import com.restapi.response.PostResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/post")
@RolesAllowed(Role.USER)
public class PostController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<APIResponse> createPost(@Valid @RequestBody PostRequest postRequest) {
        postRequest.setUser_id(postRequest.getUser_id());
        apiResponse.setData(postService.createPost(postRequest));
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getPostByName() {
        PostResponse response = postService.findAllPosts();
        APIResponse apiResponse = new APIResponse();
        apiResponse.setData(response);
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getPostById(@PathVariable Long id) {
        System.out.println("Fetching post by ID: " + id);
        apiResponse.setData(postService.findPostById(id));
        System.out.println("Response retrieved successfully: " + apiResponse);
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
