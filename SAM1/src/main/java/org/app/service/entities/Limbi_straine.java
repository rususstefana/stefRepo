package org.app.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Limbi_straine {
	@Id
	 private Integer Id_Limbi_straine;
	 private String Competente_1;
	 private String Competente_2;
	 private String Competente_3;
	 private String Limba_1;
	 private String Limba_2;
	 private String Limba_3;
	 
	public Integer getId_Limbi_straine() {
		return Id_Limbi_straine;
	}
	public void setId_Limbi_straine(Integer id_Limbi_straine) {
		Id_Limbi_straine = id_Limbi_straine;
	}
	public String getCompetente_1() {
		return Competente_1;
	}
	public void setCompetente_1(String competente_1) {
		Competente_1 = competente_1;
	}
	public String getCompetente_2() {
		return Competente_2;
	}
	public void setCompetente_2(String competente_2) {
		Competente_2 = competente_2;
	}
	public String getCompetente_3() {
		return Competente_3;
	}
	public void setCompetente_3(String competente_3) {
		Competente_3 = competente_3;
	}
	public String getLimba_1() {
		return Limba_1;
	}
	public void setLimba_1(String limba_1) {
		Limba_1 = limba_1;
	}
	public String getLimba_2() {
		return Limba_2;
	}
	public void setLimba_2(String limba_2) {
		Limba_2 = limba_2;
	}
	public String getLimba_3() {
		return Limba_3;
	}
	public void setLimba_3(String limba_3) {
		Limba_3 = limba_3;
	}


}
