package com.nguyenkietblog.nkblog.converter;

import com.nguyenkietblog.nkblog.dto.PostDto;
import com.nguyenkietblog.nkblog.entity.Post;
import com.nguyenkietblog.nkblog.entity.Tag;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PostConverter {

    public Post toPostEntity(PostDto postDto) {
        return Post.builder()
                .content(postDto.getContent())
                .title(postDto.getTitle())
                .thumbnail(postDto.getThumbnail())
                .slug(postDto.getSlug())
                .build();
    }

    public PostDto toPostDto(Post post) {
        Set<Long> tags = new HashSet<>();

        post.getTags().forEach(tag -> {
            tags.add(tag.getId());
        });

        return PostDto.builder()
                .id(post.getId())
                .thumbnail(post.getThumbnail())
                .content(post.getContent())
                .slug(post.getSlug())
                .title(post.getTitle())
                .tags(tags)
                .build();
    }

    public Post toPostDtoFull(Post post) {

        Set<Tag> tags = new HashSet<>(post.getTags());

        return Post.builder()
                .thumbnail(post.getThumbnail())
                .content(post.getContent())
                .slug(post.getSlug())
                .title(post.getTitle())
                .tags(tags)
                .build();
    }

}
