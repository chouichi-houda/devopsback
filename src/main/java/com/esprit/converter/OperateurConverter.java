package com.esprit.converter;

import com.esprit.dto.OperateurDto;
import com.esprit.examen.entities.Operateur;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;

public class OperateurConverter {
	public OperateurDto  convertEntityToDto(Operateur operateur) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(operateur, OperateurDto.class);
        
    }
	public List<OperateurDto > convertEntitiesToDtos(List<Operateur> operateurs) {
		List<OperateurDto> allProduitDto = new ArrayList<>();
		for (Operateur oparateur :operateurs ) {
			allProduitDto.add(convertEntityToDto(oparateur));
		}
        return allProduitDto;
    }

    public Operateur convertDtoToEntity(OperateurDto  produitDto) {
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(produitDto, Operateur.class);
        
    }
}
