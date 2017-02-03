package aula114.springmvc.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aula114.springmvc.domain.Contact;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private List<String> idList = new ArrayList<String>();
	
	@Override
	public List<String> listIdEmployee() {
		
		String KEY = "Contact"; 
	    Set<Object> list = redisTemplate.opsForHash().keys(KEY);
	    List<String> idList1 = new ArrayList(list);
		idList = idList1;
		return idList;
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
		System.out.println("OBJETO CONTACT" + contacto);
	    return contacto;
	}
}
