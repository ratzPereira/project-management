package com.ratz.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.ratz.pma.entities.UserAccount;

public interface UserRepository extends CrudRepository<UserAccount, Long> {

	@Override
	public List<UserAccount> findAll();
}
