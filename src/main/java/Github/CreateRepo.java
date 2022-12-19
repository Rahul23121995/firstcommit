package Github;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import files.body;

public class CreateRepo {
	public static void main(String[] args) {
		RestAssured.baseURI="https://api.github.com";
		given().header("Content-Type","application/json").body(body.newbody()).header("Authorization","Bearer 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")
		.when().post("/user/repos")
		.then().log().all().statusCode(201).header("server","Github.com");
		
	}

}
