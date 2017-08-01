package com.allenwish.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allenwish.demo.dao.UserDao;
import com.allenwish.demo.domain.User;

@RestController  
public class ObjectRedisController {
	protected static Logger logger=LoggerFactory.getLogger(ObjectRedisController.class);  
    
    @Autowired  
    UserDao userDao;  
      
    //http://localhost:8080/setUser?id=1&name=allen&age=12
    @RequestMapping("/setUser")  
    public void setUser(String id,String name,Integer age){  
        logger.debug("访问setUser:id={},name={},age={}",id,name,age);  
        User user=new User(id,name,age);  
        userDao.save(user);  
    }  
    //http://localhost:8080/getUser?id=1
    @RequestMapping("/getUser")  
    public User getUser(String id){  
    	logger.debug("获取getUser:id={}",id);  
        return userDao.getUser(id);  
    }  
}

