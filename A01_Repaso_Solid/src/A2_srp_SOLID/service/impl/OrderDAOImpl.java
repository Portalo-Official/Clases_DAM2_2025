package A2_srp_SOLID.service.impl;

import javax.sql.DataSource;

import A2_srp_SOLID.model.Order;
import A2_srp_SOLID.service.OrderDAO;


public class OrderDAOImpl implements OrderDAO{
	
	private final DataSource ds;
	
    public OrderDAOImpl(DataSource ds) { 
    	this.ds = ds; 
    }
    
    @Override
    public void save(Order order) {
        try (var conn = ds.getConnection();
             var st = conn.prepareStatement(
                "INSERT INTO orders(id,email,total) VALUES (?,?,?)")) {
            st.setString(1, order.getId());
            st.setString(2, order.getCustomerEmail());
            st.setDouble(3, order.getTotal());
            st.executeUpdate();
        } catch (Exception e) { throw new RuntimeException(e); }
    }
    
}
