package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.BlogDTO;
import com.blog.entity.Blog;
import com.blog.service.IBlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private IBlogService blogService;

	@PostMapping("/blogsave")
	public ResponseEntity<Blog> saveBlog(@RequestBody BlogDTO blogDTO) {
		Blog blog = blogService.saveBlog(blogDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(blog);
	}

	@GetMapping("getId/{id}")
	public ResponseEntity<BlogDTO> getByBlogid(@PathVariable(name = "id") Integer id) {
		BlogDTO blogDTO = blogService.getBlogById(id);
		return ResponseEntity.status(HttpStatus.OK).body(blogDTO);
	}

	@GetMapping("/getAllBlogs")
	public ResponseEntity<List<BlogDTO>> getAll() {
		List<BlogDTO> listDto = blogService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(listDto);
	}

	@DeleteMapping("/deleteBLog/{id}")
	public ResponseEntity<BlogDTO> deleteBlogById(@PathVariable(name = "id") Integer id) {
		BlogDTO blogDto = blogService.deleteblog(id);
		return ResponseEntity.status(HttpStatus.OK).body(blogDto);
	}

}
