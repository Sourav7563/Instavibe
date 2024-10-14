package com.instavibe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instavibe.entities.Post;
import com.instavibe.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository repo;

	@Override
	public void createPost(Post post) {
		repo.save(post);	
	}

	@Override
	public List<Post> getAllPosts() {
		return repo.findAll();
	}

	@Override
	public List<Post> fetchAllPosts() {	
		return repo.findAll();
	}

	@Override
	public Post getPost(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void updatePost(Post post) {
		repo.save(post);
		
	}

}
