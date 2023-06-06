package com.auth.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersM, Long> {

	UsersM findByUsername(String username);
}