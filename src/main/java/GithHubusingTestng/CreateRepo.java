package GithHubusingTestng;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class CreateRepo {
	@Test
	public void repo()
	{
		RestAssured.baseURI="https://api.github.com";
		given().header("Content-Type","application/json").header("Authorization","Bearer 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").body("{\r\n"
				+ "    \"name\":\"Pooja\",\r\n"
				+ "    \"description\":\"This is my first repo in github\"\r\n"
				+ "}")
		.when().post("/user/repos")
		.then().log().all().assertThat().statusCode(201);
	}

}
