package GithHubusingTestng;

import java.util.Random;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class RepoChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://api.github.com";
		Random randomnum = new Random();
		int min=1;
		int max= 1000;
		String randomname = "Myrepo"+randomnum.nextInt(max);
		System.out.println(randomname);
		given().header("Content-Type","application/json").header("Authorization","Bearer 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")
		.body("{\r\n"
				+ "    \"name\":\""+randomname+"\",\r\n"
				+ "    \"description\":\"This is my first repo in github\"\r\n"
				+ "}")
		.when().post("/user/repos")  
		.then().log().all().assertThat().statusCode(201);
		
		

	}

}
