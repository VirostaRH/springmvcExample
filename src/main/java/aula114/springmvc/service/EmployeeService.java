package aula114.springmvc.service;

import java.util.List;
import java.sql.SQLException;
import aula114.springmvc.domain.Contact;

public interface EmployeeService {

	public List <Contact> listIdEmployee() throws SQLException;
	public Contact show(String id);
	public void edit(String id);
	public void delete(String id);
}
