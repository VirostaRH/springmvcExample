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
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.io.IOException;
import aula114.springmvc.domain.Contact;
@Controller
public class EmployeeController{

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/show/")
	public String show(Model model, @RequestParam(value="clave", required=false) String id)
	{
		if (id != null)
		{
			Contact aContact = employeeService.show(id);
			model.addAttribute("contact", aContact);
			return "show";
		}
		else
		{
			return "showList";
		}
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

	@RequestMapping("/delete")
	public String delete (Model model, @RequestParam(value = "clave", required = false) String id)
	{
		//se llama una variable lista que va a ser generada por el employeeService
		
		if (id != null)
		{
			Map map = employeeService.delete(id);
			Contact c = new Contact();

			if ((String)map.get("name")!= null)
			{
				c.setName((String)map.get("name"));
				c.setAddress((String)map.get("address"));
				c.setEmail((String)map.get("email"));
				c.setTelephone((String)map.get("telephone"));

				model.addAttribute("filas", map.get("filasEliminadas"));
				model.addAttribute("contact", c);
				return "deleteOk";
			}
		}
		return mostrarListado(model);
	}

	@RequestMapping("/edit/")
	public String cargaEditar (Model model, @RequestParam(value="clave", required=false) String id){
		//se llama una variable lista que va a ser generada por el employeeService
		
		if(id != null)
		{
			Contact c = employeeService.show(id);
			c.setId(id);
			model.addAttribute("contact", c);
			return "editWindow";
		}
		else
		{
			return "showList";
		}
	}

	@RequestMapping("/enviarEdicion/")
	public String editar (Model model,
		@RequestParam(value="id") String id,
		@RequestParam(value="name", required=false) String name,
		@RequestParam(value="address", required=false) String address,
		@RequestParam(value="email", required=false) String email,
		@RequestParam(value="telephone", required=false) String telephone){
		//se llama una variable lista que va a ser generada por el employeeService
		
		Map valoresEntrada = new HashMap <String, String>();
		valoresEntrada.put("id", id);
		if (name != null){valoresEntrada.put("name", name);}
		if (address != null){valoresEntrada.put("address", address);}
		if (email != null){valoresEntrada.put("email", email);}
		if (telephone != null){valoresEntrada.put("telephone", telephone);}

		int c = employeeService.edit(valoresEntrada);
		model.addAttribute("res", c);
		return "editRes";
	}

	@RequestMapping("/add/")
	public String cargaEditar (Model model){
		return "add";
	}
	
	@RequestMapping("/addNew/")
	public String add (Model model,
		@RequestParam(value="name") String name,
		@RequestParam(value="address") String address,
		@RequestParam(value="email") String email,
		@RequestParam(value="telephone") String telephone){
		//se llama una variable lista que va a ser generada por el employeeService
		
		Map valoresEntrada = new HashMap <String, String>();
		valoresEntrada.put("name", name);
		valoresEntrada.put("address", address);
		valoresEntrada.put("email", email);
		valoresEntrada.put("telephone", telephone);

		int c = employeeService.add(valoresEntrada);
		model.addAttribute("res", c);
		return "insertRes";
	}
}
