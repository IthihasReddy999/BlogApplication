package com.blog.service;

import java.util.List;

import com.blog.dto.CommentDTO;
import com.blog.entity.Comment;

public interface ICommentService {

	public Comment saveComment(CommentDTO commentDTO);

	public CommentDTO getCommentById(Integer id);

	public List<CommentDTO> getAll();

	public CommentDTO deleteComment(Integer id);

	public List<CommentDTO> getCommentsByBlog(Integer blogId);
}
