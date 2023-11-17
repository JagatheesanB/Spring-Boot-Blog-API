package com.restapi.dto;

import com.restapi.model.Comment;
import com.restapi.request.CommentRequest;
import com.restapi.response.CommentResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentDto {

    public Comment mapToComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setId(commentRequest.getId());
        comment.setComment(commentRequest.getComment());
        return comment;
    }

    public CommentResponse mapToCommentResponse(List<Comment> comments) {
        CommentResponse commentResponse = new CommentResponse();

        List<CommentResponse> commentRequests = new ArrayList<>();
        for (Comment comment : comments) {
            commentRequests.add(new CommentResponse(comment.getId(), comment.getComment()));
        }
        commentResponse.setComments(commentRequests);
        return commentResponse;
    }
//    public CommentResponse mapToCommentResponse(List<Comment> comments) {
//        List<CommentResponse> commentResponses = comments
//                .stream()
//                .map(comment -> new CommentResponse(comment.getId(), comment.getComment()))
//                .collect(Collectors.toList());
//
//        CommentResponse commentResponse = new CommentResponse();
//        commentResponse.setComments(commentResponses);
//
//        return commentResponse;
//    }[

}
