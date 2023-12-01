package com.restapi.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private List<PostResponse> posts;

    private Long id;
    private String title;
    private String content;
    private String role;

    private Long user_id;

    public PostResponse(Long id, String title, String content,Long user_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }


}

