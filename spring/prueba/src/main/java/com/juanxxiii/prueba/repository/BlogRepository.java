package com.juanxxiii.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.juanxxiii.prueba.entities.Blog;
@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer>{
	@Query("SELECT b FROM Blog b WHERE LOWER(b.content) = LOWER(:text)")
	Blog getBlogById(String text);
}
