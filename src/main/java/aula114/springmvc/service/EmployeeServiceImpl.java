package aula114.springmvc.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.ArrayList;
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
		Contact contacto = new Contact();
		/*consultar a mysql:
		*1: Crear consulta:*/
		String sql = "select name, email, address, telephone from contact where contact_id = ?";
		//cargamos el resultado de esa consulta en un objeto, que será creado y mapeado con el beanProp...
		contacto = 	jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Contact>(Contact.class));
		return contacto;
	}

	@Override
	public void edit(String id)
	{
		//código nulo por ahora.
	}

	@Override
	public void delete(String id)
	{
		String sql = "delete from contact where contact_id = ?";
		int filasEliminadas = jdbcTemplate.update(sql, new Object[]{id}, new BeanPropertyRowMapper<Contact>(Contact.class));
	}

}

