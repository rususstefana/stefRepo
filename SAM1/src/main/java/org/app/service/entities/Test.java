package org.app.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Test {
	@Id
	 private Integer Id_Test;
	 private Boolean Proba_1;
	 private Boolean Proba_2;
	 private Boolean Test_psihologic;
	 private Boolean Test_limba_straina;
	public Integer getId_Test() {
		return Id_Test;
	}
	public void setId_Test(Integer id_Test) {
		Id_Test = id_Test;
	}
	public Boolean getProba_1() {
		return Proba_1;
	}
	public void setProba_1(Boolean proba_1) {
		Proba_1 = proba_1;
	}
	public Boolean getProba_2() {
		return Proba_2;
	}
	public void setProba_2(Boolean proba_2) {
		Proba_2 = proba_2;
	}
	public Boolean getTest_psihologic() {
		return Test_psihologic;
	}
	public void setTest_psihologic(Boolean test_psihologic) {
		Test_psihologic = test_psihologic;
	}
	public Boolean getTest_limba_straina() {
		return Test_limba_straina;
	}
	public void setTest_limba_straina(Boolean test_limba_straina) {
		Test_limba_straina = test_limba_straina;
	}
     
	 

}
