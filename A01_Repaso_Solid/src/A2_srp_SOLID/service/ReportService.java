package A2_srp_SOLID.service;

import A2_srp_SOLID.model.Order;

public interface ReportService {

    public byte[] generateInvoice(Order order);
}
