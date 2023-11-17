package com.restapi.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    //    List<PostResponse> posts = new ArrayList<>();
//    public PostResponse(Long id, String title, String content) {
//
//    }
//    public void setPost(List<Map<String, Object>> formattedPosts) {
//
//    }
    private List<PostResponse> posts;

    private Long id;
    private String title;
    private String content;

    public PostResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}
