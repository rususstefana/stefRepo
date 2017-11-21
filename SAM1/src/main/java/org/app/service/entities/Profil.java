package org.app.service.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
public class Profil {
	@Id
	 private Integer Id_Profil;
	 private Date Data_nasterii;
	 private String Locul_nasterii;
	 private String Adresa;
	 private String Abilitati;
	 private String Nationalitate;
	 private String Stare_civila;
	 @OneToOne
	 private Studii Studii;
	 @OneToOne
	private Experienta Experienta;
	 @OneToOne
	private Limbi_straine Limbi_straine;
	 private String Cunostinte;
	 
	public Integer getId_Profil() {
		return Id_Profil;
	}
	public void setId_Profil(Integer id_Profil) {
		Id_Profil = id_Profil;
	}
	public Date getData_nasterii() {
		return Data_nasterii;
	}
	public void setData_nasterii(Date data_nasterii) {
		Data_nasterii = data_nasterii;
	}
	public String getLocul_nasterii() {
		return Locul_nasterii;
	}
	public void setLocul_nasterii(String locul_nasterii) {
		Locul_nasterii = locul_nasterii;
	}
	public String getAdresa() {
		return Adresa;
	}
	public void setAdresa(String adresa) {
		Adresa = adresa;
	}
	public String getAbilitati() {
		return Abilitati;
	}
	public void setAbilitati(String abilitati) {
		Abilitati = abilitati;
	}
	public String getNationalitate() {
		return Nationalitate;
	}
	public void setNationalitate(String nationalitate) {
		Nationalitate = nationalitate;
	}
	public String getStare_civila() {
		return Stare_civila;
	}
	public void setStare_civila(String stare_civila) {
		Stare_civila = stare_civila;
	}
	public Studii getStudii() {
		return Studii;
	}
	public void setStudii(Studii studii) {
		Studii = studii;
	}
	public Experienta getExperienta() {
		return Experienta;
	}
	public void setExperienta(Experienta experienta) {
		Experienta = experienta;
	}
	public Limbi_straine getLimbi_straine() {
		return Limbi_straine;
	}
	public void setLimbi_straine(Limbi_straine limbi_straine) {
		Limbi_straine = limbi_straine;
	}
	public String getCunostinte() {
		return Cunostinte;
	}
	public void setCunostinte(String cunostinte) {
		Cunostinte = cunostinte;
	}
}
