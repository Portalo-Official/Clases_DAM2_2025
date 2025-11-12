package proxi_basico.service.customer.impl;

import java.sql.SQLException;
import java.util.List;

import proxi_basico.dao.CustomerDAO;
import proxi_basico.model.Customer;
import proxi_basico.service.customer.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	CustomerDAO customerDAO;
	
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	@Override
	public List<Customer> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer create(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
