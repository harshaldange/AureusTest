package com.aureus.test.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aureus.test.entities.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findById(Long userId);
}
