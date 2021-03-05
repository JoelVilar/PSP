package com.juanxxiii.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juanxxiii.login.entities.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
	@Query("Select count(u) from User u where u.name = :name AND u.password = :password")
	public Long userIsCorrect(String name, String password);
	@Query("Select count(u) from User u where u.name = :name")
	public Long getUserByName(String name);
}
