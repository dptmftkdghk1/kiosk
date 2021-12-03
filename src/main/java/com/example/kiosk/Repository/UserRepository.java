package com.example.kiosk.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kiosk.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
	Optional<UserEntity> findByUserId(String userId);

}
