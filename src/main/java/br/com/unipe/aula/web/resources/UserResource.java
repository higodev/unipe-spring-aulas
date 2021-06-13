package br.com.unipe.aula.web.resources;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipe.aula.dto.ResponseDto;
import br.com.unipe.aula.model.User;
import br.com.unipe.aula.service.UserService;


//@Api(tags = "Users")
@RestController
@RequestMapping("/users")
public class UserResource {

	private final static Logger LOG = Logger.getLogger(UserResource.class.getName());

	@Autowired
	private UserService service;

	@GetMapping
	public List<User> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id) {
		return service.findOne(id);
	}

	@PostMapping
	public ResponseDto save(@RequestBody User user) {

		ResponseDto response = new ResponseDto();
		
		try {
			service.create(user);
			response.setMessage("Registro salvo com sucesso!");
		} catch (Exception e) {
			LOG.severe(e.getMessage());
			response.setMessage("Registro não pode ser salvo!");
		}
		
		return response;
		
	}
	
	@PutMapping("/{id}")
	public ResponseDto update(@PathVariable("id") Long id, @RequestBody User user) {

		ResponseDto response = new ResponseDto();
		
		try {
			if(id.equals(user.getId())) {				
				service.update(user);
				response.setMessage("Registro atualizado com sucesso!");
			}
		} catch (Exception e) {
			LOG.severe(e.getMessage());
			response.setMessage("Registro não pode ser salvo!");
		}
		
		return response;

	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
	
}
