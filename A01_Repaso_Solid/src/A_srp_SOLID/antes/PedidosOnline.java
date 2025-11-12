package A_srp_SOLID.antes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import A_srp_SOLID.utiles.EmailClient;
import A_srp_SOLID.utiles.Order;
import A_srp_SOLID.utiles.OrderItem;
import A_srp_SOLID.utiles.PdfLib;

public class PedidosOnline {
	
    // Dependencias “metidas a capón”:
    private final Connection db;
    private final EmailClient email;
    private final PdfLib pdf;

    public PedidosOnline(Connection db, EmailClient email, PdfLib pdf) {
        this.db = db;
        this.email = email;
        this.pdf = pdf;
    }

    // Hace de todo: validar, calcular, persistir, notificar, generar PDF
    public void process(Order order) {
    	
        // 1) Validación
        if (order == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Pedido vacío");
        }
        if (order.getCustomerEmail() == null || !order.getCustomerEmail().contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }

        // 2) Precios y descuentos
        double subtotal = 0.0;
        for (OrderItem it : order.getItems()) {
            subtotal += it.getUnitPrice() * it.getCantidad();
        }
        double discount = subtotal > 100 ? subtotal * 0.05 : 0.0; // promo hardcodeada
        double taxes = (subtotal - discount) * 0.21;
        double total = subtotal - discount + taxes;
        order.setTotals(subtotal, discount, taxes, total);

        // 3) Persistencia “SQL embebido”
        try (PreparedStatement st = db.prepareStatement(
                "INSERT INTO orders(id, email, total) VALUES (?, ?, ?)")) {
            st.setString(1, order.getId());
            st.setString(2, order.getCustomerEmail());
            st.setDouble(3, total);
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Error guardando pedido", e);
        }

        // 4) Notificación por email
        String body = "Gracias por su compra. Total: " + total;
        email.send(order.getCustomerEmail(), "Pedido " + order.getId(), body);

        // 5) Generación de PDF (factura)
        byte[] pdfBytes = pdf.createInvoice(order);
        saveFile("invoices/" + order.getId() + ".pdf", pdfBytes);
    }

    private void saveFile(String path, byte[] bytes) {
        // I/O directo (más responsabilidades)
    }
	

}
