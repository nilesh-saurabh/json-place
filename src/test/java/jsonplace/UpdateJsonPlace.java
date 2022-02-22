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

import static org.slf4j.LoggerFactory.getLogger;


public class UpdateJsonPlace {

    private static final Logger LOGGER = getLogger(UpdateJsonPlace.class);


    File payload = new File(System.getProperty("user.dir") + "/src/test/resources/updatejsonplace.json");

    @Test
    public void updateNewPosts() {

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.body(payload);
        request.baseUri(TestUtilities.getProperty("baseURI") + "/posts/1");
        request.log().all();

        Response response = request.put();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");

        LOGGER.info("Newly updated posts id is : " + response.path("id"));

    }


}


