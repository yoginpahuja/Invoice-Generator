package CabInvoiceGenerator;

public class InvoiceSummary {
    private final int numberOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = numberOfRides > 0 ? totalFare / numberOfRides : 0;
    }

    // Getters for the fields
    public int getNumberOfRides() {
        return numberOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }

    @Override
    public String toString() {
        return "InvoiceSummary: " +
                "numberOfRides=" + numberOfRides +
                ", totalFare=" + totalFare +
                ", averageFare=" + averageFare;
    }
}
