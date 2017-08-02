package com.allenwish.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allenwish.demo.domain.TSUser;
import com.allenwish.demo.service.MybatisService;

@RestController
public class MybatisController {
	protected static Logger logger=LoggerFactory.getLogger(MybatisController.class);
	
	@Autowired
    private MybatisService mybatisService;
	
	//http://localhost:8080/name/aw
	@RequestMapping(value = "/name/{name}") 
	public Object findByName(@PathVariable String name){
		return mybatisService.findByName(name);
	}
	
	//http://localhost:8080/findAllUser
	@RequestMapping(value = "/findAllUser")
	public Object findAll(){
		logger.debug("find all user");
		return mybatisService.findAll();
	}
	//http://localhost:8080/insertUser?name=allen&age=17&address=上海
	@RequestMapping(value = "/insertUser")
	public Object insertUser(TSUser user){
		logger.debug("insertUser");
		mybatisService.insertUser(user);
		return mybatisService.findAll();
	}
}
