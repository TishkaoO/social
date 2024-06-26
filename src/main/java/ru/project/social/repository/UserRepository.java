package ru.project.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.social.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
