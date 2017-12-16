package org.app.service.ejb;

import java.util.Collection;

import javax.ejb.Remote;

import org.app.service.entities.Interviu;

@Remote

public interface InterviuService {

	//Create
	
       Interviu  addInterviu (Interviu interviuToAdd);
       
       Collection<Interviu> addIntoInterviuri(Interviu interviuToAdd) throws Exception;
	
	// Update
	   Interviu updateInterviu(Interviu interviuToUpdate);
	
	// Delete
	   Collection<Interviu> removeInterviu(Interviu  interviuToDelete );
	   
	   String remove (Integer id) throws Exception;
	
	// Read
	   Interviu  getInterviuByInterviuID(Integer interviuID);
	
	   Collection<Interviu> getInterviu();
	
	
	
	
}
