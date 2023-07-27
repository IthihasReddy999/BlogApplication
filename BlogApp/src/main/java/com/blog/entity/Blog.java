package com.blog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.blog.UserDetailsImpl;

@Entity
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String content;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Blog(Integer id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Blog() {

	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

}
