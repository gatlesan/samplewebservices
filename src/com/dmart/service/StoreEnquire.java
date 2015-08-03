package com.dmart.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.dmart.domain.StoreDetails;

@Path("/estores")
public class StoreEnquire {
	
	@GET
	@Path("/{getEStore}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getEStroes(@QueryParam("longi") String longi,@QueryParam("lati") String lati) {
 
		System.out.println("inside getEStroes()");
		StoreDetails pd = new StoreDetails();
		pd.setLatitude(lati);
		pd.setLongitude(longi);
		pd.setStoreName("D-Mart");
		ObjectMapper objMap = new ObjectMapper();
		ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
		try {
			objMap.writeValue(byteArr, pd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		//return Response.status(200).entity(output).build();
		return Response.ok(byteArr.toString(), MediaType.APPLICATION_JSON).build();
 
	}

}
