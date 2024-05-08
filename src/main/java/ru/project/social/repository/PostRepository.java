package ru.project.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.project.social.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT * FROM social.posts" +
            " JOIN social.users u on posts.user_fk_id = u.user_id_pk" +
            " WHERE user_id_pk =:userId LIMIT :limit OFFSET :offset ",
            nativeQuery = true)
    List<Post> findPostsByFilter(
            @Param("userId") Long userId,
            @Param("limit") Integer limit,
            @Param("offset") Integer offset);
}
