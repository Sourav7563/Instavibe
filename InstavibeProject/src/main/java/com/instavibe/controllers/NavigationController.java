package com.instavibe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.instavibe.entities.Post;
import com.instavibe.entities.User;
import com.instavibe.services.PostService;
import com.instavibe.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavigationController {

	@Autowired
	UserService service;
	
	@Autowired
	PostService postService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/openSignUp")
	public String openSignUp() {
		return "signUp";
	}
	
	@GetMapping("/openCreatePost")
	public String openCreatePost(HttpSession session) {
		
		if(session.getAttribute("username") != null) {
			return "createPost";
		}
		return "index";
	}
	
	@GetMapping("/goHome")
	public String login(Model model , HttpSession session) {
		
		List<Post> allPosts= postService.fetchAllPosts();
		model.addAttribute("allPosts", allPosts);
		
		if(session.getAttribute("username") != null) {
			return "home";
		}
		return "index";
	}
	
	@GetMapping("/openMyProfile")
	public String openMyProfile(Model model, HttpSession session) {
		
		String username = (String) session.getAttribute("username");
		User user = service.getUser(username);
		model.addAttribute("user", user);
		
		List<Post> myPosts = user.getPosts();
		model.addAttribute("myPosts", myPosts);
		
		if(session.getAttribute("username") != null) {	
			return "myProfile";
		}
		return "index";
	}
	
	@GetMapping("/openEditProfile")
	public String openEditProfile(HttpSession session) {
		
		if(session.getAttribute("username") != null) {
			return "editProfile";
		}
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
