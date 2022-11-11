package com.esprit.examen.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.esprit.examen.dto.SecteurActiviteDto;
import com.esprit.examen.entities.SecteurActivite;

public class SecteurActiviteConverter {
	public SecteurActiviteDto convertEntityToDto(SecteurActivite secteurActivite) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(secteurActivite, SecteurActiviteDto.class);
        
    }
	public List<SecteurActiviteDto> convertEntitiesToDtos(List<SecteurActivite> secteurActivites) {
		List<SecteurActiviteDto> allSecteurActiviteDto = new ArrayList<>();
		for (SecteurActivite secteurActivite :secteurActivites ) {
			allSecteurActiviteDto.add(convertEntityToDto(secteurActivite));
		}
        return allSecteurActiviteDto;
    }

    public SecteurActivite convertDtoToEntity(SecteurActiviteDto secteurActiviteDto) {
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(secteurActiviteDto, SecteurActivite.class);
        
    }
}
