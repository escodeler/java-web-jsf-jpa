package com.faces.motors.beans;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import com.faces.motors.entities.Car;
import com.faces.motors.utils.JPAUtil;

@ManagedBean
public class CarBean {
	
	private Car car = new Car();
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void save(Car car) {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(car);
		em.getTransaction().commit();
		
		em.close();
	}
}
