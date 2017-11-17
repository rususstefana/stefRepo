package org.app.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
	@Id
	Integer Id_Candidat;
	Boolean Proba_1;
	Boolean Proba_2;
	Boolean Test_psihologic;
	Boolean Test_limba_straina;


}
