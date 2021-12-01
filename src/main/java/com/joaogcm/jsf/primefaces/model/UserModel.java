package com.joaogcm.jsf.primefaces.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userModel")
public class UserModel implements Serializable {

	private static final long serialVersionUID = -1352265722518961016L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String nameUser;
	private String surnameUser;
	private String emailUser;
	private String ageUser;
	private String loginUser;
	private String passwordUser;

	public UserModel() {

	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getSurnameUser() {
		return surnameUser;
	}

	public void setSurnameUser(String surnameUser) {
		this.surnameUser = surnameUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getAgeUser() {
		return ageUser;
	}

	public void setAgeUser(String ageUser) {
		this.ageUser = ageUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	@Override
	public String toString() {
		return "UserModel [idUser=" + idUser + ", nameUser=" + nameUser + ", surnameUser=" + surnameUser
				+ ", emailUser=" + emailUser + ", ageUser=" + ageUser + ", loginUser=" + loginUser + ", passwordUser="
				+ passwordUser + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}
}