package Github;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Getrepo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String owner="Rahul23121995";
		String repo="github3";
		RestAssured.baseURI="https://api.github.com";
		given().header("Authorization","Bearer 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")
		.when().get("/repos/"+owner+"/"+repo+"")
		.then().log().all().statusCode(200);

	}

}
