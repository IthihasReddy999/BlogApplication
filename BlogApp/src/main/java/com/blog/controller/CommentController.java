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
import com.blog.dto.CommentDTO;
import com.blog.entity.Comment;
import com.blog.service.ICommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private ICommentService iCommentService;

	@PostMapping("/savecommment")
	public ResponseEntity<Comment> saveComment(@RequestBody CommentDTO commentDTO) {
		Comment commentdto = iCommentService.saveComment(commentDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(commentdto);
	}

	@GetMapping("getCommentId/{id}")
	public ResponseEntity<CommentDTO> getByCommentid(@PathVariable(name = "id") Integer id) {
		CommentDTO commentDTO = iCommentService.getCommentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(commentDTO);
	}

	@GetMapping("getCommentsByBlog/{id}")
	public ResponseEntity<List<CommentDTO>> getCommentsByBlog(@PathVariable(name = "id") Integer id) {
		List<CommentDTO> commentDTO = iCommentService.getCommentsByBlog(id);
		return ResponseEntity.status(HttpStatus.OK).body(commentDTO);
	}

	@GetMapping("/getAllComments")
	public ResponseEntity<List<CommentDTO>> getAll() {
		List<CommentDTO> commentDto = iCommentService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(commentDto);
	}

	@DeleteMapping("/deleteComment/{id}")
	public ResponseEntity<CommentDTO> deleteCommentById(@PathVariable(name = "id") Integer id) {
		CommentDTO commentDto = iCommentService.deleteComment(id);
		return ResponseEntity.status(HttpStatus.OK).body(commentDto);
	}

}
