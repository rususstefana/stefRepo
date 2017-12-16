package org.app.service.rest.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.app.patterns.EntityRepository;
import org.app.patterns.EntityRepositoryBase;
import org.app.service.ejb.InterviuService;
import org.app.service.ejb.InterviuServiceEBJ;
import org.app.service.entities.Candidat;
import org.app.service.entities.Interviu;
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
public class TestInterviuDataServiceRESTArq {
	private static Logger logger= Logger.getLogger(TestInterviuDataServiceRESTArq.class.getName());
	private static String serviceURL = "http://localhost:8080/SAM/data/interviuri";

	@Deployment
	public static Archive<?>createDeployment (){
		return ShrinkWrap
				.create(WebArchive.class)
				.addPackage(Interviu.class.getPackage())
				.addClass(InterviuService.class)
				.addClass(InterviuServiceEBJ.class)
				.addClass(EntityRepository.class)
				.addClass(EntityRepositoryBase.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");		
		
	}
	
	    //@Test
		public void test1_getInterviuri () throws Exception{
			logger.info("DEBUG: Junit TESTING: test1_getInterviuri... ");
			Collection<Interviu> interviuri = ClientBuilder.newClient()
					.target(serviceURL)
					.request().get()
					.readEntity(new GenericType<Collection<Interviu>>() {});
			       assertTrue("Fail to read Candidati!", interviuri.size()>0);
			       interviuri.stream().forEach(System.out::println);
			
		}

	    //@Test
		public void test2_addInterviuri() throws ParseException {
			logger.info("DEBUG:Junit TESTING: test2_addInterviuri..." );
			Client client = ClientBuilder.newClient();
			Collection<Interviu> interviuri ;
			Integer nrOfInterviu = 5;
			Interviu interviu ;
			for (int i=1 ; i<nrOfInterviu ; i++) {
			    String sDate1="26/12/2017";  
			    String sDate2="28/12/2017";  
			    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
			    Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);  
				interviu = new Interviu (null,date1,date2,null);
				interviuri = client.target(serviceURL)
						.request().accept(MediaType.APPLICATION_JSON)
						.post(Entity.entity(interviu ,MediaType.APPLICATION_JSON))
						.readEntity(new GenericType<Collection<Interviu>>() {});	
			assertTrue ("Fail to read Interviuri!",interviuri.size()>=nrOfInterviu);
				}
			interviuri = client.target(serviceURL)
					.request().get()
					.readEntity(new GenericType<Collection<Interviu>>() {} );
			assertTrue ("Fail to add Interviuri" , interviuri.size()>=nrOfInterviu);
			 interviuri.stream().forEach(System.out::println);	
		}
	     //@Test
	     public void test3_DeleteInterviu() {
	    	 String resourceURL = serviceURL + "/60";
	    	 logger.info("DEBUG: Junit TESTING : test3_DeleteInterviu...");
	    	 Client client = ClientBuilder.newClient();
	    	 String Response ;
	    	 Response = client.target(resourceURL).request().delete().readEntity(String.class);
	    	 
	    	 logger.info(">>>>DEBUG:REST Response..." + Response);
	    	 assertTrue ("Is not deleted!" , Response.contains("True"));
	    	   	 
	     }

	     //@Test
	     public void test4_GetByID() {
	    	 
	    	 String resourceURL = serviceURL + "/1";
	    	 logger.info("DEBUG: Junit TESTING: t4_GetByID...");
	    	 Interviu interviu = ClientBuilder.newClient().target(resourceURL)
	    			 .request().accept(MediaType.APPLICATION_JSON)
	    			 .get().readEntity(Interviu.class);
	    	 assertNotNull("REST Data Service failed!",interviu);
	    	 logger.info(">>>DEBUG:REST Response..." + interviu);
	    	 }
	     
	     @Test
	     public void test5_UpdateInterviu() throws ParseException {
	    	 String resourceURL = serviceURL +"/3";
	    	 logger.info("**** DEBUG: Junit TESTING : test5_UpdateInterviu.....:"+resourceURL);
		    String sDate1="01/01/2018";  
		    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
	    	 Client client = ClientBuilder.newClient();
	    	 
	    	 Interviu interviu=client.target(resourceURL)
	    			 .request().accept(MediaType.APPLICATION_XML)
	    			 .get().readEntity(Interviu.class);
	    	 assertNotNull ("REST Data Service failed", interviu);
	    	 logger.info("Initial Company : " + interviu);
	    	 
	    	 interviu.setData_interviului(date1);
	    	 interviu=client.target(resourceURL)
	    			 .request().accept(MediaType.APPLICATION_XML).header("Content-Type", "application/xml")
	    			 .put(Entity.entity(interviu, MediaType.APPLICATION_XML))
	    			 .readEntity(Interviu.class);
	    	 logger.info(">>>Updated Candidat: "+ interviu);
	    	 assertNotNull("REST Data Service failed!" , interviu);
	     }
		
}
