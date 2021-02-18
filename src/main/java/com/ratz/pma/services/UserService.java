package com.ratz.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratz.pma.dao.UserRepository;
import com.ratz.pma.entities.UserAccount;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	public UserAccount save(UserAccount userAccount) {
		return userRepo.save(userAccount);
	}
	
	public List<UserAccount> findAll() {
		return userRepo.findAll();
	}
}
