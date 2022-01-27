package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase
{
	TestBase testbase;
	String ServiceURL;
	String apiURL;
	String url;
	RestClient restclient;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException
	{
		testbase = new TestBase();
		ServiceURL = prop.getProperty("URL");
		apiURL = prop.getProperty("serviceURL");
		
		url = ServiceURL + apiURL;
		
	}
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException
	{
		restclient = new RestClient();
		restclient.get(url);
	}

}
