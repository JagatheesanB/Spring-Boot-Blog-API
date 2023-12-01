package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.model.Comment;
import com.restapi.model.Post;
import com.restapi.repository.PostRepository;
import com.restapi.request.CommentRequest;
import com.restapi.response.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentDto {


    private final PostRepository PostRepository;

    @Autowired
    public CommentDto(PostRepository postRepository) {
        this.PostRepository = postRepository;
    }


    public Comment mapToComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setId(commentRequest.getId());
        comment.setComment(commentRequest.getComment());

        AppUser appUser = new AppUser();
        appUser.setId(commentRequest.getUser_id());
        comment.setAppUser(appUser);

        Post post = PostRepository.findById(commentRequest.getPost_id()).orElse(null);

        if (post != null) {
            comment.setId(commentRequest.getPost_id());
        }
        return comment;
    }

    public CommentResponse mapToCommentResponse(List<Comment> comments) {
        CommentResponse commentResponse = new CommentResponse();

        List<CommentResponse> commentRequests = new ArrayList<>();
        for (Comment comment : comments) {
            commentRequests.add(new CommentResponse(comment.getId(), comment.getComment(),
                    comment.getAppUser().getId()));

        }
        commentResponse.setComments(commentRequests);
        return commentResponse;
    }


    public CommentResponse mapToSingleCommentResponse(Comment comment) {
        List<Comment> singleCommentList = new ArrayList<>();
        singleCommentList.add(comment);
        return mapToCommentResponse(singleCommentList);
    }

}
