package com.nguyenkietblog.nkblog.controller;

import com.nguyenkietblog.nkblog.dto.PostDto;
import com.nguyenkietblog.nkblog.entity.Post;
import com.nguyenkietblog.nkblog.entity.SendingPost;
import com.nguyenkietblog.nkblog.entity.ServiceResult;
import com.nguyenkietblog.nkblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(PostController.class);

    @GetMapping("/posts")
    public ResponseEntity<ServiceResult> getAllPost() {
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<ServiceResult> getPostDetail(@PathVariable("id") Long postId) {
        return new ResponseEntity<>(postService.getPostDetail(postId), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<ServiceResult> savePost(@RequestBody PostDto postDto) {
//        return new ResponseEntity<>(tagService.saveTag(tag), HttpStatus.OK);

        return new ResponseEntity<>(postService.savePost(postDto),HttpStatus.OK);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<ServiceResult> updatePost(
            @PathVariable("id") Long postId,
            @RequestBody PostDto postDto) {
//        return new ResponseEntity<>(tagService.saveTag(tag), HttpStatus.OK);

        return new ResponseEntity<>(postService.updatePost(postId ,postDto),HttpStatus.OK);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<ServiceResult> deletePost(@PathVariable("id") Long postId) {
        return new ResponseEntity<>(postService.deletePost(postId),HttpStatus.OK);
    }



}
