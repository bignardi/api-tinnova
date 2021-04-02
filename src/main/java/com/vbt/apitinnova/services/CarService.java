package com.vbt.apitinnova.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbt.apitinnova.entities.Car;
import com.vbt.apitinnova.repositories.CarRepository;
import com.vbt.apitinnova.services.exceptions.ResourceNotFoundException;

@Service // Registro da classe no mecânismo de injeção de dependência
public class CarService {

	@Autowired // Injeção de dependência
	private CarRepository repository;

	public List<Car> findAll() {
		return repository.findAll();
	}

	public Car findById(Long id) {
		Optional<Car> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	// Garante a transação com o Banco de Dados
	@Transactional(readOnly = true)
	public List<Car> findAllUnsold() {
		List<Car> obj = repository.findByUnsold();
		return obj;
	}
	
	@Transactional(readOnly = true)
	public List<Car> findAllSold() {
		List<Car> obj = repository.findBySold();
		return obj;
	}
	
	@Transactional(readOnly = true)
	public List<Car> finByDecade(Integer year) {
		List<Car> obj = repository.findByDecade(year);
		return obj;
	}
	
	@Transactional(readOnly = true)
	public List<Car> findByBrand(String brand) {
		List<Car> obj = repository.findByBrand(brand);
		return obj;
	}
	
	public Car insert(Car obj) {
		return repository.save(obj);
	}

	public void deleteById(Long id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Car update(Long id, Car obj) {
		try {
			Car entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Car entity, Car obj) {
		entity.setVehicle(obj.getVehicle());
		entity.setBrand(obj.getBrand());
		entity.setYear(obj.getYear());
		entity.setDescription(obj.getDescription());
		entity.setUpdate(obj.getUpdate());
	}
}
