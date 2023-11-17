package com.restapi.controller.admin;

import com.restapi.model.Role;
import com.restapi.response.CommentResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/admin/comments")
@RolesAllowed(Role.ADMIN)
public class AdminCommentController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getALlComments() {
        CommentResponse commentResponse = commentService.findAll();
        apiResponse.setData(commentResponse.getComments());
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteComments(@PathVariable Long id) {
        CommentResponse commentResponse = commentService.deleteById(id);
        apiResponse.setData(commentResponse.getComments());
        apiResponse.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
