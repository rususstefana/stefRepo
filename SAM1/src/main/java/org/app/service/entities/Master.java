package org.app.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Master {
	@Id
  private Integer id_master;
  private String nume_master;
  
  @ManyToOne
  private Studii Studii;

public Integer getId_master() {
	return id_master;
}

public void setId_master(Integer id_master) {
	this.id_master = id_master;
}

public String getNume_master() {
	return nume_master;
}

public void setNume_master(String nume_master) {
	this.nume_master = nume_master;
}

public Studii getStudii() {
	return Studii;
}

public void setStudii(Studii studii) {
	Studii = studii;
}
  
  
}
