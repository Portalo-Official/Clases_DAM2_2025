package A_srp_SOLID.despues.dao;

import javax.sql.DataSource;

import A_srp_SOLID.utiles.Order;


public class OrderDAO { // DAO -> Data Access OBject : Objeto de Acceso de Datos
	
	private final DataSource ds;
	
    public OrderDAO(DataSource ds) { 
    	this.ds = ds; 
    }
    
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
