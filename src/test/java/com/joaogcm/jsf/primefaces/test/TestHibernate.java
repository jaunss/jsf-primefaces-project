package com.joaogcm.jsf.primefaces.test;

import java.util.List;

import org.junit.Test;

import com.joaogcm.jsf.primefaces.generic.GenericDAO;
import com.joaogcm.jsf.primefaces.model.UserModel;

public class TestHibernate {

	@SuppressWarnings("rawtypes")
	GenericDAO genericDAO = new GenericDAO();
	UserModel user = new UserModel();

	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll() {
		List<UserModel> all = genericDAO.findAll(UserModel.class);

		for (UserModel user : all) {
			System.out.println(user);
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindById() {
		user.setIdUser(1L);
		user = (UserModel) genericDAO.findById(user);

		System.out.println(user);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testInsert() {

		user.setNameUser("Flavia");
		user.setSurnameUser("Maciel");
		user.setEmailUser("flasm_jb@hotmail.com");
		user.setAgeUser("30");
		user.setLoginUser("flascalon");
		user.setPasswordUser("fla1991");

		genericDAO.insert(user);
		System.out.println(user);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testUpdate() {
		user.setIdUser(1L);
		user = (UserModel) genericDAO.findById(user);

		user.setEmailUser("Joaozim");
		user.setEmailUser("joaogabriel36@hotmail.com");

		user = (UserModel) genericDAO.update(user);
		System.out.println(user);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDeleteById() {
		user.setIdUser(1L);
		user = (UserModel) genericDAO.findById(user);

		genericDAO.deleteById(user);
	}
}