package com.restapi.controller;

import com.restapi.model.Role;
import com.restapi.request.CommentRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/comments")
@RolesAllowed(Role.USER)
public class CommentController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<APIResponse> createComment(@Valid @RequestBody CommentRequest commentRequest) {
        apiResponse.setData(commentService.createComment(commentRequest));
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getCommentById() {
        System.out.println("All comments : " + commentService);
        apiResponse.setData(commentService.findAllComments());
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteComment(@PathVariable Long id) {
        apiResponse.setData(commentService.deleteComment(id));
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
