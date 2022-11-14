package com.esprit.examen.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.esprit.examen.dto.CategorieProduitDto;
import com.esprit.examen.entities.CategorieProduit;
@Component
public class CategorieProduitConverter {
	
	public CategorieProduitDto convertEntityToDto(CategorieProduit categorieProduit) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categorieProduit, CategorieProduitDto.class);
        
    }
	
	 public CategorieProduit convertDtoToEntity(CategorieProduitDto categorieProduitDto) {
	        ModelMapper modelMapper = new ModelMapper();
	        return  modelMapper.map(categorieProduitDto, CategorieProduit.class);
	        
	    }
	

}
