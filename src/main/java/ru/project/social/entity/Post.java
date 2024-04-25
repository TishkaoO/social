package ru.project.social.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "social", name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id_pk")
    private Long postId;

    @Column(name = "name")
    private String name;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_fk")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comments> comments;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;
}
