package Petstore;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Createpet {

	public static void main(String[] args) {
		//* Im trying to verify whether the pet is created
		
		//1.set the base URI
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
	//2.provide the data inputs
		given().header("Content-Type","application/json").body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}")
		.when().post("/pet")
		.then().log().all().statusCode(200);
		

	}

}
