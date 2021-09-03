package pages;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;

import static io.restassured.RestAssured.when;

public class TestPage{
    public boolean executeGet() {
        try {
            when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", Matchers.is(2));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
