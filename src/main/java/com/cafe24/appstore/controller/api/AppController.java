package com.cafe24.appstore.controller.api;

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

@Controller("AppApiController")
@RequestMapping("/api")
public class AppController {

	@Autowired
	private AppService appService;
	
	
	@ResponseBody
	@GetMapping("/scripttag")
	public String scriptTagList() throws IOException {
				
		Response response = appService.getScriptTags();
		System.out.println(response);
		String result = response.body().string();
		System.out.println(result);		
		
		return result;
	}
	
	@ResponseBody
	@DeleteMapping("/scripttag/{scriptNo}")
	public String deleteScriptTag(@PathVariable("scriptNo") String scriptNo) throws IOException {
		
		Response response = appService.removeScriptTag(scriptNo);
		
		System.out.println(response);
		
		return response.body().string();
	}
	
	
	@ResponseBody
	@PostMapping("/scripttag/{scriptNo}")
	public String addScriptTag(@PathVariable("scriptNo") String scriptNo) throws IOException {
		
		Response response = appService.addScriptTag(scriptNo);
		System.out.println(response);
		
		return response.body().string();
	}
	
	
}
