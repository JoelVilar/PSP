package com.juanxxiii.prueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juanxxiii.prueba.entities.Blog;
import com.juanxxiii.prueba.service.BlogServiceImpl;

@RestController
@RequestMapping(path = "/blog")
public class BlogController {
	@Autowired
	BlogServiceImpl blogServiceImpl;
	
//	@GetMapping("/blogs")
//	public List<Blog> getBlog(){
//		return List.of(new Blog("titulo1", "badfj"),
//				new Blog("titulo2", "badfj"),
//				new Blog("titulo3", "badfj"));
//	}
	
/*	@GetMapping
	public List<Blog> index(){
		return this.blogServiceImpl.findAll();
	}*/
	@GetMapping("/{id}")
	public Optional<Blog> getById(@PathVariable Integer id){
		return blogServiceImpl.findById(id);
	}
	@PostMapping
	public Blog create(@RequestBody Blog blog) {
		return this.blogServiceImpl.save(blog);
	}
	
	@GetMapping
	public List<Blog> getByTitle(@RequestParam("title") String title){
		return this.blogServiceImpl.findByTitle(title);
	}
	
}
