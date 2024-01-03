package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cab Invoice Generator program!");

        Scanner sc = new Scanner(System.in);
//        CabInvoiceGenerator generator = new CabInvoiceGenerator();
//        List<Ride> rides = new ArrayList<>();
//
//        System.out.println("Enter the number of rides:");
//        int numRides = sc.nextInt();
//
//        for(int i = 0; i < numRides; i++){
//            System.out.println("Enter distance for ride " + (i + 1) + " in kilometers:");
//            double distance = sc.nextDouble();
//
//            System.out.println("Enter time for ride " + (i + 1) + " in minutes:");
//            double time = sc.nextDouble();
//
//            rides.add(new Ride(distance, time, CabInvoiceGenerator.RideType.NORMAL));
//        }
//
//        double totalFare = generator.calculateTotalFareForMultipleRides(rides);
//        System.out.println("Total Fare for all rides: Rs. " + totalFare);
//
//        InvoiceSummary summary = generator.calculateInvoiceSummary(rides);
//        System.out.println(summary);

        RideRepository rideRepository = new RideRepository();
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        InvoiceService invoiceService = new InvoiceService(rideRepository, invoiceGenerator);

        // Adding some test rides to the repository for different users
        rideRepository.addRide("user1", new Ride(2.0, 5, CabInvoiceGenerator.RideType.NORMAL));
        rideRepository.addRide("user1", new Ride(3.0, 10, CabInvoiceGenerator.RideType.PREMIUM));
        rideRepository.addRide("user2", new Ride(5.0, 15, CabInvoiceGenerator.RideType.NORMAL));
        rideRepository.addRide("user2", new Ride(0.5, 3, CabInvoiceGenerator.RideType.PREMIUM));

        System.out.println("Enter User ID to generate invoice:");
        String userId = sc.next();

        // Generating and displaying the invoice for the requested user
        try {
            InvoiceSummary summary = invoiceService.getInvoiceForUser(userId);
            System.out.println("Invoice for user " + userId + ": " + summary);
        } catch (Exception e) {
            System.out.println("Error generating invoice: " + e.getMessage());
        }
    }
}
