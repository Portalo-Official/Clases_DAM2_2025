package proxi_basico.model;

public class Customer {
	private Integer id;
	private String name;
	private String email;

	public Customer() {
	}

	public Customer(Integer id, String n, String e) {
		this.id = id;
		this.name = n;
		this.email = e;
	}

	public Customer(String n, String e) {
		this(null, n, e);
	} 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", " + name + ", " + email + '}';
	}
}
