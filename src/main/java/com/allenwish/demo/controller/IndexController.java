package com.allenwish.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
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

	//http://localhost:8080/getHighCharts
	@RequestMapping("/getHighCharts")
	public String getHighCharts() {
		JSONObject j = new JSONObject();
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray();

		json.put("name", "吃货一号");
		json.put("data", new Integer[] { 1, 0, 4, 2 });
		arr.add(json);
		json.put("name", "吃货二号");
		json.put("data", new Integer[] { 1, 5, 3, 1 });
		arr.add(json);
		json.put("name", "吃货三号");
		json.put("data", new Integer[] { 0, 3, 6, 5 });
		arr.add(json);
		j.put("d", arr);
		j.put("c", new String[] { "2017年5月1日", "2017年5月2日", "2017年5月3日",
				"2017年5月4日" });

		return j.toString();
	}
}
