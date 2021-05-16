package org.com.client;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;


public class RestClient {

      //1.GET  Method

   public CloseableHttpResponse get (String url) throws ClientProtocolException, IOException {
      CloseableHttpClient httpClient = HttpClients.createDefault();
      HttpGet httpGet = new HttpGet(url); // http get request
      CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet); //hit the get URL

      return closeableHttpResponse;





   }
}
