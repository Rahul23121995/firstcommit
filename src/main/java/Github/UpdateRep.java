package Github;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class UpdateRep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://api.github.com";
		String owner="Rahul23121995";
		String repo="github3";
		given().header("Authorization","Bearer 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").body("{\r\n"
				+ "    \"description\":\"updated repo\"\r\n"
				+ "}")
		.when().patch("/repos/"+owner+"/"+repo+"")
		.then().assertThat().statusCode(200);

	}

}
