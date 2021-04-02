package com.vbt.apitinnova.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vbt.apitinnova.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	
	// JPQL do JPA
	// Busca somente veículos não vendidos
	@Query("SELECT obj "
			+ "FROM Car obj "
			+ "WHERE obj.sold = false "
			+ "ORDER BY obj.vehicle ASC "
			)
	List<Car> findByUnsold();
	
	// Busca somente veículos vendidos
	@Query("SELECT obj "
			+ "FROM Car obj "
			+ "WHERE obj.sold = true "
			+ "ORDER BY obj.vehicle ASC "
			)
	List<Car> findBySold();
	
	// Busca distribuições de veículos por década de fabricação
	@Query("SELECT obj "
			+ "FROM Car obj "
		    + "WHERE obj.year BETWEEN :year AND :year + 10 "
			+ "ORDER BY obj.vehicle ASC "
			)
	List<Car> findByDecade(Integer year);
	
	// Busca distribuições de veículos por fabricante
	@Query("SELECT obj "
			+ "FROM Car obj "
		    + "WHERE obj.brand = :brand "
			+ "ORDER BY obj.vehicle ASC "
			)
	List<Car> findByBrand(String brand);
	
}
