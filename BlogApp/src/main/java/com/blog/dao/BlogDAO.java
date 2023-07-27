package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.Blog;
@Repository
public interface BlogDAO extends JpaRepository<Blog, Integer>{

}



