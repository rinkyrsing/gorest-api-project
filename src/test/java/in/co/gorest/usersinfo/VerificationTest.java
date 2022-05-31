package in.co.gorest.usersinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class VerificationTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }
    //1.Total records are 20
    @Test
    public void test001() {
        String totalRecords =  response.extract().path("[*]");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total records : " + totalRecords);
        System.out.println("------------------End of Test---------------------------");
    }

   @Test
    public void test002() {
        String  name =  response.extract().path("[4].name");
        int id = response.extract().path("[5].id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id " + id + " has name : " + name );
        System.out.println("------------------End of Test---------------------------");
    }

    //3.id 2483 has email
    @Test
    public void test003() {
        String email =  response.extract().path("[6].email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The email is : " + email);
        System.out.println("------------------End of Test---------------------------");
    }
    //4.All ID has status
    @Test
    public void test004() {
        List<String> statActive =  response.extract().path("findAll{it.status=='active'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All id had status : " + statActive);
        System.out.println("------------------End of Test---------------------------");
    }
    //5.id has gender female
    @Test
    public void test005() {
        String genderFemale =  response.extract().path("[7].gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id had gender female : " + genderFemale);
        System.out.println("------------------End of Test---------------------------");
    }
    //6.id 2471 has gender
    @Test
    public void test006() {
        String genderMale =  response.extract().path("[3].gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id had gender male : " + genderMale);
        System.out.println("------------------End of Test---------------------------");
    }


}
