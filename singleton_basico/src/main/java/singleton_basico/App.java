package singleton_basico;

import java.sql.SQLException;

import singleton_basico.dao.EmployeeDAO;
import singleton_basico.model.Employee;

public class App {
	// Esta simulando a un controller
    public static void main(String[] args) throws SQLException {
        EmployeeDAO dao = new EmployeeDAO();

        System.out.println("== LISTA INICIAL ==");
        dao.findAll().forEach(System.out::println);

        System.out.println("\n== CREAR ==");
        Employee nuevo = dao.create(new Employee("Jeronimo", "Garcia", "jero@email.com", 99000));
        System.out.println("Creado: " + nuevo);

        System.out.println("\n== LEER POR ID ==");
        System.out.println(dao.findById(nuevo.getId()));

        System.out.println("\n== MODIFICAR ==");
        nuevo.setSalary(105000);
        dao.update(nuevo);
        System.out.println("Actualizado: " + dao.findById(nuevo.getId()));

        System.out.println("\n== ELIMINAR ==");
        dao.delete(nuevo.getId());
        System.out.println("Borrado. Existe? " + (dao.findById(nuevo.getId()) != null));

        System.out.println("\n== LISTA FINAL ==");
        dao.findAll().forEach(System.out::println);
    }
}
