package com.allenwish.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	protected static Logger logger = LoggerFactory
			.getLogger(IndexController.class);

	// http://localhost:8080/hello
	@RequestMapping("/hello")
	public String index() {
		JSONObject json = new JSONObject();
		logger.debug("访问hello");
		try {
			json.put("name", "tom");
			json.put("age", "18");
			json.put("address", "祖冲之南路绿地同创大厦2005室");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	// http://localhost:8080/hello/allenwish
	@RequestMapping("/hello/{name}")
	public String name(@PathVariable String name) {
		JSONObject json = new JSONObject();
		logger.debug("访问hello" + name);
		try {
			json.put("name", name);
			json.put("age", "18");
			json.put("address", "祖冲之南路绿地同创大厦2005室");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	// http://localhost:8080/resource
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello AllenWish,greeting that you do it!!!");
		return model;
	}
}
