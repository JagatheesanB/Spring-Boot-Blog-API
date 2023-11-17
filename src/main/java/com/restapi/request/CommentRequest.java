package com.restapi.request;

import com.restapi.model.AppUser;
import com.restapi.model.Post;
import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentRequest {


    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Comment should have at least 2 characters")
    private String comment;

    private Long user_id;
    private Long post_id;

}
