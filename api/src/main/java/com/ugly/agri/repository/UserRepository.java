package com.ugly.agri.repository;

import com.ugly.agri.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByIsDeletedFalse();

    Optional<User> findByIdAndIsDeletedFalse(Long id);

    Optional<User> findByEmailAndPassword(String email, String password);

    boolean existsByEmailAndIsDeletedFalse(String email);
}