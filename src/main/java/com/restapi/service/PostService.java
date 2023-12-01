package com.restapi.service;

import com.restapi.dto.PostDto;
import com.restapi.exception.common.ResourceNotFoundException;
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


    public PostResponse createPost(PostRequest postRequest) {
        Post post = postDto.mapToPost(postRequest);
        postRepository.save(post);
        return findAllPosts();
    }


    public PostResponse findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return postDto.mapToPostResponse(posts);
    }

    public PostResponse findPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return postDto.mapToSinglePostResponse(post.get());
        } else {
            throw new ResourceNotFoundException("Post not found with id: ", "id", +id);
        }
    }


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
