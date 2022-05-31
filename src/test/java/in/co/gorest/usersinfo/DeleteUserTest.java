package in.co.gorest.usersinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTest extends TestBase {

    @Test
    public void deleteUserData(){

          Response response = given()
                  .header("Content-Type","application/json")
                  .header("Authorization", "Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                  .pathParam("id", 3948)
                  .when()
                  .delete("/{id}")
                  .then()
                  .extract().response();
          response.then().statusCode(204);
          response.prettyPrint();

    }




}
