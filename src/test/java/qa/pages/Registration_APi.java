package qa.pages;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.jayway.jsonpath.JsonPath;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

public class Registration_APi extends Basepage 
{
	public Registration_APi(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static String token ;
	public static String jsonAsString ;
	public static String userid ;
	public static String flag ;
	
	public static String tokenadmin ;
	public static int email_otp ;
	public static String Access_Token ;	
	public static String Refresh_Token ;
	
	public static final String BASEURL = "https://qa-kalp-authapi.p2eppl.com";
	
	
	public static final String Signup_url ="/user/create";
	public static final String Get_Otp ="/login/get-otp/";
	public static final String Verify_Otp ="/login/verify/otp";
	
	public void Registration_Api() throws IOException, InterruptedException 
	{
		
		Map<String, Object> mapuser = new HashMap<String,Object>();
		/*mapuser.put("email",Signup.email);
		mapuser.put("password",Signup.pwd);
		mapuser.put("firstName", Signup.Fname);
		mapuser.put("lastName", Signup.Lname);
		mapuser.put("userName", Signup.str);
		mapuser.put("preferredName", Signup.str);
		mapuser.put("countryCode", "");
		mapuser.put("mobileNumber", "");*/
		
		Response response=	given()
				.filter(new RequestLoggingFilter()) 
				.header("Content-Type","application/json")
				.log()
				.all()
				.body(mapuser)
				.post(BASEURL + Signup_url)
				.then()
				.extract().response();
		jsonAsString = response.asString(); // this line will convert JSON response into the string 
		System.out.println(jsonAsString);
		userid = JsonPath.read(jsonAsString, "$.userId"); // this line will extract the User Id from Response
		System.out.println(jsonAsString);
		if(response.getStatusCode()== 400)
		{
			Registration_Api();
		}
		else
		{
			System.out.println("Valid");
		}
	}
	
	public void Get_OTP() throws IOException, InterruptedException 
	{
		
//		
		Response response=	given()
				.filter(new RequestLoggingFilter()) 
				.header("Content-Type","application/json")
				.log()
				.all()			
				.get(BASEURL + Get_Otp + userid )
				.then()
				.extract().response();
		jsonAsString = response.asString(); // this line will convert JSON response into the string 
		System.out.println(jsonAsString);
		email_otp = JsonPath.read(jsonAsString, "$.EMAIL"); // this line will extract the EMAIL OTP from Response
		System.out.println(jsonAsString);	
		System.out.println(response.getStatusCode());
		if(response.getStatusCode()== 400)
		{
			Get_OTP();
		}
		else
		{
			System.out.println("Valid");
		}
		
		
	}
	
	public void Verify_Otp() throws IOException, InterruptedException 
	{
		
		Map<String, Object> mapuser = new HashMap<String,Object>();
		mapuser.put("emailOtp",email_otp);
		mapuser.put("userId",userid);
		
		Response response=	given()
				.filter(new RequestLoggingFilter()) 
				.header("Content-Type","application/json")
				.header("x-user-agent", "{\"device_type\":\"DESKTOP\",\"device_name\":\"iphone\",\"ip_address\":\"192.158.1.38\",\"browser\":\"chrome\",\"os_type\":\"windows\",\"latitude\":\"17.4065° N\",\"longitude\":\"78.4772° E\",\"city\":\"Hyderabad\",\"country\":\"India\",\"timezone\":\"Asia/Calcutta\"}")
				.log()
				.all()
				.body(mapuser)
				.post(BASEURL + Verify_Otp)
				.then()
				.extract().response();
		jsonAsString = response.asString(); // this line will convert JSON response into the string 
		System.out.println(jsonAsString);
		Access_Token = JsonPath.read(jsonAsString, "$.access_token"); // this line will extract the Access_token from Response
		Refresh_Token = JsonPath.read(jsonAsString, "$.refresh_token"); // this line will extract the Refresh_token from Response
		System.out.println(jsonAsString);
		System.out.println(response.getStatusCode());
		if(response.getStatusCode()== 400)
		{
//			response.get
			Verify_Otp();
		}
		else
		{
			System.out.println("Valid");
		}
	}

	public void Signup_url() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
