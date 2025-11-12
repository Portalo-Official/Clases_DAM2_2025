package A_srp_SOLID.despues;

import A2_srp_SOLID.service.impl.NotificationServiceImpl;
import A2_srp_SOLID.service.impl.NotificationServiceSecurityImpl;
import A2_srp_SOLID.service.impl.OrderDAOImpl;
import A2_srp_SOLID.service.impl.OrderValidatorImpl;
import A2_srp_SOLID.service.impl.PricingServiceImpl;
import A2_srp_SOLID.service.impl.ReportServiceImpl;
import A_srp_SOLID.despues.dao.OrderDAO;
import A_srp_SOLID.despues.orquestador.OrderProcessor;
import A_srp_SOLID.despues.service.NotificationService;
import A_srp_SOLID.despues.service.PricingService;
import A_srp_SOLID.despues.service.ReportService;
import A_srp_SOLID.despues.validator.OrderValidator;

public class App {

	public static void main(String[] args) {
		OrderDAO orrderDAo = new OrderDAO(null);
		OrderValidator validador = new OrderValidator();
		ReportService reportService = new ReportService(null);
		PricingService prrecioServicio = new PricingService();
		
		NotificationService notificacionServicio = new NotificationService(null);
		
		NotificationServiceSecurityImpl notificacionServicioSecurity = new NotificationServiceSecurityImpl(null);
		
		OrderProcessor pedidos = new OrderProcessor(validador, prrecioServicio, orrderDAo, notificacionServicio, reportService);
		
		// descomentar para ver 
		//OrderProcessor pedidos = new OrderProcessor(validador, prrecioServicio, orrderDAo, notificacionServicioSecurity, reportService);
		
	}

}
