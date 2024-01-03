package CabInvoiceGenerator;

public class InvoiceService {
    private final RideRepository rideRepository;
    private final CabInvoiceGenerator invoiceGenerator;

    public InvoiceService(RideRepository rideRepository, CabInvoiceGenerator invoiceGenerator) {
        this.rideRepository = rideRepository;
        this.invoiceGenerator = invoiceGenerator;
    }

    public InvoiceSummary getInvoiceForUser(String userId) {
        return invoiceGenerator.calculateInvoiceSummary(rideRepository.getRides(userId));
    }
}
