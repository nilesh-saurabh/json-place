package jsonplace;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.slf4j.Logger;
import testutilities.TestUtilities;

import java.io.File;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;


public class CreateJsonPlace {

    private static final Logger LOGGER = getLogger(CreateJsonPlace.class);


    File payload = new File(System.getProperty("user.dir") + "/src/test/resources/createjsonplace.json");

    @Test
    public void createNewPosts() {

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.body(payload);
        request.baseUri(TestUtilities.getProperty("baseURI") + "/posts");
        request.log().all();

        Response response = request.post();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
        validatableResponse.statusLine("HTTP/1.1 201 Created");

        LOGGER.info("Newly created posts id is : " + response.path("id"));

    }


}


