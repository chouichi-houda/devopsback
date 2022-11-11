package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;

//@SpringBootTest

@ExtendWith(SpringExtension.class)

public class FournisseurServiceImplTest {

	
	
	@Mock
	private FournisseurRepository FournisseurRepository;
	private Fournisseur Fournisseur1 = new Fournisseur(1L,"test" ,"test2",null,null,null,null);
	private Fournisseur Fournisseur2 = new Fournisseur(2L,"testt" ,"testtt2",null,null,null,null);
	
	@InjectMocks
	FournisseurServiceImpl FourniseurService;
	
	@Test
	@Order(1)
	public void addFournisseurTest() {
    	when(FournisseurRepository.save(Fournisseur1)).thenReturn(Fournisseur1);
    	assertNotNull(Fournisseur1);
    	
    	Fournisseur persisted = FourniseurService.addFournisseur(Fournisseur1);
		assertEquals(Fournisseur1, persisted); 
    	
		System.out.println("add Fournisseur works !");
	}
	
	 @Test 
	 @Order(2)
	    public void retrieveAllFournisseurTest() {
	    	when(FournisseurRepository.findAll()).thenReturn(Stream
	    			.of(Fournisseur1,Fournisseur2)
	    			.collect(Collectors.toList()));
	    	
	    	assertEquals(2,FourniseurService.retrieveAllFournisseurs().size());
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
	 @Order(3)
	    public void retrieveFournisseurTest() {
	    	when(FournisseurRepository.findById(Fournisseur1.getIdFournisseur())).thenReturn(Optional.of(Fournisseur1));
	    	assertEquals(Fournisseur1, FourniseurService.retrieveFournisseur(Fournisseur1.getIdFournisseur()));
	    	System.out.println("Retrieve operator by id works !");
	    }
	
	 @Test
	 @Order(4)
		public void deleteFournisseurTest() {
			Fournisseur f = new Fournisseur();
			Fournisseur savedFournisseur= FourniseurService.addFournisseur(f);
			FourniseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());
			assertNull(FourniseurService.retrieveFournisseur(savedFournisseur.getIdFournisseur()));
		}

	 
	 
}


