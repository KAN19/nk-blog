package com.nguyenkietblog.nkblog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tags")
@NamedEntityGraph(
        name = "graph.Tag.posts",
        attributeNodes = @NamedAttributeNode("posts")
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tag extends BaseEntity{

//    @NotBlank(message = "Please add department name")
    private String name;

    private String description;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Set<Post> posts = new HashSet<Post>();
}
