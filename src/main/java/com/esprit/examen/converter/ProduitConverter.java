package com.esprit.examen.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.esprit.examen.dto.ProduitDto;
import com.esprit.examen.entities.Produit;
@Component
public class ProduitConverter {

	public ProduitDto convertEntityToDto(Produit produit) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(produit, ProduitDto.class);
        
    }
	public List<ProduitDto> convertEntitiesToDtos(List<Produit> produits) {
		List<ProduitDto> allProduitDto = new ArrayList<>();
		for (Produit produit :produits ) {
			allProduitDto.add(convertEntityToDto(produit));
		}
        return allProduitDto;
    }

    public Produit convertDtoToEntity(ProduitDto produitDto) {
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(produitDto, Produit.class);
        
    }
}
