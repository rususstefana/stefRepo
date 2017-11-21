package org.app.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import static javax.persistence.FetchType.EAGER;

import java.util.List;

import static javax.persistence.CascadeType.ALL;
import javax.persistence.OneToMany;

@Entity
public class Studii {
	@Id
	 private Integer Id_Studii;
	 private String Calificari;
 
	 @OneToMany( mappedBy = "Studii", targetEntity = org.app.service.entities.Doctorat.class, cascade = ALL)
	 private List <Doctorat> Doctorat;
	 
	 @OneToMany(cascade = ALL, mappedBy = "Studii", targetEntity = org.app.service.entities.Master.class)
	 private List  <Master>  Master;
	 
	 @OneToMany(mappedBy = "Studii", cascade = ALL)
	 private List < Licenta> Licenta;
     
	 @OneToOne(cascade = ALL)
	 private Liceu Liceu;

	public Integer getId_Studii() {
		return Id_Studii;
	}

	public void setId_Studii(Integer id_Studii) {
		Id_Studii = id_Studii;
	}

	public String getCalificari() {
		return Calificari;
	}

	public void setCalificari(String calificari) {
		Calificari = calificari;
	}

	public List<Doctorat> getDoctorat() {
		return Doctorat;
	}

	public void setDoctorat(List<Doctorat> doctorat) {
		Doctorat = doctorat;
	}

	public List<Master> getMaster() {
		return Master;
	}

	public void setMaster(List<Master> master) {
		Master = master;
	}

	public List<Licenta> getLicenta() {
		return Licenta;
	}

	public void setLicenta(List<Licenta> licenta) {
		Licenta = licenta;
	}

	public Liceu getLiceu() {
		return Liceu;
	}

	public void setLiceu(Liceu liceu) {
		Liceu = liceu;
	}
	 
	 
}
