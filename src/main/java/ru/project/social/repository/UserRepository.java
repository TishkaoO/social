package ru.project.social.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.project.social.entity.Post;
import ru.project.social.entity.User;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


}
