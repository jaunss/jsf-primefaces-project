package com.joaogcm.jsf.primefaces.manager;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.joaogcm.jsf.primefaces.generic.GenericDAO;
import com.joaogcm.jsf.primefaces.model.UserModel;

@ManagedBean(name = "userManager")
@ViewScoped
public class UserManager {

	private UserModel userModel = new UserModel();
	private GenericDAO<UserModel> genericDAO = new GenericDAO<UserModel>();
	private List<UserModel> users = new ArrayList<UserModel>();

	public String saveUser() {
		genericDAO.insert(userModel);
		newUser();
		return "";
	}

	public String remove() {
		genericDAO.deleteById(userModel);
		newUser();
		return "";
	}

	public String newUser() {
		userModel = new UserModel();
		return "";
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public List<UserModel> getUsers() {
		users = genericDAO.findAll(UserModel.class);
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
}