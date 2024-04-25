package ru.project.social.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "social", name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id_pk")
    private Long likeId;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id_fk")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_source_id_fk")
    private User user;


}
