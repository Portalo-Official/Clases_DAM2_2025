package A_srp_SOLID.despues.service;

import A_srp_SOLID.utiles.Order;
import A_srp_SOLID.utiles.PdfLib;

public class ReportService {

    private final PdfLib pdf;
    
    public ReportService(PdfLib pdf) {
        this.pdf = pdf; 
    }
    public byte[] generateInvoice(Order order) {
        byte[] bytes = pdf.createInvoice(order);
        return bytes;
    }
}
