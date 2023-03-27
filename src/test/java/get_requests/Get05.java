package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a  GET request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Aaron" and last name is "Chen"
            (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)
     */

   // https://restful-booker.herokuapp.com/booking/?firtsname=Sallay&lastname=Brown

    @Test
    public void get05(){

        //Set the URL
        spec.pathParam("first", "booking").
                queryParams("firstname","Sally","lastname","Brown");

        //Set the expected data

        //Send the request and get the response
        Response response = given().when().spec(spec).get("/{first}");
        response.prettyPrint();

        //Do Assertion
        response.
                then().
                statusCode(200);  //Status code is 200

          //Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı
        assertTrue(response.asString().contains("bookingid"));

    }




}
