package com.restapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CommentResponse {

    private List<CommentResponse> comments;

    public CommentResponse() {
    }

    public void setComments(List<CommentResponse> comments) {
        this.comments = comments;
    }

    private Long id;
    private String comment;
    private Long user_id;
//    private Long post_id;

    public CommentResponse(Long id, String comment, Long user_id) {
        this.id = id;
        this.comment = comment;
        this.user_id = user_id;
//        this.post_id = post_id;
    }

}
