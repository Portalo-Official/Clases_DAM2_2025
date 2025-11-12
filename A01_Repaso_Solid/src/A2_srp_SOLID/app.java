package A2_srp_SOLID;

import java.io.Serializable;

import A2_srp_SOLID.controller.OrderProcessor;
import A2_srp_SOLID.service.NotificationService;
import A2_srp_SOLID.service.OrderDAO;
import A2_srp_SOLID.service.OrderValidator;
import A2_srp_SOLID.service.PricingService;
import A2_srp_SOLID.service.ReportService;
import A2_srp_SOLID.service.impl.NotificationServiceImpl;
import A2_srp_SOLID.service.impl.NotificationServiceSecurityImpl;
import A2_srp_SOLID.service.impl.OrderDAOImpl;
import A2_srp_SOLID.service.impl.OrderValidatorImpl;
import A2_srp_SOLID.service.impl.PricingServiceImpl;
import A2_srp_SOLID.service.impl.ReportServiceImpl;
import A2_srp_SOLID.utiles.EmailClient;

public class app {
	
	
	public static void main(String[] args) {
		
		OrderDAO orrderDAo = new OrderDAOImpl(null);
		
		OrderValidator validador = new OrderValidatorImpl();
		
		ReportService reportService = new ReportServiceImpl(null);
		
		PricingService prrecioServicio = new PricingServiceImpl();
		
		EmailClient email = new EmailClient();
		
		// Aqui el premio
		NotificationService notificacionServicio = new NotificationServiceImpl(email);
		
		NotificationService notificacionServicioSecurity = new NotificationServiceSecurityImpl(email);

		OrderProcessor pedidos = new OrderProcessor(validador, prrecioServicio, orrderDAo, notificacionServicio, reportService);	
		
		
		
		NotificationServiceSecurityImpl n2 = new NotificationServiceSecurityImpl(null);
		
		notificacionServicio.buscarNotificaciones(null);
		
		notificacionServicioSecurity.buscarNotificaciones(null);
		
		//n2.metodoDeinterfazPropia(null);
	
	}
}
