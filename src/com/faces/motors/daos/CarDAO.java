package com.faces.motors.daos;

import java.util.List;

import com.faces.motors.entities.Car;

public interface CarDAO {
	
	void save(Car car);
	List<Car> retrieve();

}
