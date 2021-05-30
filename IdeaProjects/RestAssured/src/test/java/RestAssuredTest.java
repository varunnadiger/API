import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static jdk.nashorn.internal.objects.NativeFunction.function;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest {

    public static void main(String[] args) {
        String pathPost = "https://reqres.in/api/users";
        String pathPut = "https://reqres.in/api/users/2";
        //To Do
        //Given - All the input details
        //When - Submit all the API
        //Then -Validate the response

        RestAssured.baseURI = "https://reqres.in";
                //pathPost;

        String response = given().log().all().header("Content-Type", "application/json")
                .body("{\r\n" + "\"name\": \"morpheus\",\r\n" + "\"job\":\"leader\"\r\n" + "}").
                        when().post("api/users").then().assertThat().statusCode(201).body("name", equalTo("morpheus"))
                .header("server", "cloudflare").extract().response().asString();
        System.out.println("Response is " +response);
        System.out.println("The Post path is" +pathPost);


         JsonPath js = new JsonPath(response);
         String job= js.getString("job");

        System.out.println("Place id -->>>" +job);

        //2. Put update place

        given().log().all().header("Content-Type", "application/json")
                .body("{\r\n" + "\"name\": \"morpheus\",\r\n" + "\"job\":\"zion resident\"\r\n" + "}").
                when().put("api/users/2").then().assertThat().statusCode(200).body("job",equalTo("zion resident"))
        .header("server", "cloudflare").extract().response().toString();

      //  System.out.println("the response" +responsePut);
        System.out.println("The path: "+pathPut);

     //   JsonPath js1 = new JsonPath(responsePut); 
      //  String test = js1.getString("name");
       // System.out.println("Test --->>>>>>>>" +test);

        //3.Get Request
             String responseget = given().log().all()
                 .when().get("api/users?page").then().log().all().statusCode(200).extract().response().asString();
                String page = "1";
                JsonPath js1 = new JsonPath((responseget));
                String getJob1=  js1.getString("page");
        System.out.println("The Get name -->>>>" +getJob1);
            Assert.assertEquals(getJob1,"2" );



     //   System.out.println(responseget);
    }
}
