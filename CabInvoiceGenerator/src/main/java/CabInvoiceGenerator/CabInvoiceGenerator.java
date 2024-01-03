package CabInvoiceGenerator;

import java.util.List;

public class CabInvoiceGenerator {
    // Enum for Ride Types
    public enum RideType {
        NORMAL(10.0, 1.0, 5.0),
        PREMIUM(15.0, 2.0, 20.0);

        private final double costPerKilometer;
        private final double costPerMinute;
        private final double minimumFare;

        RideType(double costPerKilometer, double costPerMinute, double minimumFare) {
            this.costPerKilometer = costPerKilometer;
            this.costPerMinute = costPerMinute;
            this.minimumFare = minimumFare;
        }

        public double getCostPerKilometer() {
            return costPerKilometer;
        }

        public double getCostPerMinute() {
            return costPerMinute;
        }

        public double getMinimumFare() {
            return minimumFare;
        }
    }

    public double calculateFare(double distanceInKilometers, double timeInMinutes, RideType rideType) {
        double totalFare = (distanceInKilometers * rideType.getCostPerKilometer()) + (timeInMinutes * rideType.getCostPerMinute());
        return Math.max(totalFare, rideType.getMinimumFare());
    }

    public double calculateTotalFareForMultipleRides(List<Ride> rides) {
        return rides.stream()
                .mapToDouble(ride -> calculateFare(ride.getDistance(), ride.getTime() , ride.getRideType()))
                .sum();
    }

    public InvoiceSummary calculateInvoiceSummary(List<Ride> rides) {
        double totalFare = rides.stream()
                .mapToDouble(ride -> calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType()))
                .sum();
        return new InvoiceSummary(rides.size(), totalFare);
    }
}
