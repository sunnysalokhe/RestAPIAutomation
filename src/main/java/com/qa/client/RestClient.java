package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient 
{
	public void get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet getCall = new HttpGet(url);  // http get request
		CloseableHttpResponse closeableResponse = httpClient.execute(getCall);  //hit GET url
		
		int statusCode = closeableResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is ---> " + statusCode);  // get status code
		
		String responseString =  EntityUtils.toString(closeableResponse.getEntity(),"UTF-8");
		
		JSONObject responseJson = new JSONObject();  // convert response string into JSON format
		System.out.println("Response JSON from API --->" + responseJson);
		
		
		Header[] headersArray = closeableResponse.getAllHeaders(); // get headers from response-- it will be in array format
		
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		
		for(Header header : headersArray)
		{
			allHeaders.put(header.getName(), header.getValue());
		}
		
		System.out.println("All Headers ---->" + allHeaders);
		
	}
	
	

}
