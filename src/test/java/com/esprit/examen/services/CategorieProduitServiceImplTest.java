package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;

@SpringBootTest(classes = TpAchatProjectApplication.class)
@RunWith(MockitoJUnitRunner.class)
public class CategorieProduitServiceImplTest {

	@Mock
	CategorieProduitRepository categorieProduitRepository;

	@InjectMocks
	CategorieProduitServiceImpl CategorieProduitServiceImpl;

	CategorieProduit categorieProduit = new CategorieProduit(Long.valueOf(1), "123", "f1", null);

	List<CategorieProduit> listCategorieProduit = new ArrayList<CategorieProduit>() {
		{
			add(new CategorieProduit(Long.valueOf(2), "456", "f2", null));
			add(new CategorieProduit(Long.valueOf(3), "789", "f3", null));
		}
	};
	
	@Test
	public void TestretrieveAllStocks() {

		Mockito.when(categorieProduitRepository.findAll()).thenReturn(listCategorieProduit);
		List<CategorieProduit> list = CategorieProduitServiceImpl.retrieveAllCategorieProduits();
		assertEquals(2, list.size());
		System.out.println("Retrieve all");
	}
	
	@Test
	public void testAddStock() {

		Mockito.when(categorieProduitRepository.save(categorieProduit)).thenReturn(categorieProduit);
		CategorieProduit categorieProduit1 = CategorieProduitServiceImpl.addCategorieProduit(categorieProduit);
		Assertions.assertNotNull(categorieProduit1);
		System.out.println("added !");
	}
	
	@Test
	public void testdeleteStock() {
		CategorieProduit categorieProduit1 = new CategorieProduit(Long.valueOf(4), "741", "f4", null);
		CategorieProduitServiceImpl.deleteCategorieProduit(categorieProduit1.getIdCategorieProduit());
		Mockito.verify(categorieProduitRepository).deleteById(categorieProduit1.getIdCategorieProduit());
		System.out.println("deleted");
	}
	
	@Test
	public void testUpdateStock() {
		categorieProduit.setLibelleCategorie("libelleUpdated");
		Mockito.when(categorieProduitRepository.save(categorieProduit)).thenReturn(categorieProduit);
		CategorieProduit categorieProduit1 = CategorieProduitServiceImpl.updateCategorieProduit(categorieProduit);
		Assertions.assertEquals(categorieProduit.getLibelleCategorie(), categorieProduit1.getLibelleCategorie());
		System.out.println(categorieProduit1);
	}
	
	@Test
	public void testRetrieveStock() {

		Mockito.when(categorieProduitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categorieProduit));
		CategorieProduit categorieProduit1 = CategorieProduitServiceImpl.retrieveCategorieProduit(Long.valueOf(1));
		Assertions.assertNotNull(categorieProduit1);
		System.out.println("Retrieved !");
	}
}
