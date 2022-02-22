package jsonplace;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import testutilities.TestUtilities;

import java.io.IOException;
import java.util.ArrayList;

import static org.slf4j.LoggerFactory.getLogger;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GetJsonPlace {

    private static final Logger LOGGER = getLogger(GetJsonPlace.class);

    ArrayList<Integer> firstId, firsUserId, firstPostId, firsEmailId;


    /**
     *  Test to get user with username
     */
    @Test
    public void getPersonWithUsername() {

        RequestSpecification request = RestAssured.given();
        request.baseUri(TestUtilities.getProperty("baseURI") + "/users").queryParam("username",TestUtilities.getProperty("username"));
        request.log().all();

        Response response = request.get();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");
        firstId = response.jsonPath().getJsonObject("id");
        LOGGER.info(String.valueOf(firstId));
        Assert.assertNotEquals(response.jsonPath().getJsonObject("name"),"");

    }

    /**
     *  Test to get details of posts from the earlier userID
     */
    @Test
    public void getPostsByUserId() {

        RequestSpecification request = RestAssured.given();
        request.baseUri(TestUtilities.getProperty("baseURI") + "/posts").queryParam("userId", "9");
        request.log().all();

        Response response = request.get();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");
        firsUserId = response.jsonPath().getJsonObject("userId");
        firstPostId = response.jsonPath().getJsonObject("id");
        LOGGER.info(String.valueOf(firsUserId));
        LOGGER.info(String.valueOf(firstPostId));
        Assert.assertTrue(firsUserId.size() > 0);
        Assert.assertNotEquals(response.jsonPath().getJsonObject("title"),"");

    }

    /**
     *  Test to get User Comments from posts
     */
    @Test
    public void getUserCommentsFromPosts() {

        RequestSpecification request = RestAssured.given();
        request.baseUri(TestUtilities.getProperty("baseURI") + "/posts/81" + "/comments");
        request.log().all();

        Response response = request.get();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");
        firsEmailId = response.jsonPath().getJsonObject("email");
        LOGGER.info(String.valueOf(firsEmailId));
        Assert.assertNotEquals(response.jsonPath().getJsonObject("email"),"");

    }

    /**
     *  Test to get user with wrong username
     */
    @Test
    public void getPersonWithWrongUsername() {

        RequestSpecification request = RestAssured.given();
        request.baseUri(TestUtilities.getProperty("baseURI") + "/users").queryParam("username",TestUtilities.getProperty("wrongUsername"));
        request.log().all();

        Response response = request.get();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");
        validatableResponse.body(Matchers.equalTo("[]"));

    }

}
