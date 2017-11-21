package org.app.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Liceu {
	@Id
  private Integer id_liceu;
  private String nume_liceu;
  
  @OneToOne
  private Studii Studii ;

public Integer getId_liceu() {
	return id_liceu;
}

public void setId_liceu(Integer id_liceu) {
	this.id_liceu = id_liceu;
}

public String getNume_liceu() {
	return nume_liceu;
}

public void setNume_liceu(String nume_liceu) {
	this.nume_liceu = nume_liceu;
}

public Studii getStudii() {
	return Studii;
}

public void setStudii(Studii studii) {
	Studii = studii;
}
  
}
