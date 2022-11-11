package com.esprit.examen.converter;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.esprit.examen.dto.ReglementDto;
import com.esprit.examen.entities.Reglement;

public class ReglementConverter {
	public ReglementDto convertEntityToDto(Reglement reglement) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(reglement, ReglementDto.class);
        
    }
	public List<ReglementDto> convertEntitiesToDtos(List<Reglement> reglements) {
		List<ReglementDto> allReglementDto = new ArrayList<>();
		for (Reglement reglement :reglements ) {
			allReglementDto.add(convertEntityToDto(reglement));
		}
        return allReglementDto;
    }

    public Reglement convertDtoToEntity(ReglementDto reglementDto) {
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(reglementDto, Reglement.class);
        
    }
}
