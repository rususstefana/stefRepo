package org.app.service.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import static javax.persistence.FetchType.LAZY;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.JoinColumn;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.PrimaryKeyJoinColumn;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinColumns;

@Entity
public class Candidat {
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
		 
		 @OneToMany(mappedBy = "Candidat", cascade = ALL)
		 private List <Interviu> Interviu ;
		 
		 @OneToOne
		 private Profil Profil ;

		public Integer getId_Candidat() {
			return Id_Candidat;
		}

		public void setId_Candidat(Integer id_Candidat) {
			Id_Candidat = id_Candidat;
		}

		public String getNume() {
			return Nume;
		}

		public void setNume(String nume) {
			Nume = nume;
		}

		public String getPrenume() {
			return Prenume;
		}

		public void setPrenume(String prenume) {
			Prenume = prenume;
		}

		public String getSex() {
			return Sex;
		}

		public void setSex(String sex) {
			Sex = sex;
		}

		public Integer getVarsta() {
			return Varsta;
		}

		public void setVarsta(Integer varsta) {
			Varsta = varsta;
		}

		public Integer getTelefon() {
			return Telefon;
		}

		public void setTelefon(Integer telefon) {
			Telefon = telefon;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getPozitia() {
			return Pozitia;
		}

		public void setPozitia(String pozitia) {
			Pozitia = pozitia;
		}

		public String getDetalii() {
			return Detalii;
		}

		public void setDetalii(String detalii) {
			Detalii = detalii;
		}

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
		 
		 
}
