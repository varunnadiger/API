package test;

import com.qa.base.TestBase;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.com.client.RestClient;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.HashMap;

public class GetApiTest extends TestBase  {
    TestBase testbase;
    String ServiceURL;
    String apiURL;
    String URL;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    private TimedSemaphore semaphore;

    @BeforeMethod

    public void setUp()  {

         testbase = new TestBase();
         ServiceURL = prop.getProperty("URL");
         apiURL = prop.getProperty("ServiceURL");
         URL = ServiceURL + apiURL ;
    }

    @Test

    public void getTest() throws IOException {
        RestClient restClient = new RestClient();
        closeableHttpResponse = restClient.get(URL);

        //a. Status code
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
      //  System.out.println("Status Code --->" + statusCode);

        Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code not 200");


        //b. Json String
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson = new JSONObject(responseString);
       // System.out.println("Response JSON from API-->" + responseJson);

        //c. All headers

        Header[] headerArray = closeableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header : headerArray) {

            allHeaders.put(header.getName(), header.getValue());
          //  System.out.println("HeaderArray-->" + allHeaders);


        }


    }

}
