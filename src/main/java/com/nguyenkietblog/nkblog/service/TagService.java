package com.nguyenkietblog.nkblog.service;

import com.nguyenkietblog.nkblog.entity.ServiceResult;
import com.nguyenkietblog.nkblog.entity.Tag;

public interface TagService {
    ServiceResult getAllTags();

    ServiceResult saveTag(Tag tag);

    ServiceResult updateTag(Long tagId, Tag tag);

    ServiceResult deleteTag(Long tagId);

    ServiceResult getPostByTag(Long tagId);
}
