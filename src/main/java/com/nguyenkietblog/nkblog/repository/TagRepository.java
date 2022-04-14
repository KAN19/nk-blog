package com.nguyenkietblog.nkblog.repository;

import com.nguyenkietblog.nkblog.entity.Tag;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @EntityGraph("graph.Tag.posts")
    @Override
    Tag getById(Long tagId);


}
