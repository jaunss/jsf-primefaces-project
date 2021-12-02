package com.joaogcm.jsf.primefaces.manager;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.joaogcm.jsf.primefaces.generic.GenericDAO;
import com.joaogcm.jsf.primefaces.model.UserModel;

@ManagedBean(name = "userManager")
@SessionScoped
public class UserManager {

	private UserModel userModel = new UserModel();
	private GenericDAO<UserModel> genericDAO = new GenericDAO<UserModel>();
	private List<UserModel> users = new ArrayList<UserModel>();

	public String saveUser() {
		genericDAO.insert(userModel);
		newUser();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Inform: ", "User successfully entered."));
		return "";
	}

	public String remove() {
		genericDAO.deleteById(userModel);
		newUser();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Inform: ", "User removed successfully."));
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