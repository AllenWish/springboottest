package com.allenwish.demo.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.allenwish.demo.domain.User;

@Repository
public class UserDao {
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

	@Resource(name = "redisTemplate")
	ValueOperations<Object, Object> valOps;

	public void save(User user) {
		valOps.set(user.getId(), user);
	}

	public User getUser(String id) {
		return (User) valOps.get(id);
	}
}
