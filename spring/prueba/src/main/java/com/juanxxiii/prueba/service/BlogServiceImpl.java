package com.juanxxiii.prueba.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanxxiii.prueba.entities.Blog;
import com.juanxxiii.prueba.repository.BlogRepository;

@Service
@Transactional
public class BlogServiceImpl{
	@Autowired
	BlogRepository blogRepository;
	
	public Optional<Blog> findById(Integer id){
		return this.blogRepository.findById(id);
	}

	public List<Blog> findAll(){
		return this.blogRepository.findAll();
	}
	
	public List<Blog> findAllById(Iterable<Integer> idList){
		return this.blogRepository.findAllById(idList);
	}
	
	public List<Blog> saveAll(Iterable<Blog> blogs){
		return this.blogRepository.saveAll(blogs);
	}
	
	public Blog save (Blog blog) {
		return this.blogRepository.save(blog);
	}
	
	public void delete (Blog blog) {
		this.blogRepository.delete(blog);
	}

}
