package org.app.service.ejb;

import java.util.Collection;

import javax.ejb.Remote;

import org.app.service.entities.Candidat;

@Remote
public interface CandidatService {

	//Create
	
	Candidat addCandidat(Candidat candidatToAdd);
	
	// Update
	Candidat updateCandidat(Candidat candidatToUpdate);
	
	// Delete
	String removeCandidat(Candidat candidatToDelete );
	
	// Read
	Candidat getCandidatByCandidatID(Integer candidatID);
	
	Collection<Candidat> getCandidat();
	
}
