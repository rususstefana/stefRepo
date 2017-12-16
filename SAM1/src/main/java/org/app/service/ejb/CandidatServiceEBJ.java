package org.app.service.ejb;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.app.service.entities.Candidat;
import org.jboss.logging.Logger;

@Path("candidati")
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
	@PUT @Path("/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)	  
	@Override
	public Candidat addCandidat(Candidat candidatToAdd) {
		if(candidatToAdd.getId_Candidat() == null || this.getCandidatByCandidatID(candidatToAdd.getId_Candidat()) == null)
		{
			em.persist(candidatToAdd);
			em.flush();
			em.refresh(candidatToAdd);
		}
		else
		{
			em.merge(candidatToAdd);
		}
		return candidatToAdd;
	}

	@Override
	public Candidat updateCandidat(Candidat candidatToUpdate) {
		em.merge(candidatToUpdate);
		
		return candidatToUpdate;
	}

	@DELETE
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)	
	@Override
	public Collection<Candidat> removeCandidat(Candidat candidatToDelete) {
		candidatToDelete=em.merge(candidatToDelete);
		em.remove(candidatToDelete);
		em.flush();
		return this.getCandidat();
	}
	
	@GET @Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Override
	public Candidat getCandidatByCandidatID(@PathParam("id")Integer candidatID) {
		return em.find(Candidat.class, candidatID);
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Override
	public Collection<Candidat> getCandidat() {
		List<Candidat> candidat =em.createQuery("SELECT c FROM Candidat c" , Candidat.class)
		.getResultList();
	   return candidat;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Override
	public Collection<Candidat> addIntoCandidati(Candidat cadidatToAdd) throws Exception {
		this.addCandidat(cadidatToAdd);
		return this.getCandidat();
	}
	
	@DELETE @Path("/{id}")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)	
	@Override
	public String remove(@PathParam ("id")Integer id) throws Exception {
		Candidat candidat =this.getCandidatByCandidatID(id);
		em.remove(candidat);
		return "True";
	}

}
