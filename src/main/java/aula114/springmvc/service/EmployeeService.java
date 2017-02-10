package aula114.springmvc.service;

import java.util.*;
import java.sql.SQLException;
import aula114.springmvc.domain.Contact;

public interface EmployeeService {

	public List <Contact> listIdEmployee() throws SQLException;
	public Contact show(String id);
	public int edit(Map datos);
	public int add(Map datos);
	public Map delete(String id);
}
