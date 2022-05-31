package in.co.gorest.usersinfo;

import in.co.gorest.model.PojoClass;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostUsresTest extends TestBase {


    @Test
    public void createUsers() {

        PojoClass studentPojo = new PojoClass();
        studentPojo.setName("Amy");
        studentPojo.setGender("female");
        studentPojo.setEmail("amysmith"+getRandomValue()+"@gmail.com");
        studentPojo.setStatus("active");

                Response response = given()
                        .header("Content-Type","application/json")
                        .header("Authorization"," Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                        .body(studentPojo)
                        .when()
                        .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }



}
