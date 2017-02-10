package aula114.springmvc.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.*;
import java.util.Arrays;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import java.sql.SQLException;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aula114.springmvc.domain.Contact;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//@Autowired
	//private RedisTemplate redisTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private List<String> idList = new ArrayList<String>();
	
	@Override
	public List <Contact> listIdEmployee() throws SQLException  {
		
		List contactos = new ArrayList();
		/*consultar a mysql:
		*1: Crear consulta:*/
		String sql = "select * from contact;";

		//cargamos el resultado de esa consulta en un objeto, que será creado y mapeado con el beanProp...
		//Primera prueba para extraer lista: Fallida - List <Map <String, Object>> filas = jdbcTemplate.queryForList(sql, new Object[]{"*"}, new BeanPropertyRowMapper<Contact>(Contact.class));

 		List results = jdbcTemplate.queryForList(sql);
        for (Object result : results) {
        	Contact contacto = new Contact();
            HashMap map = (HashMap) result;
            for (Object key : map.keySet()) {}
        	contacto.setId(map.get("contact_id").toString());
        	contacto.setName(map.get("name").toString());
        	contacto.setAddress(map.get("address").toString());
        	contacto.setEmail(map.get("email").toString());
        	contacto.setTelephone(map.get("telephone").toString());
        	contactos.add(contacto);
        }

		return contactos;
	}

	@Override
	public Contact show(String id) {
		//como retornaremos un contacto, hay que crearlo:
		
		/*consultar a mysql:
		*1: Crear consulta:*/
		String sql = "select contact_id, name, email, address, telephone from contact where contact_id = ?";
		//cargamos el resultado de esa consulta en un objeto, que será creado y mapeado con el beanProp...
		Contact contacto = 	jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Contact>(Contact.class));
		return contacto;
	}

	@Override
	public int edit(Map datos)
	{
		//dato a enviar a sql
		String id = (String)datos.get("id");
		String sql = "update contact set ";
		String u_name = "";
		String u_address = "";
		String u_mail = "";
		String u_tlf = "";
		int filasEditadas = 0;

		if ((String)datos.get("name") != ""){u_name = "name='"+datos.get("name")+"',";}
		if ((String)datos.get("address")!= ""){u_address = "address='"+datos.get("address")+"',";}
		if ((String)datos.get("email")!= ""){u_mail = "email='"+datos.get("email")+"',";}
		if ((String)datos.get("telephone")!= ""){	u_tlf = "telephone='"+datos.get("telephone")+"',";}

		if (!sql.equals(sql+u_name+u_tlf+u_address+u_mail)) 
		{
			sql = sql+u_name+u_address+u_mail+u_tlf+"contact_id='"+id+"' where contact_id = ?";
			filasEditadas = jdbcTemplate.update(sql, id);
		}
		return filasEditadas;
	}

	@Override
	public Map delete(String id)
	{
		Contact c = show(id);
		String sql = "delete from contact where contact_id = ?";
		int filasEliminadas = jdbcTemplate.update(sql, id);
		Map retorno = new HashMap <Integer, Contact>();
		retorno.put("filasEliminadas", filasEliminadas);
		retorno.put("name",c.getName());
		retorno.put("address",c.getAddress());
		retorno.put("email",c.getEmail());
		retorno.put("telephone",c.getTelephone());
		return retorno;
	}

	public int add (Map datos)
	{
		//dato a enviar a sql
		String sql = "insert into contact set name='"+datos.get("name")+"', address = '"+datos.get("address")
		+"', email='"+datos.get("email")+"', telephone='"+datos.get("telephone")+"'";
		int filasEditadas = jdbcTemplate.update(sql);
		return filasEditadas;
	}

}

