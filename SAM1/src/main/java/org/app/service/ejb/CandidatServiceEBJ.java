package org.app.service.ejb;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.app.service.entities.Candidat;
import org.jboss.logging.Logger;

@Stateless @LocalBean
public class CandidatServiceEBJ implements CandidatService {
  private static Logger logger = Logger.getLogger(Candidat.class);
  
  @PersistenceContext(unitName="MSD")
  private EntityManager em; 
  
  public CandidatServiceEBJ() {
	  
  }
  public void init () {
	  logger.info ("POSTCONSTRUCT-INIT : " + this.em);
	  
  }
		  
	@Override
	public Candidat addCandidat(Candidat candidatToAdd) {
		em.persist(candidatToAdd);
		em.flush();
		em.refresh(candidatToAdd);
		return candidatToAdd;
	}

	@Override
	public Candidat updateCandidat(Candidat candidatToUpdate) {
		em.merge(candidatToUpdate);
		
		return candidatToUpdate;
	}

	@Override
	public String removeCandidat(Candidat candidatToDelete) {
		candidatToDelete=em.merge(candidatToDelete);
		em.remove(candidatToDelete);
		em.flush();
		return "True";
	}

	@Override
	public Candidat getCandidatByCandidatID(Integer candidatID) {
		return em.find(Candidat.class, candidatID);
	}

	@Override
	public Collection<Candidat> getCandidat() {
		List<Candidat> candidat =em.createQuery("SELECT c FROM Candidat" , Candidat.class)
		.getResultList();
	   return candidat;
	}

}
