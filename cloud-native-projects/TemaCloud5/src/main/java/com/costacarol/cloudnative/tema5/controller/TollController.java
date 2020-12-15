package com.costacarol.cloudnative.tema5.controller;

import com.costacarol.cloudnative.tema5.service.TollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


@Component
@ApplicationPath("toll")
@Produces("application/json")
public class TollController extends Application {

    @Autowired
    TollService tollService;

    @Path("/pay/{value}/{vehicle}/{axle}")
    @GET
    public Response realizeNewPayment(@PathParam("value") Double value,
                                      @PathParam("vehicle") String vehicle,
                                      @PathParam("axle") Integer numberOfAxle){
   t
    }


    @Path("/list-prices")
    @GET
    public Response listTollPrices(){
        ResponseBuilder response = Response.ok(tollService.vehiclesPriceList());
        return response.build();
    }
}
