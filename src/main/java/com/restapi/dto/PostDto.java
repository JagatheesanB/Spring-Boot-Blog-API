package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.model.Post;
import com.restapi.request.PostRequest;
import com.restapi.response.PostResponse;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDto {


    public Post mapToPost(PostRequest postRequest) {
        Post post = new Post();
        post.setId(postRequest.getId());
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());

        AppUser appUser = new AppUser();
        appUser.setId(postRequest.getUser_id());
        post.setAppUser(appUser);
        return post;
    }

    public PostResponse mapToPostResponse(List<Post> posts) {
        PostResponse postResponse = new PostResponse();

        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            postResponses.add(new PostResponse(post.getId(), post.getTitle(), post.getContent(),
                    post.getAppUser().getId()
            ));
        }
        postResponse.setPosts(postResponses);
        return postResponse;
    }

    public PostResponse mapToSinglePostResponse(Post post) {
        List<Post> singlePostList = new ArrayList<>();
        singlePostList.add(post);
        return mapToPostResponse(singlePostList);
    }

}
