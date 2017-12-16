package org.app.service.ejb;

import java.util.Collection;

import javax.ejb.Remote;

import org.app.service.entities.Candidat;

@Remote
public interface CandidatService {

	//Create
	
	Candidat addCandidat(Candidat candidatToAdd);
	Collection<Candidat>addIntoCandidati(Candidat cadidatToAdd) throws Exception ;
	// Update
	Candidat updateCandidat(Candidat candidatToUpdate);
	
	// Delete
	Collection<Candidat> removeCandidat(Candidat candidatToDelete );
	String remove (Integer id) throws Exception;
	// Read
	Candidat getCandidatByCandidatID(Integer candidatID);
	
	Collection<Candidat> getCandidat();
	
}
