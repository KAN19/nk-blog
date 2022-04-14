package com.nguyenkietblog.nkblog.repository;

import com.nguyenkietblog.nkblog.entity.Post;
import com.nguyenkietblog.nkblog.entity.Tag;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @Test
    public void savePost() {
//        Tag tag = tagRepository.findByTagId(2L);
//        Tag tag2 = tagRepository.findByTagId(1L);
//
//        Post post = postRepository.findByPostId(1L);
//
//        post.addTags(Set.of(tag, tag2));
//
//        postRepository.save(post);
    }

    @Test
    public void getAllPost() {
        List<Post> postList = postRepository.findAll();

        System.out.println("post list ne " + postList.toString());

    }

}