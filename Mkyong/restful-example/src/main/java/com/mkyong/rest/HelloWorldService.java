package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
@Path("/hello")
public class HelloWorldService {

    @Autowired
    private RestTemplate restTemplate;

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}

    public String getMessage() {
        String result;
        try {
            String httpResult = restTemplate.getForObject("http://google.com", String.class);
            result = "Message SUCCESS result: " + httpResult;
        } catch (HttpStatusCodeException e) {
            result = "Get FAILED with HttpStatusCode: " + e.getStatusCode() + "|" + e.getStatusText();
        } catch (RuntimeException e) {
            result = "Get FAILED\n" + e.getStackTrace();
        }
        return result;
    }
 
}