package com.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.blog.entity.Comment;
@Repository
public interface CommentDAO extends JpaRepository<Comment, Integer> {

	@Query("select c from Comment c join c.blog b where b.id=?1")
	 public List<Comment> getCommentsByBlog(Integer id);
	
	
}
