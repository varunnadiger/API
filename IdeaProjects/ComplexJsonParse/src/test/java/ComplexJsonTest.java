import io.restassured.path.json.JsonPath;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;

public class ComplexJsonTest {


    public static void main(String[] args)  {

        JsonPath  js = new JsonPath(Payload.CoursePrice());

        //Print the number of course in API

        int count = js.getInt("courses.size()");
        System.out.println(count);

        //Print the Purchase amount

        int purchaseAmount =  js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

        //Print the title of the First course

         String firstCourse = js.get("courses[0].title") ;


        System.out.println(firstCourse );

        //print all the courses and respective prices

        for ( int i = 0 ; i < count;i++) {

            // js.get("courses["+i+"].title").toString() ;
            String courseTitles =js.get("courses["+i+"].title");
            System.out.println(courseTitles);
           // System.out.println(js.getInt("courses["+i+"].price"));
         String prices = js.get("courses@v@yA982" +
                 "@v@y["+i+"].price").toString();
      System.out.println(prices);

        }







    }



}
