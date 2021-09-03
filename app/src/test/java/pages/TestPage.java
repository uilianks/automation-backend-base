package pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class TestPage{

    public boolean executeGet() {
        try {
            Response response = given()
                    .get("https://reqres.in/api/users?page=2");
            Assert.assertEquals(200, response.statusCode());
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean executePOST() {
        try {
            Response response = given()
                    .header("Content-type", "application/json")
                    .and()
                    .body("{\n" +
                            "    \"name\": \"morpheus\",\n" +
                            "    \"job\": \"leader\"\n" +
                            "}")
                    .when()
                    .post("https://reqres.in/api/users")
                    .then()
                    .extract().response();
            Assert.assertEquals(201, response.statusCode());
            Assert.assertEquals("morpheus", response.jsonPath().getString("name"));
            Assert.assertEquals("leader", response.jsonPath().getString("job"));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean executePUT() {
        try {
            Response response = given()
                    .header("Content-type", "application/json")
                    .and()
                    .body("{\n" +
                            "    \"name\": \"morpheus\",\n" +
                            "    \"job\": \"zion resident\"\n" +
                            "}")
                    .when()
                    .put("https://reqres.in/api/users/2")
                    .then()
                    .extract().response();
            Assert.assertEquals(200, response.statusCode());
            Assert.assertEquals("morpheus", response.jsonPath().getString("name"));
            Assert.assertEquals("zion resident", response.jsonPath().getString("job"));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean executeDELETE() {
        try {
            Response response = given()
                    .header("Content-type", "application/json")
                    .and()
                    .body("{\n" +
                            "    \"name\": \"morpheus\",\n" +
                            "    \"job\": \"zion resident\"\n" +
                            "}")
                    .when()
                    .delete("https://reqres.in/api/users/2")
                    .then()
                    .extract().response();
            Assert.assertEquals(204, response.statusCode());
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
