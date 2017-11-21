package org.app.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Experienta {
	@Id
	 private Integer Id_Experienta;
	 private String Locuri_de_munca;
	 private String Practica;
	 private String Training;
	 private String Voluntariat;
	 
	 
	public Integer getId_Experienta() {
		return Id_Experienta;
	}
	public void setId_Experienta(Integer id_Experienta) {
		Id_Experienta = id_Experienta;
	}
	public String getLocuri_de_munca() {
		return Locuri_de_munca;
	}
	public void setLocuri_de_munca(String locuri_de_munca) {
		Locuri_de_munca = locuri_de_munca;
	}
	public String getPractica() {
		return Practica;
	}
	public void setPractica(String practica) {
		Practica = practica;
	}
	public String getTraining() {
		return Training;
	}
	public void setTraining(String training) {
		Training = training;
	}
	public String getVoluntariat() {
		return Voluntariat;
	}
	public void setVoluntariat(String voluntariat) {
		Voluntariat = voluntariat;
	}
	 
}
