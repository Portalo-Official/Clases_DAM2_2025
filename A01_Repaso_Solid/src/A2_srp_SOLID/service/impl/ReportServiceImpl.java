package A2_srp_SOLID.service.impl;

import A2_srp_SOLID.model.Order;
import A2_srp_SOLID.service.ReportService;
import A2_srp_SOLID.utiles.PdfLib;

public class ReportServiceImpl implements ReportService {

    private final PdfLib pdf;
    
    public ReportServiceImpl(PdfLib pdf) {
        this.pdf = pdf; 
    }
    public byte[] generateInvoice(Order order) {
        byte[] bytes = pdf.createInvoice(order);
        return bytes;
    }
}
