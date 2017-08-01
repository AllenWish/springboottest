package com.allenwish.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
