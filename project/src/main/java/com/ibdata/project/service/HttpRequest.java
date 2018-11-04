package com.ibdata.project.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.spi.http.HttpContext;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HttpRequest {
	
	public static void main(String[] args) {
	
		try {
			String encode = URLEncoder.encode("대전", "UTF-8");
			System.out.println(encode);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static Logger logger = LoggerFactory.getLogger(HttpRequest.class);
	
	private final String API_KEY = "074ebc86890f8d95581545bc4af7dd46";
	
	public Map<String, Object> textRequest() {
		
		
		Map<String, Object> map = new HashMap<>();
		CloseableHttpResponse response = null;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		String url = "https://dapi.kakao.com/v2/local/search/address.json";
		
		RequestBuilder requestBuilder;
		try {
			String query = URLEncoder.encode("대전", "UTF-8");
			requestBuilder = RequestBuilder.get(new URI(String.format("%s?query=%s", url, query)));
			requestBuilder.setCharset(Charset.forName("UTF-8"));
			requestBuilder.setHeader("Authorization", "KakaoAK 074ebc86890f8d95581545bc4af7dd46");
			
			
			HttpUriRequest request = requestBuilder.build();
			
			response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			String entityString = EntityUtils.toString(entity);
			JSONObject result = new JSONObject(entityString);
			
			
			EntityUtils.consume(entity);
			
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
			logger.debug("URISyntaxException ::: {}", e.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.debug("UnsupportedEncodingException ::: {}", e.getMessage());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			logger.debug("ClientProtocolException ::: {}", e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			logger.debug("IOException ::: {}", e.getMessage());
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
				logger.debug("IOException ::: {}", e.getMessage());
			}
		}

		
		return map;
	}

}
