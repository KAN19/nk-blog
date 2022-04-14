package com.nguyenkietblog.nkblog.service.impl;

import com.nguyenkietblog.nkblog.controller.PostController;
import com.nguyenkietblog.nkblog.converter.PostConverter;
import com.nguyenkietblog.nkblog.converter.TagConverter;
import com.nguyenkietblog.nkblog.dto.PostDto;
import com.nguyenkietblog.nkblog.entity.Post;
import com.nguyenkietblog.nkblog.entity.ServiceResult;
import com.nguyenkietblog.nkblog.entity.Tag;
import com.nguyenkietblog.nkblog.repository.PostRepository;
import com.nguyenkietblog.nkblog.repository.TagRepository;
import com.nguyenkietblog.nkblog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    public PostServiceImpl(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    @Autowired
    private PostConverter postConverter;

    @Autowired
    private TagConverter tagConverter;

    private final Logger LOGGER =
            LoggerFactory.getLogger(PostController.class);

    @Override
    public ServiceResult getAllPost() {
        List<Post> postList = postRepository.findAll();
        return ServiceResult.builder()
                .data(postList)
                .status(ServiceResult.Status.SUCCESS)
                .build();
    }

    @Override
    public ServiceResult savePost(PostDto postDto) {
//        LOGGER.info(post.toString());
        Set<Tag> tagList = tagConverter.tagIdsToTags(postDto.getTags());
//        LOGGER.info(tagList.toString());
        Post post = postConverter.toPostEntity(postDto);

        post.addTags(tagList);

        Post postDb = postRepository.save(post);

        return ServiceResult.builder()
                .data(postConverter.toPostDto(postDb))
                .status(ServiceResult.Status.SUCCESS)
                .build();
    }

    @Override
    public ServiceResult updatePost(Long postId, PostDto postDto) {
        Post postDb = postRepository.findById(postId).get();

        Set<Tag> tagList = tagIdsToTags(postDto.getTags());

        postDb.setTags(tagList);
        postDb.setTitle(postDto.getTitle());
        postDb.setSlug(postDto.getSlug());
        postDb.setContent(postDto.getContent());

        postRepository.save(postDb);

        return ServiceResult.builder()
                .data(postRepository.save(postDb))
                .status(ServiceResult.Status.SUCCESS)
                .build();
    }

    @Override
    public ServiceResult deletePost(Long postId) {
        try {
            postRepository.deleteById(postId);
        } catch (Exception ex) {
            throw new RuntimeException("Loi gi do ne");
        }

        return ServiceResult.builder()
                .status(ServiceResult.Status.SUCCESS)
                .build();
    }

    @Override
    public ServiceResult getPostDetail(Long postId) {
        Post post = postRepository.findById(postId).get();

        return ServiceResult.builder()
                .data(post)
                .status(ServiceResult.Status.SUCCESS)
                .build();
    }

    private Set<Tag> tagIdsToTags(Set<Long> tagIds) {
        Set<Tag> tagList = new HashSet<>();
        tagIds.forEach(tagId -> {
            Tag dbTag = tagRepository.getById(tagId);
            tagList.add(dbTag);
        });
        return tagList;
    }
}
