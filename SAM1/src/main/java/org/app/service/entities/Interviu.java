package org.app.service.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@XmlRootElement(name = "interviu")
@XmlAccessorType(XmlAccessType.NONE)
public class Interviu implements Serializable{
	@Id @GeneratedValue
	 private Integer Id_interviu;
	 private Date Data_aplicarii;
	 private Date Data_interviului;
	 @OneToOne
	 private Test Test ;
	 @ManyToOne
	private Candidat Candidat;
	 
	public Interviu(Integer id_interviu, Date data_aplicarii, Date data_interviului,
			org.app.service.entities.Candidat candidat) {
		super();
		Id_interviu = id_interviu;
		Data_aplicarii = data_aplicarii;
		Data_interviului = data_interviului;
		Candidat = candidat;
	}
	@XmlElement
	public Integer getId_interviu() {
		return Id_interviu;
	}
	public void setId_interviu(Integer id_interviu) {
		Id_interviu = id_interviu;
	}
	@XmlElement
	public Date getData_aplicarii() {
		return Data_aplicarii;
	}
	public void setData_aplicarii(Date data_aplicarii) {
		Data_aplicarii = data_aplicarii;
	}
	@XmlElement
	public Date getData_interviului() {
		return Data_interviului;
	}
	public void setData_interviului(Date data_interviului) {
		Data_interviului = data_interviului;
	}
	public Test getTest() {
		return Test;
	}
	public void setTest(Test test) {
		Test = test;
	}
	//@XmlElementWrapper(name = "candidati") @XmlElement(name = "candidat")
	public Candidat getCandidat() {
		return Candidat;
	}
	public void setCandidat(Candidat candidat) {
		Candidat = candidat;
	}
	
	public Interviu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String BASE_URL = "http://localhost:8080/SAM/data/interviuri";
	
	@XmlElement(name="link")
	public AtomLink getLink() throws Exception
	{
		String restUrl = BASE_URL + "/" + this.getId_interviu();
		return new AtomLink(restUrl,"get-Company");
	}
	public void setLink(AtomLink link) {}
}
