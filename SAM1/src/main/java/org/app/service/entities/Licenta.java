package org.app.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Licenta{
	@Id
  private Integer id_licenta;
  private String nume_licenta;
  
  @ManyToOne
  private  Studii Studii;

public Integer getId_licenta() {
	return id_licenta;
}

public void setId_licenta(Integer id_licenta) {
	this.id_licenta = id_licenta;
}

public String getNume_licenta() {
	return nume_licenta;
}

public void setNume_licenta(String nume_licenta) {
	this.nume_licenta = nume_licenta;
}

public Studii getStudii() {
	return Studii;
}

public void setStudii(Studii studii) {
	Studii = studii;
}
  
  
}
