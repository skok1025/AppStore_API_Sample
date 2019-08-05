package com.cafe24.appstore.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class AppService {

	String accessToken = "br0coyblN9lizhKvV23XpD";
	
	public Response addScriptTag(String scriptNo) throws IOException {
		
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,  "{\n" +
				"    \"shop_no\": 1,\n" +
				"    \"request\": {\n" +
				"        \"src\": \"https://js-aplenty.com/bar"+scriptNo+".js\",\n" +
				"        \"display_location\": [\n" +
				"            \"PRODUCT_LIST\",\n" +
				"            \"PRODUCT_DETAIL\"\n" +
				"        ]\n" +
				"    }\n" +
				"}");

		Request request = new Request.Builder()
		  .url("https://skok10251.cafe24api.com/api/v2/admin/scripttags")
		  .addHeader("authorization", "Bearer "+accessToken)
		  .addHeader("content-type", "application/json")
		  .post(body)
		  .build();

		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		
		
		return response;
	}

	public Response getScriptTags() throws IOException {

		Request request = new Request.Builder()
				  .url("https://skok10251.cafe24api.com/api/v2/admin/scripttags")
				  .addHeader("authorization", "Bearer "+accessToken)
				  .addHeader("content-type", "application/json")
				  .get()
				  .build();

				OkHttpClient client = new OkHttpClient();
				Response response = client.newCall(request).execute();
		
		return response;
	}

	public Response removeScriptTag(String scriptNo) throws IOException {
		Request request = new Request.Builder()
				  .url("https://skok10251.cafe24api.com/api/v2/admin/scripttags/"+scriptNo)
				  .addHeader("authorization", "Bearer "+accessToken)
				  .addHeader("content-type", "application/json")
				  .delete()
				  .build();

				OkHttpClient client = new OkHttpClient();
				Response response = client.newCall(request).execute();
		return response;
	}

}
