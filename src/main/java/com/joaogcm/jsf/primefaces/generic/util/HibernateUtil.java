package com.joaogcm.jsf.primefaces.generic.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	public static EntityManagerFactory emf = null;

	static {
		init();
	}

	private static void init() {
		try {
			if (emf == null) {
				emf = Persistence.createEntityManagerFactory("jsf-primefaces");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static Object getPrimaryKey(Object model) {
		return emf.getPersistenceUnitUtil().getIdentifier(model);
	}
}