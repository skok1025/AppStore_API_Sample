package com.cafe24.appstore.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.appstore.service.AppService;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Controller
public class AppController {

	@Autowired
	private AppService appService;
	
	
	@ResponseBody
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	
	
	@RequestMapping("/scripttag")
	public String scriptTags(Model model) throws IOException {
				
		Response response = appService.getScriptTags();
		
		return "scripttag";
	}
	
	
	
	
}
