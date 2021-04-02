package com.vbt.apitinnova.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vbt.apitinnova.entities.Car;
import com.vbt.apitinnova.repositories.CarRepository;
import com.vbt.apitinnova.services.CarService;

@RestController // Controlador Rest
@RequestMapping(value = "/cars") // Nome do recurso relacionado a entidade User
public class CarResource {

	@Autowired // Injeção de dependência
	private CarService service;
	
	@Autowired
	private CarRepository repository;
	
	// Busca por todos os registros
	@GetMapping
	public ResponseEntity<List<Car>> findAll() {
		List<Car> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// Busca registros por Id
	@GetMapping(value = "/{id}") // Pesquisa por Id
	public ResponseEntity<Car> findById(@PathVariable Long id) {
		Car obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Busca somente veículos não vendidos
	@GetMapping(value = "/unsold")
	public ResponseEntity<List<Car>> findAllUnsold() {
		List<Car> obj = service.findAllUnsold();
		return ResponseEntity.ok().body(obj);
	}
	
	// Busca somente veículos vendidos
	@GetMapping(value = "/sold")
	public ResponseEntity<List<Car>> findAllSold() {
		List<Car> obj = service.findAllSold();
		return ResponseEntity.ok().body(obj);
	}
	
	// Busca distribuições de veículos por década de fabricação
	@GetMapping(value = "/decade/{id}")
	public ResponseEntity<List<Car>> findByDecade(@PathVariable Integer id) {
		List<Car> obj = service.finByDecade(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Busca distribuições de veículos por fabricante
	@GetMapping(value = "/brand/{id}")
	public ResponseEntity<List<Car>> findByBrand(@PathVariable String id) {
		List<Car> obj = service.findByBrand(id);
		return ResponseEntity.ok().body(obj);
	}

	// Insere um novo registro
	@PostMapping
	public ResponseEntity<Car> insert(@RequestBody Car obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	// Deleta por Id
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		service.deleteById(id);
		return ResponseEntity.noContent().build(); // Retorna o código 204
	}

	// Atualiza por Id
	@PutMapping(value = "/{id}")
	public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody Car obj) {		
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
