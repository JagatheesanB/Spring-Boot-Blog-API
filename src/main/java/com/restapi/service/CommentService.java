package com.restapi.service;

import com.restapi.dto.CommentDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Comment;
import com.restapi.repository.CommentRepository;
import com.restapi.request.CommentRequest;
import com.restapi.response.CommentResponse;
import com.restapi.response.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentDto commentDto;

    public CommentResponse createComment(CommentRequest commentRequest) {
        Comment comment = commentDto.mapToComment(commentRequest);
        commentRepository.save(comment);
        return findAllComments();
    }

    public CommentResponse findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return commentDto.mapToCommentResponse(comments);
    }

    public CommentResponse findCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            List<Comment> singleCommentList = new ArrayList<>();
            singleCommentList.add(comment.get());
            return commentDto.mapToCommentResponse(singleCommentList);
        } else {
            throw new ResourceNotFoundException("Comment", "id", id);
        }
    }

    public CommentResponse deleteComment(Long id) {
        commentRepository.deleteById(Long.valueOf(id));
        return findAllComments();
    }


    //Admin
    public CommentResponse findAll() {
        List<Comment> comments = commentRepository.findAll();
        return commentDto.mapToCommentResponse(comments);
    }

    public CommentResponse deleteById(Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            commentRepository.deleteById(id);
            return findAll();
        } else {
            return deleteComment(id);
        }

    }
}
