package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceServiceTest {
    CabInvoiceGenerator cabInvoiceGenerator = null;

    @Before
    public void setUp() throws Exception {
        cabInvoiceGenerator = new CabInvoiceGenerator();

    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)

        };
        InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);

    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.getInvoice(1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnPremiumFare() {
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceGenerator.calculatePremiumFare(distance, time);
        Assert.assertEquals(50, fare, 0.0);
    }
}
