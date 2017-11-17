package org.app.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Studii {
	@Id
	Integer Id_Candidat;
	String Calificari;
	String Doctorat;
	String Master;
	String Licenta;
	String Liceu;
}
