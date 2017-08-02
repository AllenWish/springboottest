package com.allenwish.demo.mapper;

import java.util.List;

import com.allenwish.demo.domain.TSUser;

public interface UserMapper {
	public List<TSUser> findByName(String name);

	public List<TSUser> findAll();

	public void insertUser(TSUser user);
}
