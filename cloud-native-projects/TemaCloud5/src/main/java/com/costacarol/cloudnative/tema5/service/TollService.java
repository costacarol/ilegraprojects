package com.costacarol.cloudnative.tema5.service;

import com.costacarol.cloudnative.tema5.vehicles.Bike;
import com.costacarol.cloudnative.tema5.vehicles.Truck;
import com.costacarol.cloudnative.tema5.vehicles.Beetle;
import com.costacarol.cloudnative.tema5.vehicles.Bus;
import com.costacarol.cloudnative.tema5.vehicles.Motorcycle;
import com.costacarol.cloudnative.tema5.vehicles.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TollService {

    private Map<String, Double> vehiclesPrice;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Beetle beetle;

    @Autowired
    Truck truck;

    @Autowired
    Bike bike;

    @Autowired
    Bus bus;

    @Autowired
    Motorcycle motorcycle;


    public TollService(){
        this.vehiclesPrice = new HashMap<String, Double>();
    }

    @Required
    public double realizePayment(Double value, String vehicle, Integer numberOfAxle){
        double payment;
        if(vehicle.equalsIgnoreCase("truck") && numberOfAxle > 1){
            Truck truck = (Truck) applicationContext.getBean(vehicle);
            truck.setNumberOfAxle(numberOfAxle);
            payment = Math.round((value - truck.getPrice())*100)/100d;
        } else {
            Vehicles vehicles = (Vehicles) applicationContext.getBean(vehicle);
            payment = Math.round((value - vehicles.getPrice())*100)/100d;
        }
        return payment;
    }


    public Map<String, Double> vehiclesPriceList(){
        vehiclesPrice.put(beetle.toString(), beetle.getPrice());
        vehiclesPrice.put(bike.toString(), bike.getPrice());
        vehiclesPrice.put(bus.toString(), bus.getPrice());
        vehiclesPrice.put(motorcycle.toString(), motorcycle.getPrice());
        vehiclesPrice.put(truck.toString(), truck.getPrice());
        return vehiclesPrice;
    }
}
