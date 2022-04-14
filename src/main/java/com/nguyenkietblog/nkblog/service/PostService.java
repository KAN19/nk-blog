package com.nguyenkietblog.nkblog.service;

import com.nguyenkietblog.nkblog.dto.PostDto;
import com.nguyenkietblog.nkblog.entity.Post;
import com.nguyenkietblog.nkblog.entity.ServiceResult;
import com.nguyenkietblog.nkblog.entity.Tag;

import java.util.Set;

public interface PostService {
    ServiceResult getAllPost();

    ServiceResult savePost(PostDto postDto);

    ServiceResult updatePost(Long postId, PostDto postDto);

    ServiceResult deletePost(Long postId);

    ServiceResult getPostDetail(Long postId);
}
