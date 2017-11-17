package org.app.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Candidat {
		@Id
		Integer Id_Candidat;
		String Nume;
		String Prenume;
		String Sex;
		Integer Varsta;
		Integer Telefon; 
		String Email;
		String Pozitia;
		String Detalii;

}
