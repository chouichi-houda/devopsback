package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

	@Mock
	StockRepository stockRepository;

	@InjectMocks
	StockServiceImpl stockService;

	Stock stock = new Stock(Long.valueOf(1), "f1", 10, 5, null);

	List<Stock> listStocks = new ArrayList<Stock>() {
		{
			add(new Stock(Long.valueOf(2), "f2", 20, 10, null));
			add(new Stock(Long.valueOf(3), "f3", 35, 30, null));
		}
	};

	
	@Test
	public void TestretrieveAllStocks() {

		Mockito.when(stockRepository.findAll()).thenReturn(listStocks);
		List<Stock> list = stockService.retrieveAllStocks();
		assertEquals(2, list.size());
		System.out.println("Retrieve all");
	}
	
	@Test
	public void testAddStock() {

		Mockito.when(stockRepository.save(stock)).thenReturn(stock);
		Stock stock1 = stockService.addStock(stock);
		Assertions.assertNotNull(stock1);
		System.out.println("added !");
	}
	
	
	@Test
	public void testUpdateStock() {
		stock.setLibelleStock("libelleUpdated");
		Mockito.when(stockRepository.save(stock)).thenReturn(stock);
		Stock stock1 = stockService.updateStock(stock);
		Assertions.assertEquals(stock.getLibelleStock(), stock1.getLibelleStock());
		System.out.println(stock1);
	}
	
	@Test
	public void testRetrieveStock() {

		Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
		Stock stock1 = stockService.retrieveStock(Long.valueOf(1));
		Assertions.assertNotNull(stock1);
		System.out.println("Retrieved !");
	}
	
	@Test
	public void testdeleteStock() {
		Stock stock1 = new Stock(Long.valueOf(4), "f5", 50, 15, null);
		stockService.deleteStock(stock1.getIdStock());
		Mockito.verify(stockRepository).deleteById(stock1.getIdStock());
		System.out.println("deleted");
	}
	
	

}
