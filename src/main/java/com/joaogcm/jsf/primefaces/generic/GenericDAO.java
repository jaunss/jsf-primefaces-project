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
		try {
			Object idUser = HibernateUtil.getPrimaryKey(model);

			T t = (T) em.find(model.getClass(), idUser);

			return t;
		} catch (RuntimeException e) {
			throw new RuntimeException("Error when trying to search for a model by id in the database.");
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> model) {
		try {
			et = em.getTransaction();
			et.begin();
			List<T> all = em.createQuery("FROM " + model.getName()).getResultList();
			et.commit();

			return all;
		} catch (RuntimeException e) {
			throw new RuntimeException("Error when trying to search for all models in the database.");
		}
	}

	public void insert(T model) {
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(model);
			et.commit();
		} catch (RuntimeException e) {
			throw new RuntimeException("Error when trying to insert a model into the database.");
		}
	}

	public T update(T model) {
		try {
			et = em.getTransaction();
			et.begin();
			T modelSave = em.merge(model);
			et.commit();

			return modelSave;
		} catch (RuntimeException e) {
			throw new RuntimeException("Error when trying to update a model in the database.");
		}
	}

	public void deleteById(T model) {
		try {
			et = em.getTransaction();
			Object idUser = HibernateUtil.getPrimaryKey(model);

			et.begin();
			em.createNativeQuery(
					"DELETE FROM " + model.getClass().getSimpleName().toLowerCase() + " WHERE idUser =" + idUser)
					.executeUpdate();
			et.commit();
		} catch (RuntimeException e) {
			throw new RuntimeException("Error when trying to remove a model from the database.");
		}
	}
}