package com.restapi.service;

import com.restapi.dto.PostDto;
import com.restapi.model.AppUser;
import com.restapi.model.Post;
import com.restapi.repository.PostRepository;
import com.restapi.request.PostRequest;
import com.restapi.response.PostResponse;
import com.restapi.response.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostDto postDto;

//    public PostResponse createPost(PostRequest postRequest) {
//        Post post = postDto.mapToPost(postRequest);
//        postRepository.save(post);
//        return findAllPosts();
//    }

    public PostResponse createPost(PostRequest postRequest) {
        Post post = postDto.mapToPost(postRequest);
        postRepository.save(post);
        return findAllPosts();
    }


    public PostResponse findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return postDto.mapToPostResponse(posts);
    }

//    public PostResponse findAllPosts() {
//        List<Post> posts = postRepository.findAll();
//        List<Map<String, Object>> formattedPosts = new ArrayList<>();
//
//        for (Post post : posts) {
//            Map<String, Object> formattedPost = new HashMap<>();
//            formattedPost.put("id", post.getId());
//            formattedPost.put("title", post.getTitle());
//            formattedPost.put("content", post.getContent());
//
//            formattedPosts.add(formattedPost);
//        }
//
//        PostResponse postResponse = new PostResponse();
//        postResponse.setPost(formattedPosts);
//        return postResponse;
//    }

    public PostResponse updatePost(PostRequest postRequest) {
        Post post = postDto.mapToPost(postRequest);
        postRepository.save(post);
        return findAllPosts();
    }

    public PostResponse deletePost(Long id) {
        postRepository.deleteById(Long.valueOf(id));
        return findAllPosts();
    }


    //Admin
    public PostResponse findAll() {
        List<Post> posts = postRepository.findAll();
        return postDto.mapToPostResponse(posts);
    }

    public PostResponse deleteById(Long id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            postRepository.deleteById(id);
            return findAll();
        } else {
            return deletePost(id);
        }

    }


}
