package com.instavibe.services;

import java.util.List;

import com.instavibe.entities.Post;

public interface PostService {

	void createPost(Post post);

	List<Post> getAllPosts();

	List<Post> fetchAllPosts();

	Post getPost(Long id);

	void updatePost(Post post);

}
