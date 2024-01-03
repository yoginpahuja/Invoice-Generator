package CabInvoiceGenerator;

public class Ride {
    private final double distance; // in kilometers
    private final double time;     // in minutes
    private final CabInvoiceGenerator.RideType rideType;

    public Ride(double distance, double time, CabInvoiceGenerator.RideType rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public CabInvoiceGenerator.RideType getRideType() {
        return rideType;
    }
}
