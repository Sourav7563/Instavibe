package com.instavibe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instavibe.entities.User;
import com.instavibe.repositories.UserRepository;

@Service 
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public void addUser(User user) {
		repo.save(user);
		
	}

	@Override
	public boolean userExists(String username, String email) {
		User user1=repo.findByUsername(username);
		User user2=repo.findByEmail(email);
		if(user1 != null || user2 != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean validateUser(String username, String password) {
		String dbPass= repo.findByUsername(username).getPassword();
		if(password.equals(dbPass)) {
			return true;
		}
		return false;
	}

	@Override
	public User getUser(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public void updateUser(User user) {
		repo.save(user);
		
	}

}
