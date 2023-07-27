package com.blog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.blog.UserDetailsImpl;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String comment;

	@ManyToOne
	@JoinColumn(name = "bId")
	private Blog blog;

	@ManyToOne()
	@JoinColumn(name = "userId")
	private UserDetailsImpl userDetailsImpl;

	public UserDetailsImpl getUserDetailsImpl() {
		return userDetailsImpl;
	}

	public void setUserDetailsImpl(UserDetailsImpl userDetailsImpl) {
		this.userDetailsImpl = userDetailsImpl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Comment(Integer id, String comment, Blog blog) {
		super();
		this.id = id;
		this.comment = comment;
		this.blog = blog;
	}

	public Comment() {

	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", blog=" + blog + "]";
	}

}
