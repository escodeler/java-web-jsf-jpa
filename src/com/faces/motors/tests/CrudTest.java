package com.faces.motors.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.faces.motors.entities.Car;
import com.faces.motors.utils.JPAUtil;

public class CrudTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {		
		
		EntityManager em = JPAUtil.getEntityManager();
		
		//Create
		Car car = new Car();
		car.setMake("Renault");
		car.setModel("Sandero");
		car.setYear(2014);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(car);
		et.commit();
		
		//Retrieve
		Query q = em.createQuery("select a from Car a", Car.class);
		List<Car> cars = q.getResultList();
		
		for(Car carro : cars) {
			System.out.println(carro.getModel());
		}
		
		/*Delete
		et.begin();
		Car carToRemove = em.getReference(Car.class, new Long(1));
		em.remove(carToRemove);
		et.commit();*/
		
		em.close();
		JPAUtil.getEntityManager().close();

	}

}
