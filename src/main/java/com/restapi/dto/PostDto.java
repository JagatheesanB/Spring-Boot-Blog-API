package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.model.Post;
import com.restapi.request.PostRequest;
import com.restapi.response.PostResponse;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostDto {

    public Post mapToPost(PostRequest postRequest) {
        Post post = new Post();
        post.setId(postRequest.getId());
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
//        post.setId(post.getAppUser().getId());
        return post;
    }

    public PostResponse mapToPostResponse(List<Post> posts) {
        PostResponse postResponse = new PostResponse();

        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            postResponses.add(new PostResponse(post.getId(), post.getTitle(), post.getContent()));
        }
        postResponse.setPosts(postResponses);
        return postResponse;
    }


//    public PostResponse mapToPostResponse(List<Post> posts) {
//        List<PostResponse> postResponses = posts
//                .stream()
//                .map(post -> new PostResponse(post.getId(), post.getTitle(), post.getContent()))
//                .collect(Collectors.toList());
//
//        PostResponse postResponse = new PostResponse();
//        postResponse.setPosts(postResponses);
//        return postResponse;
//    }

}
