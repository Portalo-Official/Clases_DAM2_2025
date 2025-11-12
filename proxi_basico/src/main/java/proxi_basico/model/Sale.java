package proxi_basico.model;

public class Sale {
	private Integer id;
	private Integer customerId;
	private Integer employeeId;
	private double total;

	public Sale() {
	}

	public Sale(Integer id, Integer c, Integer e, double t) {
		this.id = id;
		this.customerId = c;
		this.employeeId = e;
		this.total = t;
	}

	public Sale(Integer c, Integer e, double t) {
		this(null, c, e, t);
	} // getters/setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer id) {
		this.customerId = id;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer id) {
		this.employeeId = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double t) {
		this.total = t;
	}

	@Override
	public String toString() {
		return "Sale{" + "id=" + id + ", c=" + customerId + ", e=" + employeeId + ", total=" + total + '}';
	}
}