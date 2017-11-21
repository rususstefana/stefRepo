package org.app.service.ejb.test;

import java.util.logging.Logger;

import javax.ejb.EJB;

import org.app.patterns.EntityRepository;
import org.app.service.ejb.CandidatService;
import org.app.service.ejb.DataService;
import org.app.service.ejb.DataServiceEJB;
import org.app.service.entities.Candidat;
import org.app.service.entities.EntityBase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)

public class TestCandidatServiceEBJ {
	
private static Logger logger = Logger.getLogger(TestCandidatServiceEBJ.class.getName());
	
	// Arquilian infrastructure
	@EJB
	private static CandidatService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}	
	
	@Deployment
	public static Archive<?> createDeployment() {
	        return ShrinkWrap
	                .create(WebArchive.class, "MSD.war")
	                .addPackage(EntityRepository.class.getPackage())
	                .addPackage(DataService.class.getPackage())
	                .addPackage(EntityBase.class.getPackage())
	                .addAsResource("META-INF/persistence.xml")
	                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	   }
	
	@Test
	public void test_addCandidat() {
		logger.info("DEBUG: test_addCandidat ...");
		Integer nr=5;
		for(int i=0;i<nr;i++)
		{
			service.addCandidat(new Candidat(null,"Nume_"+i));
		}
		assertNotNull("Data Service failed!", this.service);
		logger.info("DEBUG: test_addCandidat ...complete");
	}

   // @Test 
  
}
