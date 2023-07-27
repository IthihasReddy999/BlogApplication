package com.blog.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.blog.UserDetailsImpl;
import com.blog.dao.CommentDAO;
import com.blog.dto.CommentDTO;
import com.blog.entity.Comment;
import com.blog.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Comment saveComment(CommentDTO commentDTO) {
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Comment comment = new Comment();
		comment.setId(commentDTO.getId());
		comment.setComment(commentDTO.getComment());
		comment.setBlog(commentDTO.getBlog());
		comment.setUserDetailsImpl(userDetails);
		return commentDAO.save(comment);
	}

	@Override
	public CommentDTO getCommentById(Integer id) {
		Optional<Comment> commentopt = commentDAO.findById(id);
		CommentDTO commentdto = null;
		if (commentopt.isPresent()) {
			Comment comment = commentopt.get();
			commentdto = modelMapper.map(comment, CommentDTO.class);
		}
		return commentdto;
	}

	@Override
	public List<CommentDTO> getCommentsByBlog(Integer blogId) {
		List<Comment> listcomment = commentDAO.getCommentsByBlog(blogId);
		CommentDTO commentdto = null;
		List<CommentDTO> listcommentDTO = new ArrayList<>();
		for (Comment comment : listcomment) {
			commentdto = modelMapper.map(comment, CommentDTO.class);
			listcommentDTO.add(commentdto);
		}
		return listcommentDTO;
	}

	@Override
	public List<CommentDTO> getAll() {
		List<Comment> listcomment = commentDAO.findAll();
		CommentDTO commentDTO = null;
		List<CommentDTO> listcommentDTO = new ArrayList<>();
		for (Comment comment : listcomment) {
			commentDTO = modelMapper.map(comment, CommentDTO.class);
			listcommentDTO.add(commentDTO);
		}
		return listcommentDTO;
	}

	@Override
	public CommentDTO deleteComment(Integer id) {
		Optional<Comment> commentopt = commentDAO.findById(id);
		CommentDTO commentDTO = null;
		if (commentopt.isPresent()) {
			Comment comment = commentopt.get();
			commentDTO = modelMapper.map(comment, CommentDTO.class);
			commentDAO.deleteById(id);
		}
		return commentDTO;
	}

}
