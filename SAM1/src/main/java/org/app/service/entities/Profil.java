package org.app.service.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profil {
	@Id
	Integer Id_Candidat;
	Date Data_nasterii;
	String Locul_nasterii;
	String Adresa;
	String Nationalitate;
	String Stare_civila;
	String Studii;
	String Experienta;
	String Limbi_straine;
	String Cunostinte;
	String Abilitati;

}
