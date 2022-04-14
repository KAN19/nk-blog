package com.nguyenkietblog.nkblog.converter;

import com.nguyenkietblog.nkblog.entity.Tag;
import com.nguyenkietblog.nkblog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TagConverter {

    @Autowired
    private TagRepository tagRepository;

    public Set<Tag> tagIdsToTags(Set<Long> tagIds) {
        Set<Tag> tagList = new HashSet<>();
        tagIds.forEach(tagId -> {
            Tag dbTag = tagRepository.getById(tagId);
            tagList.add(dbTag);
        });
        return tagList;
    }
}
