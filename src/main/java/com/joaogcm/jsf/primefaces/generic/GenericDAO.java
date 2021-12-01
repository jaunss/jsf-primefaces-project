package com.joaogcm.jsf.primefaces.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.joaogcm.jsf.primefaces.generic.util.HibernateUtil;

public class GenericDAO<T> {
	private EntityManager em = HibernateUtil.getEntityManager();
	EntityTransaction et = null;

	@SuppressWarnings("unchecked")
	public T findById(T model) {
		Object idUser = HibernateUtil.getPrimaryKey(model);

		T t = (T) em.find(model.getClass(), idUser);

		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> model) {
		et = em.getTransaction();
		et.begin();
		List<T> all = em.createQuery("FROM " + model.getName()).getResultList();
		et.commit();

		return all;
	}

	public void insert(T model) {
		et = em.getTransaction();
		et.begin();
		em.persist(model);
		et.commit();
	}

	public T update(T model) {
		et = em.getTransaction();
		et.begin();
		T modelSave = em.merge(model);
		et.commit();

		return modelSave;
	}

	public void deleteById(T model) {
		et = em.getTransaction();
		Object idUser = HibernateUtil.getPrimaryKey(model);

		et.begin();
		em.createNativeQuery(
				"DELETE FROM " + model.getClass().getSimpleName().toLowerCase() + " WHERE idUser =" + idUser)
				.executeUpdate();
		et.commit();
	}
}