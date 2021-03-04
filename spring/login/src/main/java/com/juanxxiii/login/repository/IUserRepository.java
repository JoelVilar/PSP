package com.juanxxiii.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juanxxiii.login.entities.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
	@Query("Select count(u) from User u where u.name = user.name AND u.password = user.password")
	public Long userIsCorrect(User user);
	@Query("Select count(u) from User u where u.name = user.name")
	public Long getUserByName(User user);
}
