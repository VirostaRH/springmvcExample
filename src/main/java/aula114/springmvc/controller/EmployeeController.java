package aula114.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import aula114.springmvc.service.EmployeeService;
import aula114.springmvc.domain.Contact;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.ArrayList;



import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.SQLException;

import aula114.springmvc.domain.Contact;
@Controller
public class EmployeeController{

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/show/{clave}")
	public void showKey() {
	}

	@RequestMapping("/show/")
	public String show(Model model, @RequestParam("clave") String id){
		//se creará un objeto contact que será retornado por show tras la petición desde la request como parámetro "clave";
		/*System.out.println("MOSTRANDO ID - "+id);*/
		Contact aContact = employeeService.show(id);
		model.addAttribute("contact", aContact);
		return "show";
	}

	@RequestMapping("/employee")
	public String mostrarListado (Model model){
		//se llama una variable lista que va a ser generada por el employeeService
		try{
			List <Contact> list = employeeService.listIdEmployee();
			model.addAttribute("list", list);
		}
		catch(SQLException e)
		{
			System.out.println("Cagada en el sql.");
		}
		return "showList";
	}

	@RequestMapping("/edit/{clave}")
	public String editar (Model model, @RequestParam("clave") String id){
		//se llama una variable lista que va a ser generada por el employeeService
		employeeService.edit(id);
		return "redirect:/showList";
	}
	

	@RequestMapping("/delete/{clave}")
	public String delete (Model model, @RequestParam("clave") String id){
		//se llama una variable lista que va a ser generada por el employeeService
		employeeService.delete(id);
		return "redirect:/showList";
	}
	
}
