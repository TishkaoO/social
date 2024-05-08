package ru.project.social.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "social", name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id_pk")
    private Long commentId;

    private String name;

    @Column(name = "created_date")
    private LocalDate createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id_fk")
    private Post post;
}
