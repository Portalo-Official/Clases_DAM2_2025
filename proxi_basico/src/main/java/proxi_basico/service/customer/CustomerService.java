package proxi_basico.service.customer;

import java.sql.SQLException;
import java.util.List;

import proxi_basico.model.Customer;

public interface CustomerService {
	
	List<Customer> findAll() throws SQLException;
	Customer findById(int id) throws SQLException;
	Customer create(Customer customer) throws SQLException;
	boolean update(Customer customer) throws SQLException;
	boolean delete(int id) throws SQLException;
}
