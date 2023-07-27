package com.blog.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.blog.UserDetailsImpl;
import com.blog.dao.BlogDAO;
import com.blog.dto.BlogDTO;
import com.blog.entity.Blog;
import com.blog.service.IBlogService;

@Service
public class blogServiceImpl implements IBlogService {
	@Autowired
	private BlogDAO blogRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Blog saveBlog(BlogDTO blogDTO) {
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Blog blog = new Blog();
		blog.setTitle(blogDTO.getTitle());
		blog.setContent(blogDTO.getContent());
		blog.setUserDetailsImpl(userDetails);
		return blogRepository.save(blog);
	}

	@Override
	public BlogDTO getBlogById(Integer id) {
		Optional<Blog> blogopt = blogRepository.findById(id);
		BlogDTO blogdto = null;
		if (blogopt.isPresent()) {
			Blog blog = blogopt.get();
			blogdto = modelMapper.map(blog, BlogDTO.class);
		}
		return blogdto;
	}

	@Override
	public List<BlogDTO> getAll() {
		List<Blog> listBlog = blogRepository.findAll();

		List<BlogDTO> listBlogDTO = new ArrayList<>();
		for (Blog blog : listBlog) {
			BlogDTO blogDTO = modelMapper.map(blog, BlogDTO.class);
			listBlogDTO.add(blogDTO);
		}
		return listBlogDTO;
	}

	@Override
	public BlogDTO deleteblog(Integer id) {
		Optional<Blog> blogupd = blogRepository.findById(id);
		BlogDTO blogDTO = null;
		if (blogupd.isPresent()) {
			Blog blog = blogupd.get();
			blogDTO = modelMapper.map(blog, BlogDTO.class);
			blogRepository.deleteById(id);
		}
		return blogDTO;
	}

}
