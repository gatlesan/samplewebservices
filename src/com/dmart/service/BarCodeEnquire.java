package com.dmart.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.dmart.domain.ProductDetails;

@Path("/barcode")
public class BarCodeEnquire {
	
	@GET
	@Path("/{getPrice}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getPrice(@QueryParam("barcode") String barcode) {
 
		System.out.println("inside getPrice()");
		ProductDetails pd = getProductDetails(barcode);
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
	
	private ProductDetails getProductDetails(String barCode){
		
		ProductDetails pd = new ProductDetails();
		if(barCode.equals("111110000011101")){
		pd.setProductName("Royal Honey 500ml");
		pd.setProductPrice(300.00);		
		}
		else
			if(barCode.equals("111110000011102")){
				pd.setProductName("Kisan soup 500ml");
				pd.setProductPrice(400.00);		
				}
			else
				if(barCode.equals("111110000011103")){
					pd.setProductName("Dove Kit");
					pd.setProductPrice(500.00);		
					}
				else
					if(barCode.equals("111110000011104")){
						pd.setProductName("Real mix juice");
						pd.setProductPrice(300.00);		
						}
					else
						if(barCode.equals("111110000011105")){
							pd.setProductName("Dry fruits raw");
							pd.setProductPrice(400.00);		
							}
		return pd;
		
	}

}
