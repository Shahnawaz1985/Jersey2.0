package com.bac.rest.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bac.model.SimpleUser;
import com.bac.orm.service.UserService;
import com.bac.orm.service.impl.UserServiceImpl;

@Path("/orm-service")
public class OrmService {
	
	
	
	@GET
	@Produces({"application/json"})
	//@JacksonFeatures(serializationEnable =  { SerializationFeature.INDENT_OUTPUT })
	public Response retrieveUsersInformation() throws JSONException{
		    System.out.println("Inside retrieveUsersInformation");
		    UserService userService = new UserServiceImpl();
		    List<SimpleUser> users = userService.retrieveAllUsers();
		    //System.out.println("Users: "+users);
		    JSONObject jsonObject = new JSONObject();
		    JSONArray jsonArry = new JSONArray();
		    for(SimpleUser user:users) {
		    	jsonArry.put(user);
		    	jsonArry.put(user.getHomeAddress());
		    	jsonArry.put(user.getBillingAddress());
		    	jsonArry.put(user.getDefaultBillingDetails());
		    	jsonArry.put(user.getShippingAddress());
		    }
		    jsonObject.put("users", jsonArry);
		    String result = " " + jsonObject.toString();		    
		    return Response.status(200).entity(result).build();
		  }
	
	@Path("/single-user/{id}")
	@GET
	@Produces({"application/json"})
	//@JacksonFeatures(serializationEnable =  { SerializationFeature.INDENT_OUTPUT })
	public Response retrieveUserById(@PathParam("id") String id) throws JSONException{
			System.out.println("Inside retrieveUserById()");		    
		    UserService userService = new UserServiceImpl();
		    SimpleUser user = userService.getUserById(id);
		    //System.out.println("Users: "+users);
		    JSONObject jsonObject = new JSONObject();
		    jsonObject.put("user", user);
		    jsonObject.put("homeAddress", user.getHomeAddress());
		    jsonObject.put("billingAddress", user.getBillingAddress());
		    jsonObject.put("defaultBillingAddress", user.getDefaultBillingDetails());
		    jsonObject.put("shippingAddress", user.getShippingAddress());
		    String result = " " + jsonObject.toString();		    
		    return Response.status(200).entity(result).build();
		  }

}
