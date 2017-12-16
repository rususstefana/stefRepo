package org.app.service.rest.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.app.patterns.EntityRepository;
import org.app.patterns.EntityRepositoryBase;
import org.app.service.ejb.CandidatService;
import org.app.service.ejb.CandidatServiceEBJ;
import org.app.service.entities.Candidat;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCandidatDataServiceRESTArq {
	private static Logger logger= Logger.getLogger(TestCandidatDataServiceRESTArq.class.getName());
	private static String serviceURL = "http://localhost:8080/SAM/data/candidati";
	
	@Deployment
	public static Archive<?>createDeployment (){
		return ShrinkWrap
				.create(WebArchive.class)
				.addPackage(Candidat.class.getPackage())
				.addClass(CandidatService.class)
				.addClass(CandidatServiceEBJ.class)
				.addClass(EntityRepository.class)
				.addClass(EntityRepositoryBase.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");		
		
	}
	
	//@Test
	public void test1_getCandidati () throws Exception{
		logger.info("DEBUG: Junit TESTING: test1_getCandidati... ");
		Collection<Candidat> candidati = ClientBuilder.newClient()
				.target(serviceURL)
				.request().get()
				.readEntity(new GenericType<Collection<Candidat>>() {});
		       assertTrue("Fail to read Candidati!", candidati.size()>0);
		       candidati.stream().forEach(System.out::println);
		
	}

    //@Test
	public void test2_addCandidati() {
		logger.info("DEBUG:Junit TESTING: test2_addCandidati..." );
		Client client = ClientBuilder.newClient();
		Collection<Candidat> candidati ;
		Integer nrOfCandidat = 5;
		Candidat candidat ;
		for (int i=1 ; i<nrOfCandidat ; i++) {
			candidat = new Candidat (null , "NewCandidat_"+i);
			candidati = client.target(serviceURL)
					.request().accept(MediaType.APPLICATION_JSON)
					.post(Entity.entity(candidat ,MediaType.APPLICATION_JSON))
					.readEntity(new GenericType<Collection<Candidat>>() {});	
		assertTrue ("Fail to read Candidati!",candidati.size()>=nrOfCandidat);
			}
		candidati = client.target(serviceURL)
				.request().get()
				.readEntity(new GenericType<Collection<Candidat>>() {} );
		 assertTrue ("Fail to add Candidat" , candidati.size()>=nrOfCandidat);
		 candidati.stream().forEach(System.out::println);	
	}
     //@Test
     public void test3_DeleteCandidat() {
    	 String resourceURL = serviceURL + "/42";
    	 logger.info("DEBUG: Junit TESTING : test3_DeleteCandidat...");
    	 Client client = ClientBuilder.newClient();
    	 String Response ;
    	 Response = client.target(resourceURL).request().delete().readEntity(String.class);
    	 
    	 logger.info(">>>>DEBUG:REST Response..." + Response);
    	 assertTrue ("Is not deleted!" , Response.contains("True"));
    	   	 
     }

     //@Test
     public void test4_GetByID() {
    	 
    	 String resourceURL = serviceURL + "/41";
    	 logger.info("DEBUG: Junit TESTING: t4_GetByID...");
    	 Candidat candidat = ClientBuilder.newClient().target(resourceURL)
    			 .request().accept(MediaType.APPLICATION_JSON)
    			 .get().readEntity(Candidat.class);
    	 assertNotNull("REST Data Service failed!",candidat);
    	 logger.info(">>>DEBUG:REST Response..." + candidat);
    	 }
     
     //@Test
     public void test5_UpdateCandidat() {
    	 String resourceURL = serviceURL +"/3";
    	 logger.info("**** DEBUG: Junit TESTING : test5_UpdateCandidat.....:"+resourceURL);
    	 Client client = ClientBuilder.newClient();
    	 
    	 Candidat candidat=client.target(resourceURL)
    			 .request().accept(MediaType.APPLICATION_XML)
    			 .get().readEntity(Candidat.class);
    	 assertNotNull ("REST Data Service failed", candidat);
    	 logger.info("Initial Company : " + candidat);
    	 
    	 candidat.setNume(candidat.getNume()+" _Update_Name");
    	 candidat=client.target(resourceURL)
    			 .request().accept(MediaType.APPLICATION_XML).header("Content-Type", "application/xml")
    			 .put(Entity.entity(candidat, MediaType.APPLICATION_XML))
    			 .readEntity(Candidat.class);
    	 logger.info(">>>Updated Candidat: "+ candidat);
    	 assertNotNull("REST Data Service failed!" , candidat);
     }
	
}

