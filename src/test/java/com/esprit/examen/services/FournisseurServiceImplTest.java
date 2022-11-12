package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
//@SpringBootTest
@ExtendWith(SpringExtension.class)
class FournisseurServiceImplTest {
	

	@InjectMocks
	FournisseurServiceImpl fournisseurService;

	
    @Mock
    private FournisseurRepository fournisseurRepository;
    
	private Fournisseur Fournisseur1 = new Fournisseur(1L,"test" ,"test2",null,null,null,null);
	private Fournisseur Fournisseur2 = new Fournisseur(2L,"testt" ,"testtt2",null,null,null,null);
	
	
	@Test
	 void addFournisseurTest() {
    	when(fournisseurRepository.save(Fournisseur1)).thenReturn(Fournisseur1);
    	assertNotNull(Fournisseur1);
    	
    	Fournisseur persisted = fournisseurService.addFournisseur(Fournisseur1);
		assertEquals(Fournisseur1, persisted); 
    	
		System.out.println("add Fournisseur works !");
	}
	
	 @Test 
	     void retrieveAllFournisseurTest() {
	    	when(fournisseurRepository.findAll()).thenReturn(Stream
	    			.of(Fournisseur1,Fournisseur2)
	    			.collect(Collectors.toList()));
	    	
	    	assertEquals(2,fournisseurService.retrieveAllFournisseurs().size());
	    	System.out.println("Retrieve all Fournisseur works !");
	    }
	 
	 /*@Test 
	    public void UpdateFournisseurTest() {
	    	when(FournisseurRepository.save(Fournisseur1)).thenReturn(Fournisseur1);
	    	assertNotNull(Fournisseur1);
	    	assertEquals(Fournisseur1, FourniseurService.updateFournisseur(Fournisseur1));
	    	System.out.println("Update operators works!");
	    }*/

	 @Test
	     void retrieveFournisseurTest() {
	    	when(fournisseurRepository.findById(Fournisseur1.getIdFournisseur())).thenReturn(Optional.of(Fournisseur1));
	    	assertEquals(Fournisseur1, fournisseurService.retrieveFournisseur(Fournisseur1.getIdFournisseur()));
	    	System.out.println("Retrieve operator by id works !");
	    }
	 
	 
	 
	 
}
