package org.app.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Doctorat {
	@Id
  private Integer id_doctorat;
  private String nume_doctorat;
  
  @ManyToOne
  private Studii Studii;

public Integer getId_doctorat() {
	return id_doctorat;
}

public void setId_doctorat(Integer id_doctorat) {
	this.id_doctorat = id_doctorat;
}

public String getNume_doctorat() {
	return nume_doctorat;
}

public void setNume_doctorat(String nume_doctorat) {
	this.nume_doctorat = nume_doctorat;
}

public Studii getStudii() {
	return Studii;
}

public void setStudii(Studii studii) {
	Studii = studii;
} 
  
}
