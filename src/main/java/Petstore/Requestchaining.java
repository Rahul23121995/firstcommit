package Petstore;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Requestchaining {

	public static void main(String[] args) {
		// create pet
		RestAssured.baseURI="https://petstore.swagger.io/v2";
	   String response = given().header("Content-Type","application/json").body("{\r\n"
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
            .then().statusCode(200).extract().response().asString();
	   System.out.println(response);
		
	   JsonPath path=new JsonPath(response);
	           Object id = path.get("id");
	           System.out.println(id);
	           
	           //update pet
	           String Newname="Scooby";
 given().header("Content-Type","application/json").body("{\r\n"
 		+ "  \"id\": "+id+",\r\n"
 		+ "  \"category\": {\r\n"
 		+ "    \"id\": 0,\r\n"
 		+ "    \"name\": \"string\"\r\n"
 		+ "  },\r\n"
 		+ "  \"name\": \""+Newname+"\",\r\n"
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
 .then().log().all().assertThat().statusCode(200).body("name",equalsTo(Newname));
	           
 
 //getpet
  String getresponse = when().post("/pet/"+id+"")
		 .then().assertThat().statusCode(200).extract().response().asString();
	      System.out.println(getresponse);
	      JsonPath json=new JsonPath(getresponse);
	      String ref = json.getString("name");
	      System.out.println(ref);
	      
	}

	private static ResponseAwareMatcher<Response> equalsTo(String newname) {
		// TODO Auto-generated method stub
		return null;
	}

}
