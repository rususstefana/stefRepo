package org.app.service.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.JoinColumn;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinColumns;

@XmlRootElement(name = "candidat")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
public class Candidat implements Serializable{
		 @Id @GeneratedValue 
		 private Integer Id_Candidat;
		 private String Nume;
		 private String Prenume;
		 private String Sex;
		 private Integer Varsta;
		 private Integer Telefon; 
		 private String Email;
		 private String Pozitia;
		 private String Detalii;
		 
		 @OneToMany(mappedBy = "Candidat", cascade = ALL, fetch = EAGER, orphanRemoval = true)
		 private List <Interviu> Interviu ;
		 
		 @OneToOne
		 private Profil Profil ;

		 @XmlElement
		public Integer getId_Candidat() {
			return Id_Candidat;
		}

		public void setId_Candidat(Integer id_Candidat) {
			Id_Candidat = id_Candidat;
		}
		@XmlElement
		public String getNume() {
			return Nume;
		}

		public void setNume(String nume) {
			Nume = nume;
		}
		@XmlElement
		public String getPrenume() {
			return Prenume;
		}

		public void setPrenume(String prenume) {
			Prenume = prenume;
		}
		@XmlElement
		public String getSex() {
			return Sex;
		}

		public void setSex(String sex) {
			Sex = sex;
		}
		@XmlElement
		public Integer getVarsta() {
			return Varsta;
		}

		public void setVarsta(Integer varsta) {
			Varsta = varsta;
		}
		@XmlElement
		public Integer getTelefon() {
			return Telefon;
		}

		public void setTelefon(Integer telefon) {
			Telefon = telefon;
		}
		@XmlElement
		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}
		@XmlElement
		public String getPozitia() {
			return Pozitia;
		}
		
		public void setPozitia(String pozitia) {
			Pozitia = pozitia;
		}
		@XmlElement
		public String getDetalii() {
			return Detalii;
		}

		public void setDetalii(String detalii) {
			Detalii = detalii;
		}

		@XmlElementWrapper(name = "interviuri") @XmlElement(name = "interviu")
		public List<Interviu> getInterviu() {
			return Interviu;
		}

		public void setInterviu(List<Interviu> interviu) {
			Interviu = interviu;
		}

		public Profil getProfil() {
			return Profil;
		}

		public void setProfil(Profil profil) {
			Profil = profil;
		}

		public Candidat(Integer id_Candidat, String nume) {
			super();
			Id_Candidat = id_Candidat;
			Nume = nume;
		}

		public Candidat() {
			super();
			// TODO Auto-generated constructor stub
		}	
		public static String BASE_URL = "http://localhost:8080/SAM/data/candidati";
		
		@XmlElement(name="link")
		public AtomLink getLink() throws Exception
		{
			String restUrl = BASE_URL + "/" + this.getId_Candidat();
			return new AtomLink(restUrl,"get-Company");
		}
		public void setLink(AtomLink link) {}
}
