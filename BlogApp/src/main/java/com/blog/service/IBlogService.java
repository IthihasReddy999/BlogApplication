package com.blog.service;

import java.util.List;

import com.blog.dto.BlogDTO;
import com.blog.entity.Blog;

public interface IBlogService {

	public Blog saveBlog(BlogDTO blogDTO);

	public BlogDTO getBlogById(Integer id);

	public List<BlogDTO> getAll();

	public BlogDTO deleteblog(Integer id);

}
