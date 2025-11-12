package A_srp_SOLID.despues.orquestador;

import A_srp_SOLID.despues.dao.OrderDAO;
import A_srp_SOLID.despues.service.NotificationService;
import A_srp_SOLID.despues.service.PricingService;
import A_srp_SOLID.despues.service.ReportService;
import A_srp_SOLID.despues.validator.OrderValidator;
import A_srp_SOLID.utiles.Order;

public class OrderProcessor {
	
    private OrderValidator validator;
    private PricingService pricing;
    private OrderDAO repo;
    private NotificationService notifier;
    private ReportService invoicer;

    public OrderProcessor(OrderValidator validator, PricingService pricing,
                          OrderDAO repo, NotificationService notifier,
                          ReportService invoicer) {
        this.validator = validator;
        this.pricing = pricing;
        this.repo = repo;
        this.notifier = notifier;
        this.invoicer = invoicer;
    }

    public void process(Order order) {
        validator.validate(order);
        pricing.price(order);
        repo.save(order);
        notifier.sendOrderConfirmation(order);
        invoicer.generateInvoice(order);
    }
}
