package A2_srp_SOLID.controller;

import A2_srp_SOLID.model.Order;
import A2_srp_SOLID.service.NotificationService;
import A2_srp_SOLID.service.OrderDAO;
import A2_srp_SOLID.service.OrderValidator;
import A2_srp_SOLID.service.PricingService;
import A2_srp_SOLID.service.ReportService;


public class OrderProcessor {
	
    private final OrderValidator validator;
    private final PricingService pricing;
    private final OrderDAO repo;
    private final NotificationService notifier;
    private final ReportService invoicer;

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
