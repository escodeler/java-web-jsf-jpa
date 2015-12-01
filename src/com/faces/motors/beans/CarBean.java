package com.faces.motors.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	private List<Car> cars;

	@SuppressWarnings("unchecked")
	public List<Car> getCars() {
		
		if(this.cars == null) {

			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("select c from Car c", Car.class);
			
			this.cars = q.getResultList();
			
			em.close();
		}
		return cars;
	}
	
	public void remove(Car car) {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		car = em.merge(car);
		em.remove(car);
		em.getTransaction().commit();
		
		em.close();
	}
}
