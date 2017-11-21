package org.app.service.entities;

import java.sql.Date; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
public class Interviu {
	@Id
	 private Integer Id_interviu;
	 private Date Data_aplicarii;
	 private Date Data_interviului;
	 @OneToOne
	private Test Test ;
	 @ManyToOne
	private Candidat Candidat;
	 
	public Integer getId_interviu() {
		return Id_interviu;
	}
	public void setId_interviu(Integer id_interviu) {
		Id_interviu = id_interviu;
	}
	public Date getData_aplicarii() {
		return Data_aplicarii;
	}
	public void setData_aplicarii(Date data_aplicarii) {
		Data_aplicarii = data_aplicarii;
	}
	public Date getData_interviului() {
		return Data_interviului;
	}
	public void setData_interviului(Date data_interviului) {
		Data_interviului = data_interviului;
	}
	public Test getTest() {
		return Test;
	}
	public void setTest(Test test) {
		Test = test;
	}
	public Candidat getCandidat() {
		return Candidat;
	}
	public void setCandidat(Candidat candidat) {
		Candidat = candidat;
	}
}
