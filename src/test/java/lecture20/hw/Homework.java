package lecture20.hw;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Homework {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void register_test() {
        String body = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(body).post("/register");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("id"), "4");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("token"), "QpwL5tke4Pnpja7X4");
    }

    @Test
    public void login_error_test() {
        String body = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(body).post("/login");
        response.then().assertThat().statusCode(400);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("error"), "Missing password");
    }

    @Test
    public void put_test() {
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(body).put("/users/2");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("name"), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("job"), "zion resident");
    }

    @Test
    public void delay_test() {

        Response response = given().header("Content-Type", "application/json").get("/users?delay=3");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("total"), "12");

    }

}
