package com.allenwish.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allenwish.demo.domain.TSUser;
import com.allenwish.demo.repository.UserRepository;

@RestController
public class DataController {
	protected static Logger logger = LoggerFactory
			.getLogger(DataController.class);

	@Autowired
	UserRepository userRespository;

	//http://localhost:8080/save?name=allenwish&address=北京&age=18
	@RequestMapping("/save")
	public TSUser save(String name, String address, Integer age) {
		logger.debug("save 开始");
		TSUser p = userRespository.save(new TSUser(null, name, age, address));
		logger.debug("save 结束");
		return p;
	}
	//http://localhost:8080/delete?id=1
	@RequestMapping("/delete")
	public List<TSUser> delete(Long id){
		logger.debug("delete start");
		userRespository.delete(id);
		logger.debug("delete end");
		return userRespository.findAll();
	}
	
	//http://localhost:8080/update?id=6&name=aw&age=18&address=北京
	@RequestMapping("/update")
	public TSUser update(TSUser user){
		logger.debug("update start");
		if(user==null){
			logger.debug("update but user is null");
			return null;
		}
		TSUser u = null;
		if(user.getId()==null){
			logger.debug("update but userid is null");
			u = userRespository.save(user);
		}
		/****id 不能为null  而且必须保证id对应有数据，否则直接抛异常，所以不存在u==null*******/
		u = userRespository.getOne(user.getId());
		if(u==null){
			logger.debug("update but user not found then save");
			u = userRespository.save(user);
		}else{
			u.setName(user.getName()==null?u.getName():user.getName());
			u.setAddress(user.getAddress()==null?u.getAddress():user.getAddress());
			u.setAge(user.getAge()==null?u.getAge():user.getAge());
			u = userRespository.saveAndFlush(u);
		}
		logger.debug("update end");
		return u;
	}
	//http://localhost:8080/q1?address=北京
	@RequestMapping("/q1")
	public List<TSUser> q1(String address) {
		logger.debug("q1 开始");
		logger.debug("q1 接收参数address={}", address);
		List<TSUser> people = userRespository.findByAddress(address);
		return people;
	}
	//http://localhost:8080/q2?name=ab&address=北京
	@RequestMapping("/q2")
	public List<TSUser> q2(String name, String address) {
		logger.debug("q2 开始");
		logger.debug("q2接收参数name={},address={}", name, address);
		return userRespository.findByNameAndAddress(name, address);
	}

	//http://localhost:8080/q3?name=ab&address=北京
	@RequestMapping("/q3")
	public List<TSUser> q3(String name, String address) {
		logger.debug("q3 开始");
		logger.debug("q3接收参数name={},address={}", name, address);
		return userRespository.withNameAndAddressQuery(name, address);
	}
	//http://localhost:8080/sort
	@RequestMapping("/sort")
	public List<TSUser> sort() {
		logger.debug("sort 开始");
		List<TSUser> people = userRespository.findAll(new Sort(Direction.ASC,
				"age"));
		return people;
	}

	//http://localhost:8080/page?pageSize=2&pageNum=0
	@RequestMapping("/page")
	public Page<TSUser> page(Integer pageSize,Integer pageNum) {
		if(pageSize==null||pageSize<=0){
			pageSize = 1;
		}
		if(pageNum==null||pageNum<0){
			pageNum = 0;
		}
		logger.debug("page 开始");
		Page<TSUser> people = userRespository.findAll(new PageRequest(pageNum, pageSize));
		return people;
	}
}
