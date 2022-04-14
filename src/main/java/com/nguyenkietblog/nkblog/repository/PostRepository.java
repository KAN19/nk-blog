package com.nguyenkietblog.nkblog.repository;

import com.nguyenkietblog.nkblog.entity.Post;
import com.nguyenkietblog.nkblog.entity.Tag;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//    @EntityGraph("graph.Post.tags")
//    Post getById(Long postId);
//
//    @Override
//    @EntityGraph("graph.Post.tags")
//    List<Post> findAll();
}
