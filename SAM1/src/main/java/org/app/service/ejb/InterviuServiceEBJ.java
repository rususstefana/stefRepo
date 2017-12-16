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

import org.app.service.entities.Interviu;
import org.jboss.logging.Logger;

@Path("interviuri")
@Stateless @LocalBean
public class InterviuServiceEBJ implements InterviuService {
	 private static Logger logger = Logger.getLogger(Interviu.class);
	  
	  @PersistenceContext(unitName="MSD")
	  private EntityManager em; 
	
	
	public InterviuServiceEBJ() {
		
	}
		
	  public void init () {
		  logger.info ("POSTCONSTRUCT-INIT : " + this.em);
	  }

	@PUT @Path("/{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@Override
	public Interviu addInterviu(Interviu interviuToAdd) {
		if(interviuToAdd.getId_interviu() == null || this.getInterviuByInterviuID(interviuToAdd.getId_interviu()) == null)
		{
			em.persist(interviuToAdd);
			em.flush();
			em.refresh(interviuToAdd);
		}
		else
		{
			em.merge(interviuToAdd);
		}
		return interviuToAdd;
	}

	@Override
	public Interviu updateInterviu(Interviu interviuToUpdate) {
        em.merge(interviuToUpdate);
		
		return interviuToUpdate;
	}

	@DELETE
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@Override
	public Collection<Interviu> removeInterviu(Interviu interviuToDelete) {
		interviuToDelete=em.merge(interviuToDelete);
		em.remove(interviuToDelete);
		em.flush();
		return this.getInterviu();
	}

	@GET @Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Override
	public Interviu getInterviuByInterviuID(@PathParam("id")Integer interviuID) {
		return em.find(Interviu.class, interviuID);
	}
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Override
	public Collection<Interviu> getInterviu() {
		List<Interviu> interviu =em.createQuery("SELECT i FROM Interviu i" , Interviu.class)
				.getResultList();
			   return interviu;
	}

	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Override
	public Collection<Interviu> addIntoInterviuri(Interviu interviuToAdd) throws Exception {
		this.addInterviu(interviuToAdd);
		return this.getInterviu();
	}

	@DELETE @Path("/{id}")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@Override
	public String remove(@PathParam("id")Integer id) throws Exception {
		Interviu interviu = this.getInterviuByInterviuID(id);
		em.remove(interviu);
		return "True";
	}

}
