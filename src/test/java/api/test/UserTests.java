package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
    
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger= LogManager.getLogger(this.getClass());
	}
/*	
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.debug("*********** Creating User ***********");
		Response res= UserEndPoints.createUser(userPayload);
		res.then().log().body();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	} 
	
	
	
//	Ignore this test for the demo server
//	Since the Swagger Petstore API doesn't persist data, you can:
//	Mark the test as expected to fail (for documentation/demo only)
//	Or skip testGetUserByName() when running against Swagger's hosted API  
	
	@Test(priority=2, enabled = false)
	public void testGetUserByName()
	{
		logger.debug("*********** Reading User Info ***********");
		Response res= UserEndPoints.readUser(this.userPayload.getUsername());
		res.then().log().body();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.debug("*********** User Info is displayed ***********");
	}
	
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		logger.debug("*********** Updating User ***********");
		
		//update data using payload
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		
		Response res= UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		res.then().log().body();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.debug("*********** User is Updated ***********");
		
		//checking data after update
		Response resAfterUpdate= UserEndPoints.readUser(this.userPayload.getUsername());
		resAfterUpdate.then().log().body();
		Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
	}
	
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.debug("*********** Deleting User ***********");
		
		Response res= UserEndPoints.readUser(this.userPayload.getUsername());		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.debug("*********** User Deleted ***********");
		
	}
	
*/	
	
//====================== using chatgpt code for detailed logs ======================
	
	@Test(priority=1)
	public void testPostUser()
	{
	    logger.info("*********** Creating User ***********");
	    logger.debug("User Payload: " + userPayload.toString());  // Debug user details before creation

	    Response res= UserEndPoints.createUser(userPayload);
	    res.then().log().body();

	    logger.debug("Response Status Code: " + res.getStatusCode());
	    logger.debug("Response Body: " + res.getBody().asString());

	    Assert.assertEquals(res.getStatusCode(), 200);
	} 


	@Test(priority=3)
	public void testUpdateUserByName()
	{
	    logger.info("*********** Updating User ***********");

	    // update data using payload
	    userPayload.setFirstname(faker.name().firstName());
	    userPayload.setLastname(faker.name().lastName());
	    userPayload.setEmail(faker.internet().safeEmailAddress());

	    logger.debug("Updated User Payload: " + userPayload.toString());

	    Response res= UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
	    res.then().log().body();

	    logger.debug("Response Status Code: " + res.getStatusCode());
	    logger.debug("Response Body: " + res.getBody().asString());

	    Assert.assertEquals(res.getStatusCode(), 200);

	    logger.info("*********** User is Updated ***********");

	    // checking data after update
	    Response resAfterUpdate= UserEndPoints.readUser(this.userPayload.getUsername());
	    resAfterUpdate.then().log().body();

	    logger.debug("Response after update Status Code: " + resAfterUpdate.getStatusCode());
	    logger.debug("Response after update Body: " + resAfterUpdate.getBody().asString());

	    Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
	}


	@Test(priority=4)
	public void testDeleteUserByName()
	{
	    logger.info("*********** Deleting User ***********");

	    Response res= UserEndPoints.deleteUser(this.userPayload.getUsername());        

	    logger.debug("Delete Response Status Code: " + res.getStatusCode());
	    logger.debug("Delete Response Body: " + res.getBody().asString());

	    Assert.assertEquals(res.getStatusCode(), 200);

	    logger.info("*********** User Deleted ***********");
	}

}
