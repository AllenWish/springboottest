package com.allenwish.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allenwish.demo.domain.TSUser;
import com.allenwish.demo.mapper.UserMapper;

@Service
public class MybatisService {
	@Autowired
    private UserMapper userMapper;
	
	public List<TSUser> findByName(String name){
		return userMapper.findByName(name);
	}
}
