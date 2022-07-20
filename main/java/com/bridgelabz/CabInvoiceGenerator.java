package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class CabInvoiceGenerator {
    private static final int MINIMUM_COST_PER_KILOMETER = 10;
    private static final double COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;


    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public InvoiceSummary getInvoice(int userId) {
        Map<Integer, Ride[]> map = new HashMap<>();
        Ride[] rides1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        Ride[] rides2 = {new Ride(5.0, 10),
                new Ride(1, 1)
        };
        map.put(1, rides1);
        map.put(2, rides2);

        for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
            if (userId == entry.getKey()) {
                System.out.println(entry.getKey());
                Ride[] ridesArray = entry.getValue();
                return calculateFare(ridesArray);
            }
        }
        return null;
    }
}
