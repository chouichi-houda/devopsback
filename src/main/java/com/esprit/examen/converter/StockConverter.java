package com.esprit.examen.converter;

import com.esprit.examen.dto.StockDto;
import com.esprit.examen.entities.Stock;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class StockConverter {
	
	public StockDto convertEntityToDto(Stock s) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(s, StockDto.class);
        
    }
	
	public List<StockDto> convertEntitiesToDtos(List<Stock> stocks) {
		List<StockDto> allStockDto = new ArrayList();
		for (Stock s :stocks ) {
			allStockDto.add(convertEntityToDto(s));
		}
        return allStockDto;
    }
	
	
	 public Stock convertDtoToEntity(StockDto stockDto) {
	        ModelMapper modelMapper = new ModelMapper();
	        return  modelMapper.map(stockDto, Stock.class);
	        
	    }


}
