package com.vbt.apitinnova.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vbt.apitinnova.entities.enums.CarStatus;

@Entity
@Table(name = "tb_cars") // Product gerenciado pelo JPA/ORM
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // Defini este objeto como Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define a chave primária como auto-incrementável
	private Long id;

	@NotBlank
	private String vehicle;
	
	@NotBlank
	private String brand;
	
	private Integer year;
	
	@Size(max = 250)
	private String description;
	
	private Boolean sold;
	
	// Formata o Json para o padrão ISO 8601
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") 
	private Instant created;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant update;

	public Car() {
	}

	public Car(Long id, String vehicle, String brand, Integer year, String description, CarStatus sold, Instant created,
			Instant update) {
		this.id = id;
		this.vehicle = vehicle;
		this.brand = brand;
		this.year = year;
		this.description = description;
		setSold(sold);
		this.created = created;
		this.update = update;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CarStatus getSold() {
		return CarStatus.valueOf(sold);
	}

	public void setSold(CarStatus sold) {
		if (sold != null) {
			this.sold = sold.getStatus();
		}
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public Instant getUpdate() {
		return update;
	}

	public void setUpdate(Instant update) {
		this.update = update;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
