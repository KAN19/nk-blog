package com.nguyenkietblog.nkblog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String slug;
    private String content;
    private String thumbnail;

    private Set<Long> tags;
}
