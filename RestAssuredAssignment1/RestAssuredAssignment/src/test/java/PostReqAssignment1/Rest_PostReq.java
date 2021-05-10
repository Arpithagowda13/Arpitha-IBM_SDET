package PostReqAssignment1;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Util.ExcelData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Rest_PostReq {

	@Test(dataProvider = "PostreqData")
	public void postreq01(String name1, String name2, String name3, String name4) {

		RestAssured.baseURI = "http://localhost:3000";
		JSONObject jobj = new JSONObject();

		jobj.put("subject", name1);
		jobj.put("firstname", name2);
		jobj.put("lastname", name3);
		jobj.put("section", name4);

		Response resp = given().contentType(ContentType.JSON).body(jobj).post("/Students").then().statusCode(201).log()
				.all().extract().response();

		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 201);

		ResponseBody respbody = resp.body();
		String strbody = respbody.asString();
		Assert.assertTrue(strbody.contains(name1));
		Assert.assertTrue(strbody.contains(name2));
		Assert.assertTrue(strbody.contains(name3));
		Assert.assertTrue(strbody.contains(name4));

		Assert.assertEquals(strbody.contains("id"), true);

	}

	@DataProvider(name = "PostreqData")
	public Object[][] postreqdata() throws IOException {

		Object[][] data = ExcelData.exceldatafetch1();
		return data;

	}
}
