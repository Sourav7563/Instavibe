package com.instavibe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instavibe.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
