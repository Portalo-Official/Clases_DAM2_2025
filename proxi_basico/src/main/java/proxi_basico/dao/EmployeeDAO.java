package proxi_basico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proxi_basico.connection.ConexionBaseDatos;
import proxi_basico.model.Employee;

public class EmployeeDAO {

	Connection conexion;
	
	public EmployeeDAO()  {
		super();
		try {
			this.conexion = ConexionBaseDatos.getInstance().getConnection();
		} catch (SQLException e) {
			System.err.println("Error al conectar la base de datos");
		}
	}

	public Employee create(Employee e){
        String sql = "INSERT INTO employees(first_name,last_name,email,salary) VALUES(?,?,?,?)";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, e.getFirstName());
            ps.setString(2, e.getLastName());
            ps.setString(3, e.getEmail());
            ps.setDouble(4, e.getSalary());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) e.setId(rs.getInt(1));
            }
            return e;
        } catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
    }

    public Employee findById(int id){
        String sql = "SELECT id,first_name,last_name,email,salary FROM employees WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                return map(rs);
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }

    public List<Employee> findAll(){
        String sql = "SELECT id,first_name,last_name,email,salary FROM employees ORDER BY id";
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Employee> list = new ArrayList<>();
            while (rs.next()) list.add(map(rs));
            return list;
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }

    public boolean update(Employee e) {
        String sql = "UPDATE employees SET first_name=?, last_name=?, email=?, salary=? WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, e.getFirstName());
            ps.setString(2, e.getLastName());
            ps.setString(3, e.getEmail());
            ps.setDouble(4, e.getSalary());
            ps.setInt(5, e.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
    }

    public boolean delete(int id){
        String sql = "DELETE FROM employees WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }

    private Employee map(ResultSet rs) throws SQLException {
        return new Employee(
            rs.getInt("id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getDouble("salary")
        );
    }
}
