package utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.Assert;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.requestSpecification;

public class CommonApi {

    public Response getPostResponse(String uri, HashMap<String, String> queryParam, String body, HashMap<String, String> headers, int expectedStatusCode) {
        requestSpecification = RestAssured.given().baseUri(uri).queryParams(queryParam).body(body).headers(headers);
        Response response = requestSpecification.request(Method.POST);

        return response;
    }

    public Response getApiResponse(String basePath, Map<String, String> queryParam, String body, HashMap<String, String> headers, int expectedStatusCode) {
        Response response=RestAssured.given().contentType("application/json").baseUri(basePath).when().request(Method.GET);
        if(null!=body){
            requestSpecification.body(body);
        }
        if(null!=queryParam){
            requestSpecification.queryParams(queryParam);
        }
        if(null!=headers){
            requestSpecification.headers(headers);
        }
        if (response.getStatusCode() == expectedStatusCode) {
            return response;
        } else {

            Assert.fail();
        }
        return null;
    }
}
