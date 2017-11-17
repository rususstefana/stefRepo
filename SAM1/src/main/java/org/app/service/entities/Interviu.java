package org.app.service.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Interviu {
	@Id
	Integer Id_Candidat;
	Date Data_aplicarii;
	Date Data_interviului;

}
