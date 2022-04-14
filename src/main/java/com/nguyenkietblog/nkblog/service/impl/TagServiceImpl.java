package com.nguyenkietblog.nkblog.service.impl;

import com.nguyenkietblog.nkblog.entity.ServiceResult;
import com.nguyenkietblog.nkblog.entity.Tag;
import com.nguyenkietblog.nkblog.repository.TagRepository;
import com.nguyenkietblog.nkblog.service.TagService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public ServiceResult getAllTags() {
        List<Tag> tags = tagRepository.findAll();
        return ServiceResult.builder()
                        .data(tags)
                        .status(ServiceResult.Status.SUCCESS)
                        .build();

    }

    @Override
    public ServiceResult saveTag(Tag tag) {
        tagRepository.save(tag);
        return ServiceResult.builder()
                .data(tag)
                .status(ServiceResult.Status.SUCCESS)
                .build();
    }

    @Override
    public ServiceResult updateTag(Long tagId, Tag tag) {

        Tag tagDb = tagRepository.findById(tagId)
                .orElseThrow(() -> new EntityNotFoundException("Khong tim thay " + tagId.toString()));

        if (Objects.nonNull(tag.getName())
                && !"".equalsIgnoreCase(tag.getName())) {
            tagDb.setName(tag.getName());
        }

        tagRepository.save(tagDb);
        return ServiceResult.builder()
                .data(tagDb)
                .status(ServiceResult.Status.SUCCESS)
                .build();
    }

    @Override
    public ServiceResult deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
        return ServiceResult.builder()
                .status(ServiceResult.Status.SUCCESS)
                .build();
    }

    @Override
    public ServiceResult getPostByTag(Long tagId) {
        Tag tag = tagRepository.findById(tagId).get();

        return ServiceResult.builder()
                .status(ServiceResult.Status.SUCCESS)
                .data(tag.getPosts())
                .build();
    }
}
