package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SecteurActiviteServiceImplTest {
	@Mock
	SecteurActiviteRepository SecteurRepository;
	
	@InjectMocks
	SecteurActiviteServiceImpl SecteurService;
	
	SecteurActivite s = new SecteurActivite(Long.valueOf(1), "11111","BUREATIQUE",null);
	   List<SecteurActivite> listSecteurActivites = new ArrayList<SecteurActivite>(){
	        {
	            add( new SecteurActivite(Long.valueOf(2), "11111","BUREATIQUE",null));
	            add( new SecteurActivite(Long.valueOf(3), "11111","BUREATIQUE",null));
	        }
	     
	    };
	    
	@Test
	@Order(1)
	public void testRetrieveSecteurActivite() {	
	Mockito.when(SecteurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
	SecteurActivite s1 = SecteurService.retrieveSecteurActivite(Long.valueOf(1));
	Assertions.assertNotNull(s1);
	
	System.out.println(s1);	
	System.out.println(s);
	}
	
	@Test
	@Order(2)
	public void testAddSecteurActivite()
	{
		Mockito.when(SecteurRepository.save(s)).thenReturn(s);
		SecteurActivite s1 = SecteurService.addSecteurActivite(s);
        Assertions.assertNotNull(s1);
		
	}
	
	@Test
	@Order(3)
	public void testRetrieveAllSecteurActivite()
	{
	
		Mockito.when(SecteurRepository.findAll()).thenReturn(listSecteurActivites);
		List<SecteurActivite> sList = SecteurService.retrieveAllSecteurActivite();
		assertEquals(2, sList.size());
		
	}
	
	@Test
	@Order(4)
    public void testdeleteSecteurActivite() {
		SecteurActivite s2 = new SecteurActivite(Long.valueOf(4), "11111","BUREATIQUE",null);
		SecteurService.deleteSecteurActivite(s2.getIdSecteurActivite());
       Mockito.verify(SecteurRepository).deleteById(s2.getIdSecteurActivite());
       System.out.println("ok");
   }
	
	  @Test
		@Order(5)
	    public void testUpdateSecteurActivite() {
	        s.setLibelleSecteurActivite("ffffff");
	        Mockito.when(SecteurRepository.save(s)).thenReturn(s);
	        SecteurActivite s3 = SecteurService.updateSecteurActivite(s);
	        Assertions.assertEquals(s.getLibelleSecteurActivite(),s3.getLibelleSecteurActivite());
	        System.out.println(s3);
	    }
}
