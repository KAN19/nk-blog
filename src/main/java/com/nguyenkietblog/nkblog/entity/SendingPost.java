package com.nguyenkietblog.nkblog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SendingPost {

    private String postTitle;
    private String postSlug;
    private String postContent;
    private Set<Long> tags;

    @Override
    public String toString() {
        return "SendingPost{" +
                "tags=" + tags +
                '}' + " Title: " + postTitle + " Slug: " + postSlug + " Content: " + postContent;
    }

}
