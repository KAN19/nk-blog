package com.nguyenkietblog.nkblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "posts")
@NamedEntityGraph(
        name = "graph.Post.tags",
        attributeNodes = @NamedAttributeNode("tags")
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post extends BaseEntity {

    private String title;
    private String slug;
    private String content;
//    private Integer postView;
    private String thumbnail;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(
            name = "posts_tags",
            joinColumns = {
                    @JoinColumn(name = "post_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "tag_id")
            }
    )
    @JsonManagedReference
    private Set<Tag> tags;

    public void addTags(Set<Tag> addingTags) {
        if (tags == null) tags = new HashSet<>();
        tags.addAll(addingTags);
    }

//    @Override
//    public String toString() {
//        return "Post{" +
//                "postId=" + id +
//                ", postTitle='" + postTitle + '\'' +
//                ", postSlug='" + postSlug + '\'' +
//                ", postContent='" + postContent + '\'' +
//                ", postView=" + postView +
//                ", createdAt=" + createdAt +
//                ", tags=" + tags +
//                '}';
//    }
}
