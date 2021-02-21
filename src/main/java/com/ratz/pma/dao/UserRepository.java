package com.ratz.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ratz.pma.entities.UserAccount;

public interface UserRepository extends PagingAndSortingRepository<UserAccount, Long> {

	@Override
	public List<UserAccount> findAll();
}
