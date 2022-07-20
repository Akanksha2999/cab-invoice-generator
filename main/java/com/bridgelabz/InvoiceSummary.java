package com.bridgelabz;

public class InvoiceSummary {
    private final int numOfRides;
    private final double totalFare;
    private double averageFare;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public InvoiceSummary getInvoiceSummary() {
        this.averageFare = this.totalFare / this.numOfRides;
        return this;
    }
}
