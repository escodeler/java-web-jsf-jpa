package com.faces.motors.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.faces.motors.entities.Car;
import com.faces.motors.utils.JPAUtil;

public class CarJPA {

	public static void main(String[] args) {		
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Car car = new Car();
		car.setMake("Fiat");
		car.setModel("Uno");
		car.setYear(2015);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(car);
		et.commit();
		em.close();
		JPAUtil.getEntityManager().close();

	}

}
