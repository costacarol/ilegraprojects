package com.costacarol.cloudnative.tema5.controller;

import com.costacarol.cloudnative.tema5.app.AppConfig;
import com.costacarol.cloudnative.tema5.service.TollService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.Response;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TollControllerTest {

    @Autowired
    TollController tollController;

    @Autowired
    TollService tollService;

    @Test
    public void testRealizeNewPaymentBike() {
        Response response = tollController.realizeNewPayment(10.0, "bike", 1);
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("9.51", response.getEntity());
    }

    @Test
    public void testRealizeNewPaymentInsufficientCashBike() {
        Response response = tollController.realizeNewPayment(0.3, "bike", 1);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void testRealizeNewPaymentBus() {
        Response response = tollController.realizeNewPayment(10.0, "bus", 1);
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("8.41", response.getEntity());
    }

    @Test
    public void testRealizeNewPaymentInsufficientCashBus() {
        Response response = tollController.realizeNewPayment(1.3, "bus", 1);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void testRealizeNewPaymentBeetle() {
        Response response = tollController.realizeNewPayment(10.0, "beetle", 1);
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("7.89", response.getEntity());
    }

    @Test
    public void testRealizeNewPaymentInsufficientCashBeetle() {
        Response response = tollController.realizeNewPayment(2.0, "beetle", 1);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void testRealizeNewPaymentMotorcycle() {
        Response response = tollController.realizeNewPayment(10.0, "motorcycle", 1);
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("9.0", response.getEntity());
    }

    @Test
    public void testRealizeNewPaymentInsufficientCashMotorcycle() {
        Response response = tollController.realizeNewPayment(0.5, "motorcycle", 1);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void testRealizeNewPaymentNegativeCashTruckWithOneAxle() {
        Response response = tollController.realizeNewPayment(-4.0, "truck", 1);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void testRealizeNewPaymentInsufficientCashTruckWithOneAxle() {
        Response response = tollController.realizeNewPayment(2.0, "truck", 1);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void testRealizeNewPaymentTruckWithOneAxle() {
        Response response = tollController.realizeNewPayment(4.0, "truck", 1);
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("0.05", response.getEntity());
    }

    @Test
    public void testRealizeNewPaymentTruckWithTwoAxle() {
        Response response = tollController.realizeNewPayment(8.0, "truck", 2);
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("0.1", response.getEntity());
    }

    @Test
    public void testRealizeNewPaymentInsufficientCashTruckWithTwoAxle() {
        Response response = tollController.realizeNewPayment(4.0, "truck", 2);
        Assert.assertEquals(400, response.getStatus());
    }

    @Test
    public void testListTollPrices() {
        Response response = tollController.listTollPrices();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals( tollService.vehiclesPriceList(), response.getEntity());
    }
}